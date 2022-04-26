package com.ElectroGridEG.electrogrideg.dao;

import com.ElectroGridEG.electrogrideg.model.Employee;

public interface EmpDAO {
	public String insertEmp(Employee employee);
	
	public String updateEmp(Employee employee); 
	
	public String deleteEmp(String id);

	public String readEmp();
	

	

}
