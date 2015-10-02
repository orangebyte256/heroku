
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
object showme extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(name1: String, name2: String, name3: String, name4: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
  <head>
  </head>

  <body>
    <h1>
      """),_display_(/*10.8*/name1),format.raw/*10.13*/("""
      """),format.raw/*11.7*/("""<br>
      """),_display_(/*12.8*/name2),format.raw/*12.13*/("""
      """),format.raw/*13.7*/("""<br>
      """),_display_(/*14.8*/name3),format.raw/*14.13*/("""
      """),format.raw/*15.7*/("""<br>
      """),_display_(/*16.8*/name4),format.raw/*16.13*/("""
    """),format.raw/*17.5*/("""</h1>
  </body>
</html>
"""))}
  }

  def render(name1:String,name2:String,name3:String,name4:String): play.twirl.api.HtmlFormat.Appendable = apply(name1,name2,name3,name4)

  def f:((String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (name1,name2,name3,name4) => apply(name1,name2,name3,name4)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Oct 02 22:49:46 NOVT 2015
                  SOURCE: E:/temp/scalas/bills/app/views/showme.scala.html
                  HASH: aab6aebe6ddfd16da615495f1ecbd69c8b53eef3
                  MATRIX: 745->1|893->61|921->63|1025->141|1051->146|1085->153|1123->165|1149->170|1183->177|1221->189|1247->194|1281->201|1319->213|1345->218|1377->223
                  LINES: 26->1|29->1|31->3|38->10|38->10|39->11|40->12|40->12|41->13|42->14|42->14|43->15|44->16|44->16|45->17
                  -- GENERATED --
              */
          