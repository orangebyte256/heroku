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
import java.sql.DriverManager
import java.sql.Connection


object Global
{
  val hostIP = "https://quiet-wildwood-1547.herokuapp.com"
//  val hostIP = "http://localhost:9000"
  var encryptKey : String = "unset"
  val fileUsersName = "users.txt"
}

object Manager
{
  var rooms = collection.mutable.Map[RoomInfo, Room]()
  var users = collection.mutable.Map[Int, Person]()
  var passwords = collection.mutable.Map[String, String]()
  var names = collection.mutable.Map[String, Int]()
  var id = 0


  def getRoomNum(dormitory : Int, room : Int) : Int = 
  {
      dormitory * 1009 + room
  }

  def getRoomFileHistory(dormitory : Int, room : Int) : String = 
  {
      return (getRoomNum(dormitory, room)).toString + "_history.txt"
  }

  def addPersonToBase(dormitory : Int, room : Int, name : String, username : String, password : String)
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
      id = id + 1
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

  def connectToDataBase() : String = 
  {
    Class.forName("org.postgresql.Driver");
    println("good")
    val url = "jdbc:postgres://vosmznehduasfl:mmzrzZin9-oLrpe14fWTLCd68g@ec2-54-227-255-240.compute-1.amazonaws.com:5432/d1mapjq5kjrpef"
    val username = "vosmznehduasfl"
    val password = "mmzrzZin9-oLrpe14fWTLCd68g"

    // there's probably a better way to do this
    var connection:Connection = null
    var res : String = null
    try {
      // make the connection
      //      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      res = "Good"
      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT host, user FROM user")
      while ( resultSet.next() ) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }
    } catch {
      case e => {
        e.printStackTrace
        res = "Bad"
      }
    }
    connection.close()
    res
  }

}

object BillsController extends Controller {
  for (line <- Source.fromFile(Global.fileUsersName, "utf-8").getLines()) {
    val arr = line.split(" ")
    val name = arr.slice(4, arr.size)
    Manager.addPersonToBase(arr(0).toInt, arr(1).toInt, name.mkString(" "), arr(2), arr(3))
  }

  for(element <- Manager.rooms.keys)
  {
    val filename = Manager.getRoomFileHistory(element.dormitory,element.num)
    println(filename)
    try { 
      for (line <- Source.fromFile(filename, "utf-8").getLines()) 
      {
        val arr = line.split(" ")
        val message = arr.slice(5, arr.size)
        Manager.addEventAction(arr(0).toInt, arr(1).toInt, arr(2).toInt, arr(3), arr(4), message.mkString(" "))
      }
    } catch {
      case e: Exception => println("lol")
    }
  }
  println("error2")
  def login(reply: String = "") = Action
  {
      Ok(views.html.login.render(reply, Global.hostIP)).withNewSession
  }


  def answerMe() = Action
  {
    Ok(Manager.connectToDataBase())
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
      Manager.addPersonToBase(dormitory, room, name, username, password)
      var out = new BufferedWriter(new OutputStreamWriter(
      new FileOutputStream(Global.fileUsersName,true), "UTF-8"));
      try {
          out.write(dormitory + " " + room + " " + username + " " + password + " " + name);
          out.newLine();
      } finally {
          out.close();
      }
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
      var out = new BufferedWriter(new OutputStreamWriter(
      new FileOutputStream(Manager.getRoomFileHistory(person.room_.roomInfo_.dormitory, person.room_.roomInfo_.num),true), "UTF-8"));
      try {
          out.write(actor.toString + " " + subject.toString + " " + sum.toString + " " + type_message + " " + date + " " + message);
          out.newLine();
      } finally {
          out.close();
      }
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
