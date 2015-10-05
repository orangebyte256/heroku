package bills

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.PoisonPill
import akka.actor.Props
import scala.math
import scala.language.postfixOps

case class Event(actor: Person, subject: Person, sum: Int, date: String, text: String);
case class addEvent(element: Person, subject: Person, sum: Int, date: String, text: String);
case class Relative(first: Person, second: Person, sum: Int);
case class RoomInfo(num : Int, dormitory : Int);


object RoomActor {
  def props(room : Room): Props = 
  {
    Props(new RoomActor(room))
  }
}

class RoomActor(room : Room)  extends Actor
{
  var room_ = room
  def receive = {
    case addPerson(person: Person) => {
      room_.addPerson(person)
      var person_actor = context.actorOf(PersonActor.props(person), "id" + person.id_.toString)
      var allPersons = context.actorSelection("/user/room" + room_.id_.toString + "/*")
      allPersons ! addPerson(person)
      for(i <- room_.members_)
      {
        person_actor ! addPerson(i)
      }
    }
    case addEvent(element: Person, CommonPerson, sum: Int, date: String, text: String) => {
      var element_actor = context.actorSelection("/user/room" + room_.id_.toString + "/id" + element.id_)
      var allPersons = context.actorSelection("/user/room" + room_.id_.toString + "/*")
      println("Hello world")
      element_actor ! new changeSum(CommonPerson, sum / (room_.members_.count(_ => true)))
      allPersons ! new changeSum(element, -sum / (room_.members_.count(_ => true)))
      room_.addEvent(Event(element, CommonPerson, sum, date, text))
    }
    case addEvent(element: Person, subject: Person, sum: Int, date: String, text: String) => {
      var element_actor = context.actorSelection("/user/room" + room_.id_.toString + "/id" + element.id_)
      var subject_actor = context.actorSelection("/user/room" + room_.id_.toString + "/id" + subject.id_)
      element_actor ! new changeSum(subject, sum)
      subject_actor ! new changeSum(element, -sum)
      println(element)
      println(subject)
      println(element.name_)
      println(subject.name_)
      room_.addEvent(Event(element, subject, sum, date, text))
    }
  }
}

class Room(roomInfo : RoomInfo, id : Int)
{
  var members_ = List[Person]()
  var roomInfo_ = roomInfo
  var history = new collection.mutable.Stack[Event]()
  var id_ = id
  def addPerson(person : Person)
  {
      members_ :::= List(person)
  }

  def addEvent(event : Event)
  {
      var loop: List[Person] = List()
      do
      {
        var relatives = makeRelatives()
        println("im in event bitch")
        println(relatives)
        for(element <- members_)
        {
          if(loop == List())
          {
            var tmp = pass(element, List[Person](), relatives)
            loop = tmp
          }
        }
        if(loop != List())
        {
          val min = findMin(loop)
          processList(loop, -min)
          loop = List()
        }
      }while(loop != List());
      history.push(event)
  }

  def getMessages(person: Person):collection.mutable.Stack[String] = 
  {
    val Fix_Person = person
    val result = history.map
    {
      case Event(actor, CommonPerson, sum, date, text) =>
      {
        var noun = actor.name_
        if(actor == person)
          noun = "Я "
        date + " " + noun + " купил " + text + " за " + math.abs(sum).toString
      }
      case Event(actor, Fix_Person, sum, date, text) => 
      {
        var verb : String = ""
        if(sum > 0)
          verb = " дал мне "
        else
          verb = " взял у меня " 
        date + " " + actor.name_ + verb + math.abs(sum).toString + " \"" + text + "\""
      }
      case Event(Fix_Person, actor, sum, date, text) => 
      {
        var verb : String = ""
        if(sum > 0)
          verb = "Я дал "
        else
          verb = "Я взял у "
        date + " " + verb + actor.name_ + " " + math.abs(sum).toString + " \"" + text + "\""
      }
      case _ => ""
    }
    result
  }

  def pass(element: Person, visited: List[Person], relatives: List[Relative]):List[Person] =
  {
    val Fix_Element = element
    var max : List[Person] = List()
    for(temp <- relatives)
    {
      temp match  {
        case Relative(Fix_Element, second, sum) =>
        {
          if(visited.exists(i => i == second))
          {
            val tmp_sum = visited.indexOf(second) + 2
            if(max.count(_ => true) < tmp_sum)
            {
              max = Fix_Element::visited
              max = max.slice(0, tmp_sum)
            }
          }
          else
          {
            val result = pass(second, Fix_Element::visited, relatives)
            if(max.count(_ => true) < result.count(_ => true))
            {
              max = result
            }
          }
        }
        case _ =>
        {

        }
      }
    }
    max
  }

  def makeRelatives():List[Relative] = 
  {
    var result : List[Relative] = List()
    for(first <- members_)
    {
      for(second <- members_)
      {
        if(first != second)
        {
          val sum = first.getSum(second)
          if(sum > 0)
          {
            result = Relative(first, second, sum)::result
          }
        }
      }
    }
    result
  }

  def processList(elements: List[Person], sum: Int)
  {
    val count = elements.count(_ => true)
    for(i <- 0 to count - 1)
    {
      members_(members_.indexOf(elements(count - 1 - i))).changeSum(elements(if((count - 2 - i) < 0) {count - 1} else {count - 2 - i}), sum)
      members_(members_.indexOf(elements(if((count - 2 - i) < 0) {count - 1} else {count - 2 - i}))).changeSum(elements(count - 1 - i), -sum)
    }
  }

  def findMin(elements: List[Person]):Int =
  {
    val count = elements.count(_ => true)
    var min = Int.MaxValue
    for(i <- 0 to count - 1)
    {
      var tmp = members_(members_.indexOf(elements(count - 1 - i))).getSum(elements(if((count - 2 - i) < 0) {count - 1} else {count - 2 - i}))
      if(tmp < min)
        min = tmp
    }
    min
  }


}
