package com.kh.admin.adminReview.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminReview.model.dao.ReviewDao;
import com.kh.admin.adminReview.model.vo.Review;
import com.kh.common.model.PageInfo;

public class ReviewService {

	public int listCountReview() {

		Connection conn = getConnection();

		int listCount = new ReviewDao().listCountReview(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<Review> selectList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Review> list = new ReviewDao().selectList(conn, pi);

		close(conn);
		return list;
	}

}
