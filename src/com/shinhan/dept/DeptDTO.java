package com.shinhan.dept;

import java.util.Objects;

import lombok.Builder;

@Builder
public class DeptDTO {
	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;

	public DeptDTO() {
		
	}

	public DeptDTO(int department_id, String department_name, int manager_id, int location_id) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}

	public int getDEPARTMENT_ID() {
		return department_id;
	}

	public void setDEPARTMENT_ID(int department_id) {
		this.department_id  = department_id;
	}

	public String getDEPARTMENT_NAME() {
		return department_name;
	}

	public void setDEPARTMENT_NAME(String department_name) {
		this.department_name = department_name;
	}

	public int getMANAGER_ID() {
		return manager_id;
	}

	public void setMANAGER_ID(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getLOCATION_ID() {
		return location_id;
	}

	public void setLOCATION_ID(int location_id) {
		this.location_id = location_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department_id, department_name, location_id, manager_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptDTO other = (DeptDTO) obj;
		return department_id == other.department_id && Objects.equals(department_name, other.department_name)
				&& location_id == other.location_id && manager_id == other.manager_id;
	}

	@Override
	public String toString() {
		return 	"부서 ID = " + department_id 
				+ ", 부서이름 = " + department_name 
				+ ", 매니저 ID = "+ manager_id 
				+ ", 장소 ID = " + location_id ;
	}
	
	
}
