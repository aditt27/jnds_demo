package com.adibu.training.jnds_demo.plugin;

import java.sql.DatabaseMetaData;
import java.sql.Timestamp;

import id.co.nds.dbaccess.sqlpaging.SQLPage;
import id.co.nds.dbaccess.util.iface.IJndsDbUtil;

public class SQLPagingPostgreSQL implements IJndsDbUtil{

	@Override
	public void configure(DatabaseMetaData paramDatabaseMetaData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSQLPaging(String paramString, SQLPage paramSQLPage) {
		// TODO Auto-generated method stub
		try {
			// do logic to set the limit : 
			int startRow = (paramSQLPage.getPageNo() * paramSQLPage.getRowsPerPage()) - paramSQLPage.getRowsPerPage();
	        int numOfPages = paramSQLPage.getNumOfPages();
	        
	        if(paramSQLPage.getPageNo() > numOfPages) paramSQLPage.setPageNo(numOfPages);
	        if(paramSQLPage.getPageNo() < 1) paramSQLPage.setPageNo(1);
	        
	        // build statement : 
	        StringBuilder buf = new StringBuilder(paramString);
	        buf.append(" LIMIT ").append(String.valueOf(paramSQLPage.getRowsPerPage())).append(" OFFSET ").append(String.valueOf(startRow));
	
	        return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		        
		return null;
	}

	@Override
	public String getDBDateFormat(Timestamp paramTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDBDateTimeFormat(Timestamp paramTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

}
