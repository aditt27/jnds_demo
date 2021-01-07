package com.adibu.training.jnds_demo.plugin;

import id.co.nds.dbaccess.sqlpaging.SQLPage;
import id.co.nds.dbaccess.util.iface.IJndsDbUtil;

import java.sql.DatabaseMetaData;
import java.sql.Timestamp;

import org.joda.time.DateTime;

public class SQLPagingMySQL implements IJndsDbUtil {

	@Override
	public void configure(DatabaseMetaData arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSQLPaging(String statement, SQLPage page) {
		// TODO Auto-generated method stub
		
		try {
			// do logic to set the limit : 
			int startRow = (page.getPageNo() * page.getRowsPerPage()) - page.getRowsPerPage();
	        int numOfPages = page.getNumOfPages();
	        
	        if(page.getPageNo() > numOfPages) page.setPageNo(numOfPages);
	        if(page.getPageNo() < 1) page.setPageNo(1);
	        
	        // build statement : 
	        StringBuilder buf = new StringBuilder(statement);
	        buf.append(" limit ").append(String.valueOf(startRow)).append(", ").append(String.valueOf(page.getRowsPerPage()));
	
	        return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		        
		return null;
	}

	@Override
	public String getDBDateTimeFormat(Timestamp timestamp) {
		// TODO Auto-generated method stub
		DateTime dt = new DateTime(timestamp);
		return dt.getYear() + "-" + dt.getMonthOfYear() + "-" + dt.getDayOfMonth() + " " + dt.getHourOfDay() + ":" + dt.getMinuteOfHour() + ":" + dt.getSecondOfMinute();
	}

	@Override
	public String getDBDateFormat(Timestamp timestamp) {
		// TODO Auto-generated method stub
		DateTime dt = new DateTime(timestamp);
		return dt.getYear() + "-" + dt.getMonthOfYear() + "-" + dt.getDayOfMonth();
	}

}
