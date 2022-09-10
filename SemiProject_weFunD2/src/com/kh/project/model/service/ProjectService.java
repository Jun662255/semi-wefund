package com.kh.project.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.PageInfo;
import com.kh.project.model.dao.ProjectDao;
import com.kh.project.model.vo.Likes;
import com.kh.project.model.vo.Product;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Support;

public class ProjectService {

	public int insertProject (Project p, ArrayList<ProjectAttachment> list, ArrayList<Product> plist) {
		
		Connection conn = getConnection();
		
		 int result1 = new ProjectDao().insertProject(conn, p);
		
		 int result2 = new ProjectDao().insertProjectAttachmentList(conn, list);
		
		 int result3 = new ProjectDao().insertProduct(conn, plist);
		 
		 
		 
		if(result1 * result2 * result3 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
	
		
		close(conn);
		
		return (result1 * result2 * result3);

	}
	
	public int selectProjectListCount() {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().selectProjectListCount(conn);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Project> selectProjectList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().selectProjectList(conn, pi);
	
		close(conn);
		
		return list;
	
	}
     
	public int increaseCount(int projectNo) {
	
		Connection conn = getConnection();
		
		int result = new ProjectDao().increaseCount(conn, projectNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Project selectProject(int projectNo) {
		
		Connection conn = getConnection();
		
		Project p = new ProjectDao(). selectProject(conn, projectNo);
		
		close(conn);
		
		return p;
		
		
	}
	
	public ArrayList<Product> selectProduct(int projectNo){
		
		Connection conn = getConnection();
		
		ArrayList<Product> plist = new ProjectDao().selectProduct(conn, projectNo);
		
		close(conn);
		
		return plist;
		
		
	}
	
	
	
	
	public ArrayList<ProjectAttachment> selectProjectAttachment(int projectNo){
		
		Connection conn = getConnection();
		
		ArrayList<ProjectAttachment> list = new ProjectDao().selectProjectAttachment(conn, projectNo);
			
		close(conn);
			
		return list;	
			
	}
			
			
	public ArrayList<Project> projectSearchList(String keyword){
		Connection conn = getConnection();
		
		ArrayList<Project> list = new ProjectDao().projectSearchList(conn, keyword);
	
		close(conn);
		
		return list;
	}
	
	
	
	public int insertSupprot(Support sup) {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().insertSupport(conn, sup);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	
	}
	
	public int sumPayment(int projectNo) {
		
		Connection conn = getConnection();
		
		int totalPrice = new ProjectDao().sumPayment(conn, projectNo);

		close(conn);
		
		return totalPrice;
		
	}
	
	public int allowProject(int projectNo) {
		
		Connection conn = getConnection();
		
		
		int result = new ProjectDao().allowProject(conn, projectNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int returnProject(int projectNo) {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().returnProject(conn, projectNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
	
	public int selectLike(Likes like) {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().selectLike(conn, like);
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteLike(Likes like) {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().deleteLike(conn, like);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
		
	}
	
	public int insertLike(Likes like) {
		
		Connection conn = getConnection();
		
		int result = new ProjectDao().insertLike(conn, like);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
		
		
	}
	
	
	
	
	
	
}
