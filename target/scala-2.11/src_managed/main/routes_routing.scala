// @SOURCE:E:/temp/scalas/bills/conf/routes
// @HASH:ce49c9bfc5d480b5d9c7fe381d2cce3c03d264d9
// @DATE:Mon Oct 05 23:41:19 NOVT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:4
private[this] lazy val bills_BillsController_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val bills_BillsController_index0_invoker = createInvoker(
bills.BillsController.index,
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "index", Nil,"GET", """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~""", Routes.prefix + """"""))
        

// @LINE:5
private[this] lazy val bills_BillsController_registerValidate1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registerValidate"))))
private[this] lazy val bills_BillsController_registerValidate1_invoker = createInvoker(
bills.BillsController.registerValidate,
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "registerValidate", Nil,"GET", """""", Routes.prefix + """registerValidate"""))
        

// @LINE:6
private[this] lazy val bills_BillsController_register2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"),DynamicPart("info", """[^/]+""",true))))
private[this] lazy val bills_BillsController_register2_invoker = createInvoker(
bills.BillsController.register(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "register", Seq(classOf[String]),"GET", """""", Routes.prefix + """register$info<[^/]+>"""))
        

// @LINE:7
private[this] lazy val bills_BillsController_loginValidate3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("loginValidate"))))
private[this] lazy val bills_BillsController_loginValidate3_invoker = createInvoker(
bills.BillsController.loginValidate,
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "loginValidate", Nil,"GET", """""", Routes.prefix + """loginValidate"""))
        

// @LINE:8
private[this] lazy val bills_BillsController_login4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"),DynamicPart("info", """[^/]+""",true))))
private[this] lazy val bills_BillsController_login4_invoker = createInvoker(
bills.BillsController.login(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "login", Seq(classOf[String]),"GET", """""", Routes.prefix + """login$info<[^/]+>"""))
        

// @LINE:9
private[this] lazy val bills_BillsController_addEventAction5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addevent"))))
private[this] lazy val bills_BillsController_addEventAction5_invoker = createInvoker(
bills.BillsController.addEventAction,
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "addEventAction", Nil,"GET", """""", Routes.prefix + """addevent"""))
        

// @LINE:10
private[this] lazy val bills_BillsController_setEncryptKey6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("setEncryptKey"),DynamicPart("key", """[^/]+""",true))))
private[this] lazy val bills_BillsController_setEncryptKey6_invoker = createInvoker(
bills.BillsController.setEncryptKey(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "setEncryptKey", Seq(classOf[String]),"GET", """""", Routes.prefix + """setEncryptKey$key<[^/]+>"""))
        

// @LINE:11
private[this] lazy val bills_BillsController_answerMe7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("answerme"))))
private[this] lazy val bills_BillsController_answerMe7_invoker = createInvoker(
bills.BillsController.answerMe(),
HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "answerMe", Nil,"GET", """""", Routes.prefix + """answerme"""))
        

// @LINE:14
private[this] lazy val controllers_Assets_at8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at8_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:15
private[this] lazy val controllers_WebJarAssets_at9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("webjars/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_WebJarAssets_at9_invoker = createInvoker(
controllers.WebJarAssets.at(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.WebJarAssets", "at", Seq(classOf[String]),"GET", """""", Routes.prefix + """webjars/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""bills.BillsController.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registerValidate""","""bills.BillsController.registerValidate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register$info<[^/]+>""","""bills.BillsController.register(info:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """loginValidate""","""bills.BillsController.loginValidate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login$info<[^/]+>""","""bills.BillsController.login(info:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addevent""","""bills.BillsController.addEventAction"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """setEncryptKey$key<[^/]+>""","""bills.BillsController.setEncryptKey(key:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """answerme""","""bills.BillsController.answerMe()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""","""controllers.WebJarAssets.at(file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case bills_BillsController_index0_route(params) => {
   call { 
        bills_BillsController_index0_invoker.call(bills.BillsController.index)
   }
}
        

// @LINE:5
case bills_BillsController_registerValidate1_route(params) => {
   call { 
        bills_BillsController_registerValidate1_invoker.call(bills.BillsController.registerValidate)
   }
}
        

// @LINE:6
case bills_BillsController_register2_route(params) => {
   call(params.fromPath[String]("info", None)) { (info) =>
        bills_BillsController_register2_invoker.call(bills.BillsController.register(info))
   }
}
        

// @LINE:7
case bills_BillsController_loginValidate3_route(params) => {
   call { 
        bills_BillsController_loginValidate3_invoker.call(bills.BillsController.loginValidate)
   }
}
        

// @LINE:8
case bills_BillsController_login4_route(params) => {
   call(params.fromPath[String]("info", None)) { (info) =>
        bills_BillsController_login4_invoker.call(bills.BillsController.login(info))
   }
}
        

// @LINE:9
case bills_BillsController_addEventAction5_route(params) => {
   call { 
        bills_BillsController_addEventAction5_invoker.call(bills.BillsController.addEventAction)
   }
}
        

// @LINE:10
case bills_BillsController_setEncryptKey6_route(params) => {
   call(params.fromPath[String]("key", None)) { (key) =>
        bills_BillsController_setEncryptKey6_invoker.call(bills.BillsController.setEncryptKey(key))
   }
}
        

// @LINE:11
case bills_BillsController_answerMe7_route(params) => {
   call { 
        bills_BillsController_answerMe7_invoker.call(bills.BillsController.answerMe())
   }
}
        

// @LINE:14
case controllers_Assets_at8_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at8_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:15
case controllers_WebJarAssets_at9_route(params) => {
   call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at9_invoker.call(controllers.WebJarAssets.at(file))
   }
}
        
}

}
     