<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
 <script src="http://code.jquery.com/jquery-latest.min.js"   type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"     type="text/javascript"></script>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
       
       var jsonData = ${lineGraph}; 
    	   			/* [
                  {"id":1,"tagName":"sunday","id2" : 3},
                  {"id":2,"tagName":"monday" ,"id2" : 4}, 
                  {"id":3,"tagName":"tuesday" ,"id2" : 5},
                  {"id":0.3,"tagName":"wednesday" ,"id2" : 6},
                  {"id":5,"tagName":"thursday" ,"id2" : 7}
                  ]; */

      
       // data = $.parseJSON(jsonData);

       var arrayData = [];
       arrayData.push(['Year', 'Sales', 'Expenses']);

        $.each(jsonData, function(i, item) {
          arrayData.push([item.tagName, item.id , item.id2 ])
        });

      var data = google.visualization.arrayToDataTable(arrayData);


        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
    
<script>
var jsAtt = '${lineGraph}';
</script>

</head>
<body>

<form method="post" >
ZipCode <input type ="text" name="zipcode" ></input>
<input type="submit" value="submit"/>
</form>
<br/>
<hr/>

<div id="render">
<c:if test="${fromPost}">
<table border="0" width="100%" >
	<tr>
		<td>Temperature: ${temp}</td>
		<td> Description : ${desc}</td>
	</tr>
	<tr>
		<td colspan=""> Minimum : ${min} <br/>
		 Maximum : ${max} <br/>
		 Avg : ${avg} <br/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<div id="curve_chart" style="width: 900px; height: 500px"></div></td>
	</tr>
	
</table>

</c:if>

</div>
</body>
</html>