
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
import bills.Person
/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Person,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(me: Person, host: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.28*/("""

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

    <title>Justified Nav Template for Bootstrap</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

  <link rel="stylesheet" href='"""),_display_(/*20.33*/routes/*20.39*/.Assets.at("stylesheets/bootstrap-select.css")),format.raw/*20.85*/("""'>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src='"""),_display_(/*28.15*/routes/*28.21*/.Assets.at("javascripts/bootstrap-select.js")),format.raw/*28.66*/("""'></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Общага</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href=""""),_display_(/*53.27*/host),format.raw/*53.31*/("""\login_">Logout</a></li>
            <li><a href="#about">About</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><h3>Привет, """),_display_(/*57.30*/me/*57.32*/.name_),format.raw/*57.38*/("""</h3></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <hr>
    <hr>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->

      <!-- Example row of columns -->
      <div class="row">
        """),_display_(/*72.10*/for(person <- me.room_.members_) yield /*72.42*/ {_display_(Seq[Any](format.raw/*72.44*/("""
          """),_display_(/*73.12*/if(person != me)/*73.28*/ {_display_(Seq[Any](format.raw/*73.30*/("""
            """),format.raw/*74.13*/("""<div class="col-lg-4">
              <h2 class = "names">"""),_display_(/*75.36*/person/*75.42*/.name_),format.raw/*75.48*/("""</h2>
               """),_display_(/*76.17*/me/*76.19*/.neighbors_.get(person).get/*76.46*/ match/*76.52*/ {/*77.19*/case 0 =>/*77.28*/ {_display_(Seq[Any](format.raw/*77.30*/("""<h1><span class="label label-info">"""),_display_(/*77.66*/me/*77.68*/.neighbors_.get(person)),format.raw/*77.91*/("""</span></h1>""")))}/*78.19*/case x if (x > 0) =>/*78.39*/ {_display_(Seq[Any](format.raw/*78.41*/("""<h1><span class="label label-success">"""),_display_(/*78.80*/me/*78.82*/.neighbors_.get(person)),format.raw/*78.105*/("""</span></h1>""")))}/*79.19*/case _ =>/*79.28*/ {_display_(Seq[Any](format.raw/*79.30*/("""<h1><span class="label label-danger">"""),_display_(/*79.68*/me/*79.70*/.neighbors_.get(person)),format.raw/*79.93*/("""</span></h1>""")))}}),format.raw/*80.16*/(""" 
              """),format.raw/*81.15*/("""<input class="values" type="hidden" name="name" value=""""),_display_(/*81.71*/person/*81.77*/.id_),format.raw/*81.81*/("""">
            </div>
          """)))}),format.raw/*83.12*/("""
        """)))}),format.raw/*84.10*/("""
      """),format.raw/*85.7*/("""</div>
  

  <form class="form-horizontal" action=""""),_display_(/*88.42*/host),format.raw/*88.46*/("""\addevent" method="get">
    <div class="form-group form-group-lg">
      <h2>
      <span class="label label-info">Кому: </span>
      <span class="label label-info" id = "toname"></span>
      </h2>
    </div>
    <div class="form-group form-group-lg">
      <input id="hide" type="text" style="display:none;" name = "subject">
      <input type="text" style="float:left;" class="col-lg-2 control-label" id="text" name = "message" placeholder="Сообщение">
      <input type="text" style="float:left;" class="col-lg-2 control-label" id="sum" name = "sum" placeholder="Сумма">
      <select id="scsd" class="selectpicker" name = "type">
          <option value="get">Взял</option>
          <option value="give">Дал</option>
          <option value="common">Общая покупка</option>
      </select>
    <button type="submit" class="btn btn-primary">Ok</button>
    </div>
  </form>

    <div class="container">
    <table class="table">
      <tbody>
          """),_display_(/*111.12*/for(event <- me.room_.getMessages(me)) yield /*111.50*/ {_display_(Seq[Any](format.raw/*111.52*/("""
            """),_display_(/*112.14*/if(event != "")/*112.29*/ {_display_(Seq[Any](format.raw/*112.31*/("""
              """),format.raw/*113.15*/("""<tr><td>"""),_display_(/*113.24*/event),format.raw/*113.29*/("""</td></tr>
            """)))}),format.raw/*114.14*/("""
          """)))}),format.raw/*115.12*/("""
      """),format.raw/*116.7*/("""</tbody>
    </table>
  </div>


      <!-- Site footer -->
      <footer class="footer">
        <center><p>&copy; OrangeByteInc 2015</p></center>
      </footer>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

    <script type="text/javascript">
    var classname = document.getElementsByClassName("col-lg-4");

    var selected = null;

    var clear = function()
    """),format.raw/*138.5*/("""{"""),format.raw/*138.6*/("""
        """),format.raw/*139.9*/("""for(var i = 0; i < classname.length; i++)
        """),format.raw/*140.9*/("""{"""),format.raw/*140.10*/("""
          """),format.raw/*141.11*/("""classname[i].style.background = "white";
        """),format.raw/*142.9*/("""}"""),format.raw/*142.10*/("""
        """),format.raw/*143.9*/("""if(selected)
          selected.style.background = "#33DD77";
    """),format.raw/*145.5*/("""}"""),format.raw/*145.6*/(""";

    var mouseOverFunc = function() """),format.raw/*147.36*/("""{"""),format.raw/*147.37*/("""
        """),format.raw/*148.9*/("""if(selected)
          selected.style.background = "#88FFCC";
        this.style.background = "#33DD77";
    """),format.raw/*151.5*/("""}"""),format.raw/*151.6*/(""";

    var mouseLeaveFunc = function() """),format.raw/*153.37*/("""{"""),format.raw/*153.38*/("""
        """),format.raw/*154.9*/("""clear();
    """),format.raw/*155.5*/("""}"""),format.raw/*155.6*/(""";

    var mouseClickFunc = function() """),format.raw/*157.37*/("""{"""),format.raw/*157.38*/("""
        """),format.raw/*158.9*/("""if(selected == this)
          selected = null;
        else
          selected = this;
        if(selected)
        """),format.raw/*163.9*/("""{"""),format.raw/*163.10*/("""
          """),format.raw/*164.11*/("""document.getElementById("toname").innerHTML = selected.getElementsByClassName("names")[0].innerHTML;
          document.getElementById("hide").value = selected.getElementsByClassName("values")[0].value
        """),format.raw/*166.9*/("""}"""),format.raw/*166.10*/("""
        """),format.raw/*167.9*/("""else
        """),format.raw/*168.9*/("""{"""),format.raw/*168.10*/("""
          """),format.raw/*169.11*/("""document.getElementById("toname").innerHTML = "";
          document.getElementById("hide").value = -1;
        """),format.raw/*171.9*/("""}"""),format.raw/*171.10*/("""
        """),format.raw/*172.9*/("""clear();
    """),format.raw/*173.5*/("""}"""),format.raw/*173.6*/(""";

    for(var i=0;i<classname.length;i++)"""),format.raw/*175.40*/("""{"""),format.raw/*175.41*/("""
        """),format.raw/*176.9*/("""classname[i].addEventListener('mouseover', mouseOverFunc, false);
        classname[i].addEventListener('mouseleave', mouseLeaveFunc, false);
        classname[i].addEventListener('click', mouseClickFunc, false);
    """),format.raw/*179.5*/("""}"""),format.raw/*179.6*/("""

    """),format.raw/*181.5*/("""</script>
  
  </body>
</html>
"""))}
  }

  def render(me:Person,host:String): play.twirl.api.HtmlFormat.Appendable = apply(me,host)

  def f:((Person,String) => play.twirl.api.HtmlFormat.Appendable) = (me,host) => apply(me,host)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Oct 02 22:49:46 NOVT 2015
                  SOURCE: E:/temp/scalas/bills/app/views/index.scala.html
                  HASH: b506fd4dd3aa960a1c4a5b2922e3beaa13c01879
                  MATRIX: 749->23|863->49|893->53|1606->739|1621->745|1688->791|2106->1182|2121->1188|2187->1233|3275->2294|3300->2298|3500->2471|3511->2473|3538->2479|3951->2865|3999->2897|4039->2899|4079->2912|4104->2928|4144->2930|4186->2944|4272->3003|4287->3009|4314->3015|4364->3038|4375->3040|4411->3067|4426->3073|4437->3095|4455->3104|4495->3106|4558->3142|4569->3144|4613->3167|4645->3200|4674->3220|4714->3222|4780->3261|4791->3263|4836->3286|4868->3319|4886->3328|4926->3330|4991->3368|5002->3370|5046->3393|5091->3423|5136->3440|5219->3496|5234->3502|5259->3506|5325->3541|5367->3552|5402->3560|5484->3615|5509->3619|6520->4602|6575->4640|6616->4642|6659->4657|6684->4672|6725->4674|6770->4690|6807->4699|6834->4704|6891->4729|6936->4742|6972->4750|7522->5272|7551->5273|7589->5283|7668->5334|7698->5335|7739->5347|7817->5397|7847->5398|7885->5408|7981->5476|8010->5477|8079->5517|8109->5518|8147->5528|8287->5640|8316->5641|8386->5682|8416->5683|8454->5693|8496->5707|8525->5708|8595->5749|8625->5750|8663->5760|8813->5882|8843->5883|8884->5895|9124->6107|9154->6108|9192->6118|9234->6132|9264->6133|9305->6145|9447->6259|9477->6260|9515->6270|9557->6284|9586->6285|9659->6329|9689->6330|9727->6340|9975->6560|10004->6561|10040->6569
                  LINES: 26->2|29->2|31->4|47->20|47->20|47->20|55->28|55->28|55->28|80->53|80->53|84->57|84->57|84->57|99->72|99->72|99->72|100->73|100->73|100->73|101->74|102->75|102->75|102->75|103->76|103->76|103->76|103->76|103->77|103->77|103->77|103->77|103->77|103->77|103->78|103->78|103->78|103->78|103->78|103->78|103->79|103->79|103->79|103->79|103->79|103->79|103->80|104->81|104->81|104->81|104->81|106->83|107->84|108->85|111->88|111->88|134->111|134->111|134->111|135->112|135->112|135->112|136->113|136->113|136->113|137->114|138->115|139->116|161->138|161->138|162->139|163->140|163->140|164->141|165->142|165->142|166->143|168->145|168->145|170->147|170->147|171->148|174->151|174->151|176->153|176->153|177->154|178->155|178->155|180->157|180->157|181->158|186->163|186->163|187->164|189->166|189->166|190->167|191->168|191->168|192->169|194->171|194->171|195->172|196->173|196->173|198->175|198->175|199->176|202->179|202->179|204->181
                  -- GENERATED --
              */
          