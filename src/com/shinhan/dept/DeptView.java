package com.shinhan.dept;

import java.util.List;

public class DeptView {

	public static void display(List<DeptDTO> deptlist) {
		if(deptlist.size() == 0) System.out.println("부서목록 없음");
		System.out.println("==== 부서목록 조회 ====");
		deptlist.stream().forEach(dept -> System.out.println(dept));
		return;
	}
	
	public static void display(DeptDTO deptDTO) {
		if(deptDTO.getDEPARTMENT_NAME() ==null)  System.out.println("해당 부서가 존재하지 않습니다.");
		else System.out.println("부서정보 >> " + deptDTO);
		return;
	}
}
