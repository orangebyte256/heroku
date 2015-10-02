
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Person,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(me: Person):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.14*/("""

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
            <li><a href="http:\\192.168.0.7:9000\login_">Logout</a></li>
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
  

  <form class="form-horizontal" action="http:\\192.168.0.7:9000\addevent" method="get">
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

  def render(me:Person): play.twirl.api.HtmlFormat.Appendable = apply(me)

  def f:((Person) => play.twirl.api.HtmlFormat.Appendable) = (me) => apply(me)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Sep 25 19:56:59 NOVT 2015
                  SOURCE: E:/source/scala/biils/app/views/index.scala.html
                  HASH: 02fc4c6720ea4fbaaf5e6737c094e6bc9d0ea253
                  MATRIX: 742->23|842->35|872->39|1585->725|1600->731|1667->777|2085->1168|2100->1174|2166->1219|3449->2475|3460->2477|3487->2483|3900->2869|3948->2901|3988->2903|4028->2916|4053->2932|4093->2934|4135->2948|4221->3007|4236->3013|4263->3019|4313->3042|4324->3044|4360->3071|4375->3077|4386->3099|4404->3108|4444->3110|4507->3146|4518->3148|4562->3171|4594->3204|4623->3224|4663->3226|4729->3265|4740->3267|4785->3290|4817->3323|4835->3332|4875->3334|4940->3372|4951->3374|4995->3397|5040->3427|5085->3444|5168->3500|5183->3506|5208->3510|5274->3545|5316->3556|5351->3564|6439->4624|6494->4662|6535->4664|6578->4679|6603->4694|6644->4696|6689->4712|6726->4721|6753->4726|6810->4751|6855->4764|6891->4772|7441->5294|7470->5295|7508->5305|7587->5356|7617->5357|7658->5369|7736->5419|7766->5420|7804->5430|7900->5498|7929->5499|7998->5539|8028->5540|8066->5550|8206->5662|8235->5663|8305->5704|8335->5705|8373->5715|8415->5729|8444->5730|8514->5771|8544->5772|8582->5782|8732->5904|8762->5905|8803->5917|9043->6129|9073->6130|9111->6140|9153->6154|9183->6155|9224->6167|9366->6281|9396->6282|9434->6292|9476->6306|9505->6307|9578->6351|9608->6352|9646->6362|9894->6582|9923->6583|9959->6591
                  LINES: 26->2|29->2|31->4|47->20|47->20|47->20|55->28|55->28|55->28|84->57|84->57|84->57|99->72|99->72|99->72|100->73|100->73|100->73|101->74|102->75|102->75|102->75|103->76|103->76|103->76|103->76|103->77|103->77|103->77|103->77|103->77|103->77|103->78|103->78|103->78|103->78|103->78|103->78|103->79|103->79|103->79|103->79|103->79|103->79|103->80|104->81|104->81|104->81|104->81|106->83|107->84|108->85|134->111|134->111|134->111|135->112|135->112|135->112|136->113|136->113|136->113|137->114|138->115|139->116|161->138|161->138|162->139|163->140|163->140|164->141|165->142|165->142|166->143|168->145|168->145|170->147|170->147|171->148|174->151|174->151|176->153|176->153|177->154|178->155|178->155|180->157|180->157|181->158|186->163|186->163|187->164|189->166|189->166|190->167|191->168|191->168|192->169|194->171|194->171|195->172|196->173|196->173|198->175|198->175|199->176|202->179|202->179|204->181
                  -- GENERATED --
              */
          