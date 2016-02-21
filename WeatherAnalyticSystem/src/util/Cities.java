package util;

public class Cities {
	
	public static int counter=1;
	private String cityName;
	private int zipCode;
	
	public Cities(String cityName, int zipCode) {
		super();
		this.cityName = cityName;
		this.zipCode = zipCode;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Cities.counter = counter;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
