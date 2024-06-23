package many_to_one_uni_prc_day2.controller;

import many_to_one_uni_prc_day2.dao.SchoolDao;
import many_to_one_uni_prc_day2.dao.StudentDao;
import many_to_one_uni_prc_day2.dao.TeacherDao;
import many_to_one_uni_prc_day2.dto.School;
import many_to_one_uni_prc_day2.dto.Student;
import many_to_one_uni_prc_day2.dto.Teacher;

public class Main {

	public static void main(String[] args) {

//		School school = new School();
//		school.setName("DPS");
//		school.setLocation("BLR");
//
//		SchoolDao dao = new SchoolDao();
//		dao.saveSchool(school);
//		dao.deleteSchool(1);

		Student s1 = new Student();
		s1.setName("Raj");
		s1.setAddress("BLR");

		StudentDao dao = new StudentDao();
		dao.updateStudent(1, s1);
		
//		Teacher t1=new Teacher();
//		t1.setName("Nagesh");
//		t1.setAddress("CTA");
//		
//		TeacherDao dao=new TeacherDao();
//		dao.saveTeacher(1,t1);
	}

}
