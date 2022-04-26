package com.ElectroGridEG.electrogrideg.dao;

import java.util.List;

import com.ElectroGridEG.electrogrideg.model.Employee;

public interface EmpDAO {
	public String insertEmp(Employee employee);
	
	public List<Employee> list();
	
	public String updateEmp(Employee employee); 
	
	public String deleteEmp(Integer id);

	public String readEmp();
	

	

}
