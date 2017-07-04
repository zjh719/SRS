package com.github.zjh.domain;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ZJH
 * @ 2017年6月22日 下午4:34:24
 * @describe 课程领域类
 */
public class Course {
   private String courseNo; //课程编号
   private String courseName; //课程名字
   private double credits; //学分
   private ArrayList<Section> offeredAsSection;//课程班次集合
   private ArrayList<Course> prerequisites; //先修课程
   
 
    public String getCourseNo() {
	   return courseNo;
}

   public void setCourseNo(String courseNo) {
	this.courseNo = courseNo;
}



   public double getCredits() {
	return credits;
}

   public void setCredits(double credits) {
	this.credits = credits;
}
public Course(){}
public Course(String cNo, String cName, double credits) {
		setCourseNo(cNo);
		setCourseName(cName);
		setCredits(credits);
		// Note that we're instantiating empty support Collection(s).

		offeredAsSection = new ArrayList<Section>();
		prerequisites = new ArrayList<Course>();
		} 

/**
 * @Method 在控制台打印课程信息
 * @author ZJH
 * @ 2017年6月22日 下午4:40:09
 */
public void display() {
	 System.out.println("Course Information:");
	 System.out.println("\tCourse No.:  " + getCourseNo());
	 System.out.println("\tCourse Name:  " + getCourseName());
	 System.out.println("\tCredits:  " + getCredits());
	 System.out.println("\tPrerequisite Courses:");

	for (Course course : prerequisites) {
		System.out.println("\t\t" + course.toString());
	}

	// Note use of print vs. println in next line of code.
	System.out.print("\tOffered As Section(s):  ");
	for (Section section : offeredAsSection) {
		System.out.print(section.getSectionNo() + " ");
	}

}


  @Override
    public String toString() {
	return getCourseNo() + ":  " + getCourseName();
 }

   /**
 * @Method 添加先修课程
 * @author ZJH
 * @ 2017年6月22日 下午4:41:28
 * @param course
 */
   public void setPrerequisite(ArrayList<Course> courses) {
	prerequisites.addAll(courses);
}


/**
 * @Method 检验是否拥有先修课程
 * @author ZJH
 * @ 2017年6月22日 下午4:44:13
 * @return boolean
 */
public boolean hasPrerequisites() {
	if (prerequisites.size() > 0) return true;
	else return false;
}

   /**
 * @Method 得到所有先修课程
 * @author ZJH
 * @ 2017年6月22日 下午4:45:37
 * @return Collection
 */
  public Collection<Course> getPrerequisites() {
	return prerequisites;
}
  
  
  /**
 * @Method 课程表安排
 * @author ZJH
 * @ 2017年6月22日 下午4:46:29
 * @param day
 * @param time
 * @param room
 * @param capacity 容量
 * @return
 */
  public Section scheduleSection(char day, String time, String room,
		       int capacity) {
// Create a new Section (note the creative way in创建一个新的班次
// which we are assigning a section number) ...
     Section s = new Section(offeredAsSection.size() + 1, day, time, this, room, capacity);

// ... and then remember it!添加班次

        addSection(s);

        return s;
     }

      /**
     * @Method 添加班次
     * @author ZJH
     * @ 2017年6月22日 下午4:50:36
     * @param s
     */
    public void addSection(Section section) {
           offeredAsSection.add(section);
}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void addPrerequisite(Course c4) {
		// TODO Auto-generated method stub
		
	}

   
   
}
