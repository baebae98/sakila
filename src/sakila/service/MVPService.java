package sakila.service;

import java.util.*;
import java.sql.*;

import sakila.dao.*;
import sakila.vo.*;
import sakila.commons.*;

public class MVPService {
	private MVPDao mvpDao;	// MVPDao 객체 선언
	
	public ArrayList<Customer> getMVP(int limit1, int limit2) {
		ArrayList<Customer> returnList = null;
		
		mvpDao = new MVPDao();	// 메소드를 호출하기 위해 객체 생성
		Connection conn = null;	// Connection 객체 메소드 전역 선언
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 트랜잭션 실행
			returnList = mvpDao.selectMVP(conn, limit1, limit2);
			
			// 트랜잭션 성공 시  commit 수행
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();	// DB 접속을 종료
			} catch (SQLException e) {
				e.printStackTrace();	// 오류가 발생해도 오류메세지를 출력
			}
		}
		
		return returnList;
	}
	
	public int countMVP() {
		System.out.println("Debug: [SERVICE] countMVP 실행");
		int count = 0;
		
		mvpDao = new MVPDao();	// 메소드를 호출하기 위해 객체 생성
		Connection conn = null;	// Connection 객체 메소드 전역 선언
		
		try {
			DBUtil dbUtil = new DBUtil();	// 데이터베이스 정보가 담긴 객체 생성
			conn = dbUtil.getConnection();	// 데이터베이스 접속
			
			// 트랜잭션 실행
			count = mvpDao.countMVP(conn);
			
			// 트랜잭션 성공 시  commit 수행
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();	// DB 접속을 종료
			} catch (SQLException e) {
				e.printStackTrace();	// 오류가 발생해도 오류메세지를 출력
			}
		}
		
		return count;
	}
}