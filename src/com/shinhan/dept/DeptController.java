package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

import com.shinhan.comm.CommonControllerInterface;

public class DeptController implements CommonControllerInterface {

	static Scanner sc = new Scanner(System.in);
	static DeptService deptService = new DeptService();
	public static final char ESC = 27;
	
	@Override
	public void execute(){
		 
		boolean isStop = false;
		do {
			System.out.printf(
					"""
					===================
					부서목록 CRUD PROGRAM
					===================
					1. 부서목록 모두보기
					2. 부서정보 상세보기
					3. 부석정보 수정하기
					4. 부서정보 삭제하기
					5. 부서정보 입력하기
					6. 종료하기
					===================
					키보드 숫자 입력(1~6) >>"""
					);
		int command = sc.nextInt();
		switch(command) {
			case 1->{ f_selectAll();}
			case 2->{ f_selectDetail();}
			case 3->{ f_update();}
			case 6->{ isStop = true;}
			}
        
		}while(!isStop);
		System.out.println("=====프로그램 종료=====");
	}

	

	private static void f_selectAll() {
		List<DeptDTO> deptList = deptService.selectAll();
		DeptView.display(deptList);
	}

	private static void f_selectDetail() {
		boolean isStop = false;
		do {
		System.out.print("""
				===================
				2. 부서정보 상세보기 ('0' 입력- 메인으로 돌아가기) 
				- 부서번호 입력 >>""");
		int department_id = sc.nextInt();
		
		if(department_id == 0) {
			isStop = true;
			break;
		}
		DeptDTO deptList = deptService.selectDetail(department_id);
		DeptView.display(deptList);
		}
		while(!isStop);
	}
	
	private static void f_update() {
//		System.out.print("수정할 부서ID>>");
//		int employee_id = sc.nextInt();
//		EmpDTO exist_emp = deptService.selectById(employee_id);
//		if (exist_emp == null) {
//			EmpView.display("존재하지않는 직원입니다.");
//			return;
//		}
//		EmpView.display("=========존재는 직원정보입니다.========");
//		EmpView.display(exist_emp);
//		int result = deptService.empUpdate(makeEmp(employee_id));
//		EmpView.display(result + "건수정");
	}
}
