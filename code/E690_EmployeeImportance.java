package com.jack.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
Description：
You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

Example 1:
Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
Output: 11
Explanation:
Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
Note:
One employee has at most one direct leader and may have several subordinates.
The maximum number of employees won't exceed 2000.
 * @author jiatg
 *
 */
public class A690_EmployeeImportance {

	public static void main(String[] args) {
		List list1 = new ArrayList();list1.add(2);list1.add(3);
		Employee id1 = new Employee(1,5,list1);
		
		Employee id2 = new Employee(2,3,null);
		Employee id3 = new Employee(3,3,null);
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(id1);emps.add(id2);emps.add(id3);
		System.out.println(getImportance(emps, 1));
	}
	
	/**
	 * submit records:
	 * 第1次提交wrong，只考虑了两层关系，其实是多层关系。子员工没有找全。
	 * 第2次提交Accepted，beats 7% ，复杂度很高，要想办法优化。
	 */
	public static int getImportance(List<Employee> employees, int id) {
		int result = 0;
		/*
		 * 得到父Emplyee对象
		 */
		Employee emp = null;
		List<Integer> ids = new ArrayList<Integer>();
		for(Employee e : employees)
			if(id == e.id){
				emp = e;
				break;
			}
		ids =  getSonImportance(emp, employees, ids);
		for(int i : ids)
			for(Employee e : employees)
				if(e.id == i)
					result += e.importance;
		return result;
    }
	/**
	 * 得到所有员工的id
	 */
	public static List<Integer> getSonImportance(Employee e, List<Employee> employees, List<Integer> ids){
		ids.add(e.id);
		if(e.subordinates != null)
			for(int id : e.subordinates)
				for(Employee emp : employees)
					if(id == emp.id)
						getSonImportance(emp,employees,ids);
		return ids;
	}
}
class Employee{
	public Employee(int i, int j, List list) {
		this.id = i;
		this.importance = j;
		this.subordinates = list;
	}
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
}