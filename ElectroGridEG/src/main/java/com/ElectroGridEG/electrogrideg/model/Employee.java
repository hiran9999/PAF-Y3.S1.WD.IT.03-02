package com.ElectroGridEG.electrogrideg.model;

public class Employee {
	
	private int id;
    private String empNo;
    private String empName;
    private String position;
    private String email;
    private int phone;


    public Employee(int id, String empNo, String empName, String position, String email, int phone) {
    	this.id = id;
    	this.empNo = empNo;
        this.empName = empName;
        this.position = position;
        this.email = email;
        this.phone = phone;
    }
    
    public Employee(String empNo, String empName, String position, String email, int phone) {
    	this.empNo = empNo;
        this.empName = empName;
        this.position = position;
        this.email = email;
        this.phone = phone;
	}

	public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmpNO() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


}