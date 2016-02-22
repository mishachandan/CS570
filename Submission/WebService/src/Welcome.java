

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ws2.WAServiceStub;
import ws2.WAServiceStub.AvgTemp;
import ws2.WAServiceStub.GetDescription;
import ws2.WAServiceStub.GetForecast;
import ws2.WAServiceStub.MaxTemp;
import ws2.WAServiceStub.MinTemp;
/**
 * Servlet implementation class Welcome
 */
//@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();

		application.setAttribute("fromPost",false);
		request.getRequestDispatcher("jsp\\welcome.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zipcode = request.getParameter("zipcode");
		System.out.println(" misha" +zipcode );
		
		
WAServiceStub stub = new WAServiceStub();
		
		MinTemp mintemp = new MinTemp();
		mintemp.setZipcode(zipcode);
		
		MaxTemp maxTemp = new MaxTemp();
		maxTemp.setZipcode(zipcode);
		
		AvgTemp avgTemp = new AvgTemp();
		avgTemp.setZipcode(zipcode);
		
		GetDescription getDesc = new GetDescription();
		getDesc.setZipcode(zipcode);
		
		GetForecast getForecast = new GetForecast();
		getForecast.setZipcode(zipcode);
		//stub.getForecast(getForecast).get_return()
		
		//String description =  "\n<img src=\"http://l.yimg.com/a/i/us/we/52/33.gif\"/><br />\n<b>Current Conditions:</b><br />\nFair, 12 F<BR />\n<BR /><b>Forecast:</b><BR />\nSun - Mostly Cloudy. High: 22 Low: 6<br />\nMon - Snow Showers. High: 21 Low: 6<br />\nTue - Partly Cloudy. High: 23 Low: 17<br />\nWed - Mostly Cloudy. High: 26 Low: 20<br />\nThu - Partly Cloudy. High: 27 Low: 20<br />\n<br />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Nome__AK/*http://weather.yahoo.com/forecast/USAK0170_f.html\">Full Forecast at Yahoo! Weather</a><BR/><BR/>\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel</a>)<br/>\n";
		ServletContext application = getServletConfig().getServletContext();
		application.setAttribute("todaysdate", new Date());
		application.setAttribute("temp",29);
		application.setAttribute("desc", stub.getDescription(getDesc).get_return());
		application.setAttribute("min",stub.minTemp(mintemp).get_return());
		application.setAttribute("max",stub.maxTemp(maxTemp).get_return());
		application.setAttribute("avg",stub.avgTemp(avgTemp).get_return());
		
		JsonParser parser =new JsonParser(); 
		JsonElement element  = parser.parse(stub.getForecast(getForecast).get_return());
		JsonArray array =  element.getAsJsonArray();
		
		//JSONArray jsonarray  =  new JSONArray();
		/*JSONObject j1 = new JSONObject();
		j1.put("id", 1);
		j1.put("tagName", "Sunday");
		j1.put("id2", 2);
		jsonarray.put(j1);
		JSONObject j2 = new JSONObject();
		j2.put("id", 4);
		j2.put("tagName", "Monday");
		j2.put("id2", 3);
		jsonarray.put(j2);*/
		
		application.setAttribute("lineGraph", array);
		application.setAttribute("fromPost",true);
		response.sendRedirect("jsp\\welcome.jsp");
	}

}
