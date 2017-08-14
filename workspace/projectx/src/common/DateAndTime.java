package common;

import java.text.ParseException;

public class DateAndTime {
		
	public static final String DATEFORMAT = "dd.MM.yyyy";
	public static final String TIMEFORMAT = "HH:mm:ss";
	public static final String TIMEFORMAT_SIMPLE = "HH:mm";
	public static final String DATE_TIME_SEPARATOR = " ";
	public static final String TIMESTAMPFORMAT = DATEFORMAT + DATE_TIME_SEPARATOR + TIMEFORMAT;

	// time slider input support constants
	public static final int HOUR_START = 0;
	public static final int HOUR_END = 24;
	public static int PARTS_PER_HOUR = 12;
	
	public static String toString(java.util.Date date, boolean doWithMillies) {
		if( doWithMillies ){
			return new java.text.SimpleDateFormat(TIMESTAMPFORMAT).format(date, new StringBuffer(),new java.text.FieldPosition(0)).toString();
		}else {
			return new java.text.SimpleDateFormat(DATEFORMAT).format(date, new StringBuffer(),new java.text.FieldPosition(0)).toString();
		}
	}
	
	public static java.util.Date parseDate( String value) throws ParseException{
		return new java.text.SimpleDateFormat(DATEFORMAT).parse(value);
	}
	
	public static java.util.Date parseTimestamp( String value) throws ParseException{
		return new java.text.SimpleDateFormat(TIMESTAMPFORMAT).parse(value);
	}
	
	public static java.util.Date parseTime( String value) throws ParseException {
		try {
			return new java.text.SimpleDateFormat(TIMEFORMAT).parse(value);
		} catch (ParseException e) {
			return new java.text.SimpleDateFormat(TIMEFORMAT_SIMPLE).parse(value);
		}
	}


	private DateAndTime(){}

}
