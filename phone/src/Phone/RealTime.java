package Phone;

import java.util.Date;

public class RealTime {
	//private Date now = new Date();
	
	void showThisTime() {
		System.out.println(new Date());
	}
	
	public static Date getNow() {
		return new Date();
	}
}
