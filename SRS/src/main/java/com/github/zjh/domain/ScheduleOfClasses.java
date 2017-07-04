package com.github.zjh.domain;

import java.util.HashMap;

/**
 * @author ZJH
 * @ 2017年6月23日 下午1:06:24
 * @describe
 */
public class ScheduleOfClasses {
	
	
	private String semester; // 学期
	private HashMap<String, Section> sectionsOffered; // 提供的班次集合

	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSemester() {
		return semester;
	}
	public HashMap<String, Section> getSectionsOffered() {
		return sectionsOffered;
	}
	
	public ScheduleOfClasses(String semester) {
		this.setSemester(semester);
		sectionsOffered = new HashMap<String, Section>();
	}

	public ScheduleOfClasses(String semester, HashMap<String, Section> sectionsOffered ) {
		this.setSemester(semester);
		
		// 实例化支持空的集合
		this.sectionsOffered = sectionsOffered;
	}
	
	public void display() {
		System.out.println("课程计划： " + getSemester());
		System.out.println();

		for (Section s : sectionsOffered.values()) {
			s.setOfferedIn(this);
			s.display();
			System.out.println();
		}
	}


	/**
	 * @Method 添加班次
	 * @author ZJH
	 * @ 2017年6月23日 下午1:06:03
	 * @param section
	 */
	public void addSection(Section section) {
		String key = section.getRepresentedCourse().getCourseNo() + 
			     " - " + section.getSectionNo();
		sectionsOffered.put(key, section);

		section.setOfferedIn(this);
	}



	/**
	 * @Method 查找班次
	 * @author ZJH
	 * @ 2017年6月23日 下午1:06:26
	 * @param fullSectionNo
	 * @return
	 */
	public Section findSection(String fullSectionNo) {
		return sectionsOffered.get(fullSectionNo);
	}

	
	/**
	 * @Method 判断提供的班次是否为空
	 * @author ZJH
	 * @ 2017年6月23日 下午1:07:13
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (sectionsOffered.size() == 0) return true;
		else return false;
	}
}
