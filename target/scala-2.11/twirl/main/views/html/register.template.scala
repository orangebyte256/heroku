
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
object register extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name: String, host: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
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
  <link rel="stylesheet" href='"""),_display_(/*20.33*/routes/*20.39*/.Assets.at("stylesheets/signin.css")),format.raw/*20.75*/("""'>

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>
   <link rel="stylesheet" href='"""),_display_(/*25.34*/routes/*25.40*/.Assets.at("stylesheets/bootstrap-select.css")),format.raw/*25.86*/("""'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action=""""),_display_(/*37.42*/host),format.raw/*37.46*/("""\registerValidate" method="get">
        """),_display_(/*38.10*/if(name == "reply")/*38.29*/ {_display_(Seq[Any](format.raw/*38.31*/("""
          """),format.raw/*39.11*/("""<h2 font-color="red" class="form-signin-heading">Username already exist</h2>
        """)))}/*40.11*/else/*40.16*/{_display_(Seq[Any](format.raw/*40.17*/("""
          """),format.raw/*41.11*/("""<h2 class="form-signin-heading">Please sign in</h2>
        """)))}),format.raw/*42.10*/("""
        """),format.raw/*43.9*/("""<select id="dormitory" class="form-control " onmouseover="changeSelect(0)" name="dormitory" required autofocus>
          <option>Выберите номер общаги</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </select>
        <select id="room" class="form-control " onmouseover="changeSelect(1)" data-live-search="true" name="room" required autofocus>
          <option>Выберите номер комнаты</option>
          """),_display_(/*51.12*/for(num <- 1 to 999) yield /*51.32*/ {_display_(Seq[Any](format.raw/*51.34*/("""
            """),format.raw/*52.13*/("""<option>"""),_display_(/*52.22*/num),format.raw/*52.25*/("""</option>
          """)))}),format.raw/*53.12*/("""
        """),format.raw/*54.9*/("""</select>
        <input type="text" id="inputName" class="form-control" name="name" placeholder="Имя">
        <input type="text" id="inputUsername" class="form-control" name="username" placeholder="Username">
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript">
    function changeSelect(val)
    """),format.raw/*68.5*/("""{"""),format.raw/*68.6*/("""
      """),format.raw/*69.7*/("""var name = ""
      if(val == 0)
        name = "dormitory";
      else
        name = "room";
      document.getElementById(name).options[0].disabled = true;
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/("""
    """),format.raw/*76.5*/("""</script>
  </body>
</html>
"""))}
  }

  def render(name:String,host:String): play.twirl.api.HtmlFormat.Appendable = apply(name,host)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (name,host) => apply(name,host)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Oct 02 22:49:46 NOVT 2015
                  SOURCE: E:/temp/scalas/bills/app/views/register.scala.html
                  HASH: e0d71cc1831422d5c4f991c2dfcd5fc694c0fe7d
                  MATRIX: 733->1|849->29|877->31|1606->733|1621->739|1678->775|1991->1061|2006->1067|2073->1113|2492->1505|2517->1509|2586->1551|2614->1570|2654->1572|2693->1583|2798->1670|2811->1675|2850->1676|2889->1687|2981->1748|3017->1757|3505->2218|3541->2238|3581->2240|3622->2253|3658->2262|3682->2265|3734->2286|3770->2295|4478->2976|4506->2977|4540->2984|4730->3147|4758->3148|4790->3153
                  LINES: 26->1|29->1|31->3|48->20|48->20|48->20|53->25|53->25|53->25|65->37|65->37|66->38|66->38|66->38|67->39|68->40|68->40|68->40|69->41|70->42|71->43|79->51|79->51|79->51|80->52|80->52|80->52|81->53|82->54|96->68|96->68|97->69|103->75|103->75|104->76
                  -- GENERATED --
              */
          