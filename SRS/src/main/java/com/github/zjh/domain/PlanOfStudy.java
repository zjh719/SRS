package com.github.zjh.domain;

import java.util.HashMap;

public class PlanOfStudy {
	private Students student; // 学生
	HashMap<String, Course> courseOffered; // 提供的课程
	HashMap<Students, PlanOfStudyEntry> planOfStudys; // 学习计划

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	public PlanOfStudy(Students student){
		this.setStudent(student);
	}

	public boolean isInPlanOfStudy(Course representedCourse) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}