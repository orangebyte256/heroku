package bills

import akka.actor.ActorSelection.toScala
import akka.actor.PoisonPill
import play.api.libs.iteratee.Concurrent
import play.api.libs.iteratee.Iteratee
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.WebSocket
import play.libs.Akka
import play.api.libs.Crypto
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Calendar
import java.text.SimpleDateFormat
import java.io._
import scala.io.Source
import java.nio.file.{Paths, Files}
import java.sql.Connection
import java.sql.Statement
import org.apache.commons.dbcp2._
import java.net.URI

object Datasource {
  val dbUri = URI.create(System.getenv("DATABASE_URL"))
//  val dbUri = URI.create("postgres://vosmznehduasfl:mmzrzZin9-oLrpe14fWTLCd68g@ec2-54-227-255-240.compute-1.amazonaws.com:5432/d1mapjq5kjrpef")
//  val dbUrl = s"jdbc:postgresql://${dbUri.getHost}:${dbUri.getPort}${dbUri.getPath}?user=vosmznehduasfl&password=mmzrzZin9-oLrpe14fWTLCd68g&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory"
  val dbUrl = s"jdbc:postgresql://${dbUri.getHost}:${dbUri.getPort}${dbUri.getPath}"
  val connectionPool = new BasicDataSource()

  if (dbUri.getUserInfo != null) {
    connectionPool.setUsername(dbUri.getUserInfo.split(":")(0))
    connectionPool.setPassword(dbUri.getUserInfo.split(":")(1))
  }
  connectionPool.setDriverClassName("org.postgresql.Driver")
  connectionPool.setUrl(dbUrl)
  connectionPool.setInitialSize(3)

  val connection = connectionPool.getConnection
  val stmt = connection.createStatement()

  def create()
  {
    stmt.executeUpdate("DROP TABLE users;")
    stmt.executeUpdate("""CREATE TABLE users (
    id SERIAL PRIMARY KEY, 
    username text,
    password text,
    name text,
    dormitory int,
    room int);""")
 
    stmt.executeUpdate("DROP TABLE messages;")
    stmt.executeUpdate("""CREATE TABLE messages (
    room_id int,
    actor_id int,
    subject_id int,
    sum int,
    type text,
    date text,
    text text);""")

  }

  def insertUser(dormitory : Int, room : Int, name : String, username : String, password : String): Int = 
  {

    stmt.executeUpdate("INSERT INTO users(username,password,name,dormitory,room) VALUES (" + 
      "'" + username + "'," +
      "'" + password  + "'," +
      "'" + name  + "'," +
      dormitory.toString  + "," +
      room.toString + ");")
    val rs = stmt.executeQuery("SELECT id FROM users where username = '" + username + "';")
    rs.next()
    rs.getInt("id")
  }

  def insertMessage(actor_id : Int, subject_id : Int, get_sum : Int, type_message : String, date: String, message : String) 
  {

    var person = Manager.users.get(actor_id).get
    val room_id = Manager.getRoomNum(person.room_.roomInfo_.dormitory, person.room_.roomInfo_.num)
    stmt.executeUpdate("INSERT INTO messages VALUES (" + 
      room_id + "," +
      actor_id  + "," +
      subject_id  + "," +
      get_sum  + "," +
      "'" + type_message  + "'," +
      "'" + date + "'," +
      "'" + message + "');")
  }

}

object Global
{
  val hostIP = "https://quiet-wildwood-1547.herokuapp.com"
//  val hostIP = "http://localhost:9000"
  var encryptKey : String = "murmurnataly1994"
  val fileUsersName = "users.txt"
}

object Manager
{
  var rooms = collection.mutable.Map[RoomInfo, Room]()
  var users = collection.mutable.Map[Int, Person]()
  var passwords = collection.mutable.Map[String, String]()
  var names = collection.mutable.Map[String, Int]()

  def getRoomNum(dormitory : Int, room : Int) : Int = 
  {
      dormitory * 1009 + room
  }

  def getRoomFileHistory(dormitory : Int, room : Int) : String = 
  {
      return (getRoomNum(dormitory, room)).toString + "_history.txt"
  }

  def addPersonToBase(id : Int, dormitory : Int, room : Int, name : String, username : String, password : String)
  {    
      println(room + dormitory)
      if(!rooms.contains(RoomInfo(room, dormitory)))
      {
        println("i'm here")
        var room_object = new Room(RoomInfo(room, dormitory), getRoomNum(dormitory, room))
        var room_actor = Akka.system.actorOf(RoomActor.props(room_object), "room" + getRoomNum(dormitory, room).toString)
        rooms += (RoomInfo(room, dormitory) -> room_object)
      }
      println("error314")
      var room_object = rooms.get(RoomInfo(room, dormitory)).get
      var room_actor = Akka.system.actorSelection("/user/room" + getRoomNum(dormitory, room).toString)
      var person_object = new Person(room_object, name, id)
      users += (id -> person_object)
      room_actor ! addPerson(person_object)
      passwords += (username -> password)
      names += (username -> id)
  }

