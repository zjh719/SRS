package com.github.zjh.domain;

import java.util.ArrayList;

public class Professor extends Person{
    private String email;
	private String title; //职称
	private String department; //部门
	private ArrayList<Section> teaches;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	 public Professor(String id, String name,String password, String title, String department) {
		super(id, name, password);
		this.setTitle(title);
		this.setDepartment(department);
		teaches=new ArrayList<Section>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " (" + getTitle() + ", " +
			       getDepartment() + ")";
	}
	
	public  Professor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void display(){
		super.display();
		System.out.println("教师具体信息：");
		System.out.println("\t职称： "+this.getTitle());
		System.out.println("\t部门： "+this.getDepartment());
		displayTeachingAssignments();
		System.out.println();
	}


	/**
	 * @method 打印教学任务到console
	 * @author ZJH
	 */
	public void displayTeachingAssignments() {
		// TODO Auto-generated method stub
		System.out.println("教学任务： " +getName());
		if (teaches.size() == 0) {
			System.out.println("\t(没有教学任务)");
		}
		else for (Section s : teaches) {
			System.out.println("\t课程编号.:  " +
				s.getRepresentedCourse().getCourseNo());
			System.out.println("\t班次编号.:  " + 
				s.getSectionNo());
			System.out.println("\t课程名称:  " +
				s.getRepresentedCourse().getCourseName());
			System.out.println("\t时间:  " +
				s.getDayOfWeek() + " - " + 
				s.getTimeOfDay());
			System.out.println("\t-----");
		}
	}
	
	/**
	 * @method 教师同意教授某课程
	 * @author ZJH
	 * @param section
	 */
	public void agreeToTeach(Section section){
		teaches.add(section);
		// 给section添加授课教师
		section.setInstructor(this);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
