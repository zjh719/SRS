package com.github.zjh.domain;

import java.util.ArrayList;

//Student.java - Chapter 14, Java 5 version.

//Copyright 2005 by Jacquie Barker - all rights reserved.

//A MODEL class.
import java.util.Collection;

/**
 * @author ZJH
 * @ 2017年6月22日 下午5:06:33
 * @describe Person下的student类
 */
public class Students extends Person {
	private String major; //专业
	private String degree;   //学位
	private String grade;  //年级
	private String email;
	private PlanOfStudy planOfStudy;//学习计划
	private Transcript transcript; //成绩单
	private ArrayList<Section> attends; //课程班次
	
	public ArrayList<Section> getAttends() {
		return attends;
	}

	public void setAttends(ArrayList<Section> attends) {
		this.attends = attends;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

	public void setTranscript(Transcript t) {
		transcript = t;
	}

	public Transcript getTranscript() {
		return transcript;
	}
	
	public PlanOfStudy getPlanOfStudy() {
		return planOfStudy;
	}

	public void setPlanOfStudy(PlanOfStudy planOfStudy) {
		this.planOfStudy = planOfStudy;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Students(String id, String name,String password, String grade, String major) {
		super(id, name,password);
		this.setGrade(grade);
		this.setMajor(major);
		/*创建一个新的学习计划*/
		this.setPlanOfStudy(new PlanOfStudy(this));
		
		/*创建一个新的成绩单*/
		this.setTranscript(new Transcript(this));
		
		/*实例化集合*/
		attends = new ArrayList<Section>();
		
	}	
	
	// A second simpler form of constructor.


	/**
	 * @method 重用构造函数
	 * @author ZJH
	 * @param id
	 */
	public Students(String id){
		this(id, "", "", "","");
	}
	public Students(){
	}
	//------------------
	// Accessor methods.
	//------------------

	

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	@Override
	public void display() {
		// First, let's display the generic Person info.

		super.display();
		
		// Then, display Student-specific info.

		System.out.println("Student-Specific Information:");
		System.out.println("\tMajor:  " + this.getMajor());
		System.out.println("\tDegree:  " + this.getDegree());
		this.displayCourseSchedule();
		this.printTranscript();

		// Finish with a blank line.
		System.out.println();
	}	
	// We are forced to program this method because it is specified
	// as an abstract method in our parent class (Person); failing to
	// do so would render the Student class abstract, as well.
	//
	// For a Student, we wish to return a String as follows:
	//
	// 	Joe Blow (123-45-6789) [Master of Science - Math]

	@Override
	public String toString() {
		
		return this.getName() + " (" + this.getId() + ") [" + this.getGrade() +
			       " - " + this.getMajor() + "]";
	}

	public void displayCourseSchedule() {
		// Display a title first.

		System.out.println("Course Schedule for " + this.getName());
		
		// Step through the ArrayList of Section objects, 
		// processing these one by one.

		for (Section s : attends) {
		    // Since the attends ArrayList contains Sections that the
		    // Student took in the past as well as those for which
		    // the Student is currently enrolled, we only want to
		    // report on those for which a grade has not yet been
		    // assigned.
         
                 if (s.getGrade(this) == null) {
			System.out.println("\t课程编号.:  " + 
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\t选课编号.:  " + 
				s.getSectionNo());
			System.out.println("\t课程名字:  " + 
				s.getRepresentedCourse().getCourseName());
			System.out.println("\t:  "  +
				s.getDayOfWeek() + " - " +
				s.getTimeOfDay());
			System.out.println("\t教室:  "  +
				s.getRoom());
			System.out.println("\t教师姓名:  " +
				s.getInstructor().getName());
			System.out.println("\t-----");
		    }
		}
	}
	
	public void addSection(Section s) {
		attends.add(s);
	}
	
	public void dropSection(Section s) {
		attends.remove(s);
	}
	
	// Determine whether the Student is already enrolled in THIS
	// EXACT Section.

	public boolean isEnrolledIn(Section s) {
		if (attends.contains(s)) return true;
		else return false;
	}
		
	// Determine whether the Student is already enrolled in ANOTHER
	// Section of this SAME Course.

	public boolean isCurrentlyEnrolledInSimilar(Section s1) {
		boolean foundMatch = false;

		Course c1 = s1.getRepresentedCourse();

		for (Section s2 : attends) {
			Course c2 = s2.getRepresentedCourse();
			if (c1 == c2) {
				// There is indeed a Section in the attends()
				// ArrayList representing the same Course.
				// Check to see if the Student is CURRENTLY
				// ENROLLED (i.e., whether or not he has
				// yet received a grade).  If there is no
				// grade, he/she is currently enrolled; if
				// there is a grade, then he/she completed
				// the course some time in the past.
				if (s2.getGrade(this) == null) {
					// No grade was assigned!  This means
					// that the Student is currently
					// enrolled in a Section of this
					// same Course.
					foundMatch = true;
					break;
				}
			}
		}

		return foundMatch;
	}
		
	public void printTranscript() {
		this.getTranscript().display();
	}

	public Collection<Section> getEnrolledSections() {
		return attends;
	}






}

