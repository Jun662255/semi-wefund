package com.kh.admin.adminProject.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import com.kh.admin.adminProject.model.dao.ProjectDao;
import com.kh.admin.adminProject.model.vo.Project;
import com.kh.admin.adminProject.model.vo.Support;
import com.kh.admin.adminQna.model.dao.QnaDao;
import com.kh.admin.adminQna.model.vo.Qna;
import com.kh.common.model.PageInfo;

public class ProjectService {

	public int listCountAll() {
		Connection conn = getConnection();

		int listCountAll = new ProjectDao().listCountAll(conn);

		close(conn);

		return listCountAll;
	}

	public int listCountY() {
		Connection conn = getConnection();

		int listCountY = new ProjectDao().listCountY(conn);

		close(conn);

		return listCountY;
	}

	public int listCountN() {
		Connection conn = getConnection();

		int listCountN = new ProjectDao().listCountN(conn);

		close(conn);

		return listCountN;
	}

	public int listCountE() {
		Connection conn = getConnection();

		int listCountE = new ProjectDao().listCountE(conn);

		close(conn);

		return listCountE;
	}

	public int listCountX() {
		Connection conn = getConnection();

		int listCountX = new ProjectDao().listCountX(conn);

		close(conn);

		return listCountX;
	}

	public ArrayList<Project> selectAllListProject(PageInfo piAll) {
		Connection conn = getConnection();

		ArrayList<Project> list = new ProjectDao().selectAllListProject(conn, piAll);

		close(conn);
		return list;
	}

	public ArrayList<Project> selectYListProject(PageInfo piY) {
		Connection conn = getConnection();

		ArrayList<Project> list = new ProjectDao().selectYListProject(conn, piY);

		close(conn);
		return list;
	}

	public ArrayList<Project> selectNListProject(PageInfo piN) {
		Connection conn = getConnection();

		ArrayList<Project> list = new ProjectDao().selectNListProject(conn, piN);

		close(conn);
		return list;
	}

	public ArrayList<Project> selectEListProject(PageInfo piE) {
		Connection conn = getConnection();

		ArrayList<Project> list = new ProjectDao().selectEListProject(conn, piE);

		close(conn);
		return list;
	}

	public ArrayList<Project> selectXListProject(PageInfo piX) {
		Connection conn = getConnection();

		ArrayList<Project> list = new ProjectDao().selectXListProject(conn, piX);

		close(conn);
		return list;
	}

	public int listCount() {
		Connection conn = getConnection();
		
		int result = new ProjectDao().listCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Project> ProjectSupportList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().ProjectSupportList(conn,pi);
		
		close(conn);
				
		return list;
		

	}

	public ArrayList<Support> SupportDetail(String pno) {
		Connection conn = getConnection();
		
		ArrayList<Support> list = new ProjectDao().SupportDetail(conn,pno);
		
		close(conn);
		
		return list;
	}

}
