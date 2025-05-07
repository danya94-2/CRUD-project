package com.shinhan.comm;

import java.util.Scanner;


//FrontController 패턴 : Controller 여러개인 경우 사용자의 요청과 응답은 출구가 여러개
//바람직하지 않음
//하나로 통합(Front는 1개로)
//Servlet : DispathcerServlet이 있다.(Spring은 FrontController가 이미 있다.)
public class FrontController {

	// 사용자가 emp,dept작업할것인지 결정
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		boolean isStop = false;
		CommonControllerInterface controller = null;
		do {
			System.out.println("emp, dept, job, end>>");
			String job = sc.next();
			
			switch(job) {
			case "emp" ->{controller = ControllerFactory.make("emp");}
			case "dept" ->{controller = ControllerFactory.make("dept");}
			case "job" ->{controller = ControllerFactory.make("job");}
			case "end" ->{isStop = true; continue;}
			default ->{continue;}
			}
			
			controller.execute(); //작업이 달라져도 사용법은 같다. (전략패턴)

		} while (!isStop);
		sc.close();
		System.out.println("MAIN END ===");

	}
}
