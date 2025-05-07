package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.day16.DBUtil;

//db에 접근하기 위한 로직
public class DeptDAO {
	
	public List<DeptDTO> selectAll(){
		List<DeptDTO> deptlist = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from DEPARTMENTS";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}}
		catch (SQLException e) { e.printStackTrace();}
		finally { DBUtil.dbDisconnect(conn, st, rs);}
			
		return deptlist;
	}

	//
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = DeptDTO.builder()
				.department_id(rs.getInt("department_id"))
				.department_name(rs.getString("department_name"))
				.manager_id(rs.getInt("manager_id"))
				.location_id(rs.getInt("location_id"))
				.build();
		return dept;
	}

	public DeptDTO selectDetail(int department_id) {
		DeptDTO deptDto = new DeptDTO();
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				select * 
				from DEPARTMENTS
				where department_id = ?
				""";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, department_id);
			
			rs = st.executeQuery();
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptDto = dept;
			}}
		catch (SQLException e) { e.printStackTrace();}
		finally { DBUtil.dbDisconnect(conn, st, rs);}
		
		
		return deptDto;
	}
}
