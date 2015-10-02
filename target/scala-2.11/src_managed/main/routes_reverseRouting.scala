// @SOURCE:E:/temp/scalas/bills/conf/routes
// @HASH:c607d7536908b82ccffa12e4af27098eb3561920
// @DATE:Fri Oct 02 22:49:46 NOVT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:14
// @LINE:13
package controllers {

// @LINE:14
class ReverseWebJarAssets {
    

// @LINE:14
def at(file:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        
    
}
                          

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        
    
}
                          
}
                  

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package bills {

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseBillsController {
    

// @LINE:5
def registerValidate(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "registerValidate")
}
                        

// @LINE:9
def addEventAction(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "addevent")
}
                        

// @LINE:6
def register(info:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "register" + implicitly[PathBindable[String]].unbind("info", dynamicString(info)))
}
                        

// @LINE:7
def loginValidate(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "loginValidate")
}
                        

// @LINE:8
def login(info:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login" + implicitly[PathBindable[String]].unbind("info", dynamicString(info)))
}
                        

// @LINE:4
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:10
def setEncryptKey(key:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "setEncryptKey" + implicitly[PathBindable[String]].unbind("key", dynamicString(key)))
}
                        
    
}
                          
}
                  


// @LINE:14
// @LINE:13
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:14
class ReverseWebJarAssets {
    

// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebJarAssets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package bills.javascript {
import ReverseRouteContext.empty

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseBillsController {
    

// @LINE:5
def registerValidate : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.registerValidate",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registerValidate"})
      }
   """
)
                        

// @LINE:9
def addEventAction : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.addEventAction",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addevent"})
      }
   """
)
                        

// @LINE:6
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.register",
   """
      function(info) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("info", encodeURIComponent(info))})
      }
   """
)
                        

// @LINE:7
def loginValidate : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.loginValidate",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loginValidate"})
      }
   """
)
                        

// @LINE:8
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.login",
   """
      function(info) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("info", encodeURIComponent(info))})
      }
   """
)
                        

// @LINE:4
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:10
def setEncryptKey : JavascriptReverseRoute = JavascriptReverseRoute(
   "bills.BillsController.setEncryptKey",
   """
      function(key) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "setEncryptKey" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("key", encodeURIComponent(key))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:14
// @LINE:13
package controllers.ref {


// @LINE:14
class ReverseWebJarAssets {
    

// @LINE:14
def at(file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebJarAssets.at(file), HandlerDef(this.getClass.getClassLoader, "", "controllers.WebJarAssets", "at", Seq(classOf[String]), "GET", """""", _prefix + """webjars/$file<.+>""")
)
                      
    
}
                          

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
package bills.ref {


// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
// @LINE:4
class ReverseBillsController {
    

// @LINE:5
def registerValidate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.registerValidate(), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "registerValidate", Seq(), "GET", """""", _prefix + """registerValidate""")
)
                      

// @LINE:9
def addEventAction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.addEventAction(), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "addEventAction", Seq(), "GET", """""", _prefix + """addevent""")
)
                      

// @LINE:6
def register(info:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.register(info), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "register", Seq(classOf[String]), "GET", """""", _prefix + """register$info<[^/]+>""")
)
                      

// @LINE:7
def loginValidate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.loginValidate(), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "loginValidate", Seq(), "GET", """""", _prefix + """loginValidate""")
)
                      

// @LINE:8
def login(info:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.login(info), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "login", Seq(classOf[String]), "GET", """""", _prefix + """login$info<[^/]+>""")
)
                      

// @LINE:4
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.index(), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "index", Seq(), "GET", """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~""", _prefix + """""")
)
                      

// @LINE:10
def setEncryptKey(key:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   bills.BillsController.setEncryptKey(key), HandlerDef(this.getClass.getClassLoader, "", "bills.BillsController", "setEncryptKey", Seq(classOf[String]), "GET", """""", _prefix + """setEncryptKey$key<[^/]+>""")
)
                      
    
}
                          
}
        
    