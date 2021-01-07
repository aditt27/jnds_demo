package com.adibu.training.jnds_demo.plugin;

import id.co.nds.dbaccess.sqlpaging.SQLPage;
import id.co.nds.dbaccess.util.iface.IJndsDbUtil;

import java.sql.DatabaseMetaData;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SQLPagingOracle11g implements IJndsDbUtil {

	@Override
	public void configure(DatabaseMetaData dbMetaData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSQLPaging(String sqlStatement, SQLPage page) {
		// TODO Auto-generated method stub
		try {
			// do logic to set the limit : 
			int maxRowToFetch = page.getPageNo() * page.getRowsPerPage();
			int minRowToFetch = (page.getPageNo() - 1) * page.getRowsPerPage();
	        
	        // build statement : 
	        StringBuilder buf = new StringBuilder();
	        buf.append(" SELECT * FROM (");
	        buf.append(" 	SELECT a.*, ROWNUM rnum FROM (");
	        buf.append("		" + sqlStatement + "	) a");
	        buf.append(" 	WHERE ROWNUM <= " + maxRowToFetch);
	        buf.append(" ) WHERE rnum > " + minRowToFetch);
	
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
		DateTimeFormatter builder = DateTimeFormat.forPattern("dd-MMM-yyyy hh.mm.ss.SS a");
		String arg = builder.print(dt);
		return "to_timestamp('"+arg+"','DD-MON-RRRR HH.MI.SS.FF AM')";
	}

	@Override
	public String getDBDateFormat(Timestamp timestamp) {
		// TODO Auto-generated method stub
		DateTime dt = new DateTime(timestamp);
		DateTimeFormatter builder = DateTimeFormat.forPattern("dd-MMM-yyyy 12.00.00.00 a");
		String arg = builder.print(dt);
		return "to_timestamp('"+arg+"','DD-MON-RRRR HH.MI.SS.FF AM')";
	}
	
}
