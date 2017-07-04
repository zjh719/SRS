


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.zjh.dao.StudentsDao;
import com.github.zjh.domain.EnrollmentStatus;
import com.github.zjh.domain.Professor;
import com.github.zjh.domain.ScheduleOfClasses;
import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;
import com.github.zjh.service.CourseService;
import com.github.zjh.service.ProfessorService;
import com.github.zjh.service.ScheduleService;
import com.github.zjh.service.SectionService;
import com.github.zjh.service.StudentsService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-config.xml"})
@ActiveProfiles("mysql")//测试mysql数据库（测试sqlite是变为sqlite）
@Transactional//事务回滚，测试成功后不会持久化到数据库（如果不需要可不加）
public class ControllerTest {
	@Resource(name="studentService")
	protected StudentsService studentService;
	@Resource(name="professorService")
	protected ProfessorService professorService;
	@Resource(name="courseService")
	protected CourseService courseService;
	@Resource(name="sectionService")
	protected SectionService sectionService;
	@Resource(name="scheduleService")
	protected ScheduleService scheduleService;
	@Autowired
	protected StudentsDao studentsDao;
	
	
	@Test
	public void SRSTest(){
		HashMap<String , Section> offeredSection = sectionService.findBySemester("1");
		/*创建课程表*/
		ScheduleOfClasses scheduleOfClasses = new ScheduleOfClasses("1", offeredSection);
		scheduleOfClasses.display(); 
		/*老师登录系统*/
		if (professorService.checkLogin("09143600", "123456"));
		Professor professor = professorService.findProfessorById("09143600");
		System.out.println("----欢迎"+professor.toString()+"登录系统----");
		
		/* 
		 * 教师选择授课课程
		 * 输出教师授课信息
		 * 
		 * */
		for (Section section : offeredSection.values()) {
			System.out.println("----"+professor.getName()+"正在选择授课课程----"+section.toString()+"----");
			professor.agreeToTeach(section);
		}
		professor.display();
		professor.displayTeachingAssignments();
		
		/*学生登录系统*/
		if (studentService.checkLogin("09143602", "123456"));
			Students student = studentService.queryById("09143602");
			System.out.println("----欢迎"+student.toString()+"登录系统----");
			System.out.println();
		
		/*
		 * 学生选课
		 * 输出选课结果
		 * 
		 * */
		// 获取班次信息
		Section section1 = offeredSection.get("ABC-104-1");
		System.out.println("----"+student.getName()+"正在选课----"+section1.toString()+"----");
		// 验证学生是否选课成功
		EnrollmentStatus enrollmentStatus1 = section1.enroll(student);
		System.out.println(enrollmentStatus1.value());
		
		Section section2 = offeredSection.get("ABC-103-1");
		System.out.println("----"+student.getName()+"正在选课----"+section2.toString()+"----");
		// 验证学生是否选课成功
		EnrollmentStatus enrollmentStatus2 = section2.enroll(student);
		System.out.println(enrollmentStatus2.value());
		System.out.println();
		
		/*
		 * 教师给予学生课程成绩
		 * 
		 * */
		System.out.println("----"+professor.getName()+"正在填写课程成绩----");
		section1.postGrade(student, "A+");
		section2.postGrade(student, "F");
		System.out.println();
		
		/*
		 * 学生查看个人信息
		 * 个人课程表
		 * 个人成绩单
		 * */
		System.out.println("----"+student.getName()+"正在查看个人信息----");
		student.display();
		
	}
	
}
