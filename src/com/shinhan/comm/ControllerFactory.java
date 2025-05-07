package com.shinhan.comm;

import com.shinhan.dept.DeptController;
import com.shinhan.emp.EmpController;
import com.shinhan.job.JobController;

//Factory 패턴
public class ControllerFactory {

	public static CommonControllerInterface make(String business) {
		CommonControllerInterface controller = null;
		switch(business) {
		case "emp" ->{controller = new EmpController();}
		case "dept" ->{controller = new DeptController();}
		case "job" ->{controller = new JobController();}
		}
		
		return controller;
	}

}
