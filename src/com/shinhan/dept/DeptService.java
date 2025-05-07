package com.shinhan.dept;

import java.util.List;

//Service : 비지니스 로직 수행
public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();
	
	public List<DeptDTO> selectAll(){
		return deptDAO.selectAll();
	}

	public DeptDTO selectDetail(int department_id) {
		return deptDAO.selectDetail(department_id);
	}
}
