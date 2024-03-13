package library_management_system.library.pageRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	
	public static int val(int pageno,int pagesize) {
		int offset = 0;
		    offset=(pageno-1)*pagesize;
		
		  return offset;
		
		
	}

	public static String today() {
		  DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		  String today_date= formatter.format(new Date());
		return today_date;
	}

	

	
	
	

}
