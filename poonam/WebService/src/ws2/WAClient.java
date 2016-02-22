package ws2;

import java.rmi.RemoteException;

import ws2.WAServiceStub.AvgTemp;
import ws2.WAServiceStub.GetDescription;
import ws2.WAServiceStub.GetForecast;
import ws2.WAServiceStub.MaxTemp;
import ws2.WAServiceStub.MinTemp;

public class WAClient {

	public static void main(String[] args) throws RemoteException {
		WAServiceStub stub = new WAServiceStub();
		
		/*MinTemp mintemp = new MinTemp();
		mintemp.setZipcode("91722");
		
		System.out.println("min = "+stub.minTemp(mintemp).get_return());
		
		MaxTemp maxTemp = new MaxTemp();
		maxTemp.setZipcode("91722");
		
		System.out.println("max = "+stub.maxTemp(maxTemp).get_return());
		
		AvgTemp avgTemp = new AvgTemp();
		avgTemp.setZipcode("91722");
		
		System.out.println("avg = "+stub.avgTemp(avgTemp).get_return());
		
		GetDescription getDesc = new GetDescription();
		getDesc.setZipcode("91722");
		System.out.println("description = "+stub.getDescription(getDesc).get_return());*/
		
		GetForecast getForecast = new GetForecast();
		getForecast.setZipcode("91722");
		System.out.println("forcast = "+stub.getForecast(getForecast).get_return());
		
		
	}
}
