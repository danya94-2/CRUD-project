package com.shinhan.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JavaBeans기술에서 사용가능해야 한다. (default 생성자, getter/setter)
//DTO (Data Transfer Object)
//칼럼의 이름과 Field가 일치하는 것이 좋다

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpDTO {
	private Integer employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private Double salary;
	private Double commission_pct;
	private Integer manager_id;
	private Integer department_id;
	
	/*
	 * 		st = conn.prepareStatement(sql);
				st.setInt(1, emp.getEMPLOYEE_ID());
				st.setString(2, emp.getFIRST_NAME());
				st.setString(3, emp.getLAST_NAME());
				st.setString(4, emp.getEMAIL());
				st.setString(5, emp.getPHONE_NUMBER());
				st.setDate(6, emp.getHIRE_DATE());
				st.setString(7, emp.getJOB_ID());
				st.setDouble(8, emp.getSALARY());
				st.setDouble(9, emp.getCOMMISSION_PCT());
				st.setInt(10, emp.getMANAGER_ID());
				st.setInt(11, emp.getDEPARTMENT_ID());
	 */
}

