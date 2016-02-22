

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
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
		
		String description =  "\n<img src=\"http://l.yimg.com/a/i/us/we/52/33.gif\"/><br />\n<b>Current Conditions:</b><br />\nFair, 12 F<BR />\n<BR /><b>Forecast:</b><BR />\nSun - Mostly Cloudy. High: 22 Low: 6<br />\nMon - Snow Showers. High: 21 Low: 6<br />\nTue - Partly Cloudy. High: 23 Low: 17<br />\nWed - Mostly Cloudy. High: 26 Low: 20<br />\nThu - Partly Cloudy. High: 27 Low: 20<br />\n<br />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Nome__AK/*http://weather.yahoo.com/forecast/USAK0170_f.html\">Full Forecast at Yahoo! Weather</a><BR/><BR/>\n(provided by <a href=\"http://www.weather.com\" >The Weather Channel</a>)<br/>\n";
		ServletContext application = getServletConfig().getServletContext();
		application.setAttribute("todaysdate", new Date());
		application.setAttribute("temp",29);
		application.setAttribute("desc", description);
		application.setAttribute("min",3);
		application.setAttribute("max",4);
		application.setAttribute("avg",5);
		
		JSONArray jsonarray  =  new JSONArray();
		JSONObject j1 = new JSONObject();
		j1.put("id", 1);
		j1.put("tagName", "Sunday");
		j1.put("id2", 2);
		jsonarray.put(j1);
		JSONObject j2 = new JSONObject();
		j2.put("id", 4);
		j2.put("tagName", "Monday");
		j2.put("id2", 3);
		jsonarray.put(j2);
		
		application.setAttribute("lineGraph", jsonarray);
		application.setAttribute("fromPost",true);
		response.sendRedirect("jsp\\welcome.jsp");
	}

}
