package OneToMany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToMany_bi.dao.EmployeeDao;
import OneToMany_bi.dto.Company;
import OneToMany_bi.dto.Employee;

public class MainController {

	public static void main(String[] args) {
		Company company = new Company();
		company.setId(1003);
		company.setName("Meta");
		company.setGst("ABC456");

		Employee e1 = new Employee();
		e1.setId(7);
		e1.setName("PushKeerthi");
		e1.setPhone(741963852);

		Employee e2 = new Employee();
		e2.setId(8);
		e2.setName("Ravi");
		e2.setPhone(963852741);

		Employee e3 = new Employee();
		e3.setId(6);
		e3.setName("Raki");
		e3.setPhone(852741963);

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		e1.setCompany(company);
		e2.setCompany(company);
		e3.setCompany(company);

		EmployeeDao dao = new EmployeeDao();
//		dao.saveEmployee(1002, e1);
//		dao.saveEmployee(1002, e2);
//		dao.saveEmployee(1002, e3);

		dao.updateEmployee(7, e1);

//		dao.deleteEmployee(6);

//		Employee employee = dao.getEmployeeById(1);
//		System.out.println(employee);

//		List<Employee> list1 = dao.getAllEmployee();
//		System.out.println(list1);
	}

}
