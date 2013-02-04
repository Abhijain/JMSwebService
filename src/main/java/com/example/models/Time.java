package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;

import java.sql.*;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

@XmlRootElement
public class Time {

    private String timezone;
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;
	private String msg;

    public Time() {
        this(TimeZone.getDefault());
    }

    public Time(TimeZone timezone) {
        final Calendar now = Calendar.getInstance(timezone);

        this.timezone = now.getTimeZone().getDisplayName();
        this.year = now.get(Calendar.YEAR);
        this.month = now.get(Calendar.MONTH) + 1;
        this.day = now.get(Calendar.DATE);
        this.hour = now.get(Calendar.HOUR);
        this.minute = now.get(Calendar.MINUTE);
        this.second = now.get(Calendar.SECOND);
       // Connection connection;
		try {
			//connection = getConnection();
			String url = "jdbc:postgresql://ec2-54-243-190-85.compute-1.amazonaws.com:5432/d3b0m0rd9jmdgp";
			Properties props = new Properties();
			props.setProperty("user","dghjvoeeiugntr");
			props.setProperty("password","JQs2CrBxCINutxb0GanYxbIWoG");
			props.setProperty("ssl","true");
			Connection conn = DriverManager.getConnection(url, props);
			
			 Statement stmt = conn.createStatement();
		        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
		        stmt.executeUpdate("CREATE TABLE test (tick varchar(20))");
		        stmt.executeUpdate("INSERT INTO ticks VALUES ('Unisys')");
		        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
		        while (rs.next()) {
		        	this.msg = (String)rs.getString("tick");
		        	System.out.println("Read from DB: " + rs.getTimestamp("tick"));
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

    public String getTimezone() {
        return timezone;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    public String getMsg() {
		return msg;
	}


}
