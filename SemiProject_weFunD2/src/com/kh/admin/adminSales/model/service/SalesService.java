package com.kh.admin.adminSales.model.service;
import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminSales.model.dao.SalesDao;
import com.kh.admin.adminSales.model.vo.Sales;

public class SalesService {

	
	public ArrayList<Sales> monthlyCategorySalesList(String month, String year){
		Connection conn = getConnection();
		
		ArrayList<Sales> list = new SalesDao().monthlyCategorySalesList(conn,month,year);
				
		close(conn);		
		return list;
	}
	
	
	
	public ArrayList<Sales> monthlySales(String month, String year){
		Connection conn = getConnection();
		
		ArrayList<Sales> list = new SalesDao().monthlySales(conn, month, year);
				
		close(conn);		
		return list;
	}
}