  def addEventAction(actor_id : Int, subject_id : Int, get_sum : Int, type_message : String, date: String, message : String)
  {
      var person = users.get(actor_id).get
      var subject : Person = CommonPerson
      var sum = get_sum
      if(type_message != "common")
      {
        subject = users.get(subject_id).get
      }
      if(type_message == "get")
      {
        sum = -sum;
      }
      var room_actor = Akka.system.actorSelection("/user/room" + getRoomNum(person.room_.roomInfo_.dormitory, person.room_.roomInfo_.num).toString)
      room_actor ! addEvent(person, subject, sum, date, message)  
  }

  def addUsersFromDB()
  {
    val connection = Datasource.connectionPool.getConnection
    val stmt = connection.createStatement()

    val rs = stmt.executeQuery("SELECT id,username,password,name,dormitory,room FROM users;")
    while (rs.next()) {
      addPersonToBase(rs.getInt("id"), rs.getInt("dormitory"), rs.getInt("room"), rs.getString("name"), rs.getString("username"), rs.getString("password"))
    }
  }

  def addMessagesFromDB()
  {
    val connection = Datasource.connectionPool.getConnection
    val stmt = connection.createStatement()
    val rs = stmt.executeQuery("SELECT actor_id,subject_id,sum,type,date,text FROM messages;")
    while (rs.next()) {
      addEventAction(rs.getInt("actor_id"), rs.getInt("subject_id"), rs.getInt("sum"), rs.getString("type"), rs.getString("date"), rs.getString("text"))
    }
  }


}

object BillsController extends Controller {
  Manager.addUsersFromDB
  Manager.addMessagesFromDB

  def login(reply: String = "") = Action
  {
      Ok(views.html.login.render(reply, Global.hostIP)).withNewSession
  }


  def answerMe() = Action
  {
    Datasource.create
    Ok("Ok")
  }

  def loginValidate = Action 
  {
    implicit request =>
    var name = request.getQueryString("username").get
    var password = request.getQueryString("password").get
    if ((!Manager.passwords.contains(name)) || (Manager.passwords.get(name).get != Crypto.encryptAES(password, Global.encryptKey)))
    {
      Redirect("/loginerror")
    }
    else
    {
      var id = Manager.names.get(name).get
      var person = Manager.users.get(id)
      Redirect("/").withSession(
        "user" -> id.toString)
//      Ok(views.html.index(person.get)).withSession(
//        "user" -> id.toString)
    }
  }

  def setEncryptKey(reply: String) = Action
  {
    if(Global.encryptKey == "unset")
    {
      Global.encryptKey = reply
      Ok("Успешно, Дима!")
    }
    else
    {
      Ok("Хуй тебе, мразь!")
    }
  }

  def register(reply: String = "") = Action
  {
      Ok(views.html.register(reply, Global.hostIP))
  }

  def okey() = Action
  {
    implicit request =>
    Ok(views.html.register("", Global.hostIP))
  }

  def registerValidate = Action 
  {
    implicit request =>
    var username = request.getQueryString("username").get
    println(username)
    if(Manager.names.contains(username))
    {
      Redirect("/registerreply")
    }
    else
    {
      var room = request.getQueryString("room").get.toInt
      var dormitory = request.getQueryString("dormitory").get.toInt
      println("gui")
      println(room)
      var name = request.getQueryString("name").get
      var password = request.getQueryString("password").get
      password = Crypto.encryptAES(password, Global.encryptKey)
      var id = Datasource.insertUser(dormitory, room, name, username, password)
      Manager.addPersonToBase(id, dormitory, room, name, username, password)
      Redirect("/login_")
    }
  }

  def index = Action { implicit request =>
    {
      var tmp_id = request.session.get("user")
      if (tmp_id == None)
      {
        Ok(views.html.login.render("", Global.hostIP))
      }
      else
      {
        var person = Manager.users.get(tmp_id.get.toInt)
        Ok(views.html.index(person.get, Global.hostIP))
      }
    }
  }

  def addEventAction = Action { implicit request =>
    {
      var actor = request.session.get("user").get.toInt
      var person = Manager.users.get(actor).get
      var type_message = request.getQueryString("type").get
      var subject = -1
      if(type_message != "common")
      {
        subject = request.getQueryString("subject").get.toInt
      }
      var sum = request.getQueryString("sum").get.toInt
      var message = request.getQueryString("message").get
      val format = new SimpleDateFormat("s-m-h:d-M-y")
      var date = format.format(Calendar.getInstance().getTime())
      Manager.addEventAction(actor, subject, sum, type_message, date, message)
      Datasource.insertMessage(actor, subject, sum, type_message, date, message)
      Redirect("/")
    }
  }
  

  def toInt(s: Option[String]): Int = {
    val intValue = try {
      Some(s.get.toInt)
    } catch {
      case e: Exception => None
    }
    intValue.getOrElse(-1)
  }

}
