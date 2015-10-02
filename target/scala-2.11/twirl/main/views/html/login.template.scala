
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""


"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
  <link rel="stylesheet" href='"""),_display_(/*21.33*/routes/*21.39*/.Assets.at("stylesheets/signin.css")),format.raw/*21.75*/("""'>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>
   <link rel="stylesheet" href='"""),_display_(/*26.34*/routes/*26.40*/.Assets.at("stylesheets/bootstrap-select.css")),format.raw/*26.86*/("""'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="http:\\192.168.0.7:9000\loginValidate" method="get">
        """),_display_(/*40.10*/if(name == "error")/*40.29*/ {_display_(Seq[Any](format.raw/*40.31*/("""
          """),format.raw/*41.11*/("""<h2 style="color:#069" class="form-signin-heading">Username already exist</h2>
        """)))}/*42.11*/else/*42.16*/{_display_(Seq[Any](format.raw/*42.17*/("""
          """),format.raw/*43.11*/("""<h2 class="form-signin-heading">Please sign in</h2>
        """)))}),format.raw/*44.10*/("""
        """),format.raw/*45.9*/("""<input type="text" id="inputUsername" class="form-control" name="username" placeholder="Username" required autofocus>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        <a class="btn btn-lg btn-primary btn-block" href="http:\\192.168.0.7:9000\register_" >Зарегестрироваться</a>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
"""))}
  }

  def render(name:String): play.twirl.api.HtmlFormat.Appendable = apply(name)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (name) => apply(name)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Sep 25 23:15:06 NOVT 2015
                  SOURCE: E:/source/scala/biils/app/views/login.scala.html
                  HASH: 451ffd8fbe85e56b68973295f540427f3be9dd71
                  MATRIX: 723->1|825->15|857->21|1603->740|1618->746|1675->782|1993->1073|2008->1079|2075->1125|2570->1593|2598->1612|2638->1614|2678->1626|2786->1716|2799->1721|2838->1722|2878->1734|2971->1796|3008->1806
                  LINES: 26->1|29->1|32->4|49->21|49->21|49->21|54->26|54->26|54->26|68->40|68->40|68->40|69->41|70->42|70->42|70->42|71->43|72->44|73->45
                  -- GENERATED --
              */
          