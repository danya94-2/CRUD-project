package com.shinhan.day16;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//CRUD(Create, Read, Update, Delete)
//Read(Select)

public class CRUDTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = """
				select DEPARTMENT_ID, max(SALARY), min(SALARY)
				from EMPLOYEES
				group by DEPARTMENT_ID
				having max(salary) != min(salary)
				""";
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int a = rs.getInt(1);
				int b = rs.getInt(2);
				int c = rs.getInt(3);
				System.out.println(a+ "\t" +b + "\t"+c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
	}
	
	public static void f_2(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", userpass = "hr";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = """
				select DEPARTMENT_ID, count(*)
				from EMPLOYEES
				group by DEPARTMENT_ID
				having count(*) >= 5
				order by 2 desc
				""";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, userpass);
			st = conn.createStatement();
			rs = st.executeQuery(sql); //rs는 표와 비슷하다.
			while(rs.next()) {
 				int deptid = rs.getInt(1);
				int cnt = rs.getInt(2);
				System.out.println("부서코드 : " + deptid + "\t 인원수 : " + cnt);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)conn.close();
				if(st != null)conn.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void f_1() throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver 준비 - Class path에 추가한다

		// 2. JDBC Driver load
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버를 메모리에 올린다. 클래스이름호출로.
		System.out.println("2. JDBC Driver load 성공");

		// 3. Connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", userpass = "hr";

		Connection conn = DriverManager.getConnection(url, userid, userpass);
		System.out.println("3. Connection 성공");

		// 4.SQL문 보낼 통로 얻기
		Statement st = conn.createStatement();
		System.out.println("4. SQL문 보낼 통로 얻기 성공");

		// 5.SQL문 생성, 실행
		String sql = """
						select *
						from employees
						where department_id = 80
					""";
		
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int empid = rs.getInt("employee_id");
			String fname = rs.getString("first_name");
			Date hdate = rs.getDate("hire_date");
		    double comm = rs.getDouble("COMMISSION_PCT");
		    System.out.printf("직원번호 : %d , 직원이름 : %s, 입사날짜 : %s, 커미션 : %f\n", empid, fname, hdate, comm);
		}
		rs.close();
		st.close();
		conn.close();
	}

}
