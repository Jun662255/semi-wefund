package com.kh.category.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.category.model.dao.CategoryListDao;
import com.kh.category.model.vo.Category;

public class CategoryListService {

	public ArrayList<Category> selectTechList(String categoryNo) {
			
			Connection conn = getConnection();
			
			System.out.println(categoryNo);
			
			ArrayList<Category> list = new CategoryListDao().selectTechList(conn, categoryNo);
			
			close(conn);
			
			return list;
		}
	


}
