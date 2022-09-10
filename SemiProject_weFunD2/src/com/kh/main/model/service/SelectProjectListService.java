package com.kh.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;

import com.kh.main.model.dao.SelectProjectListDao;
import com.kh.main.model.vo.SelectProjectList;

public class SelectProjectListService {

	public ArrayList<SelectProjectList> selectByCount() {
		
		Connection conn = getConnection();
			
		ArrayList<SelectProjectList> list = new SelectProjectListDao().selectByCount(conn);
		
		close(conn);
		
		return list;
	}

}
