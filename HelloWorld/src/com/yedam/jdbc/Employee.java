package com.yedam.jdbc;

/*
 * table (employees) ->
 */

public class Employee {
	private int employeeId;	// employee_id => employeeId 필수!
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private String salary;
	private String commisionPct;
	private int managerId;
	private int departmentId;
	public Employee(int employeeID, String firstName, String lastName, String email, String phoneNumber, 
					String hireDate, String jobId, String salary, String commisionPct, int managerId, int departmentId) {
		setEmployeeId(employeeId);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setHireDate(hireDate);
		setJobId(jobId);
		setSalary(salary);
		setCommisionPct(commisionPct);
		setManagerId(managerId);
		setDepartmentId(departmentId);
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCommisionPct() {
		return commisionPct;
	}
	public void setCommisionPct(String commisionPct) {
		this.commisionPct = commisionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
