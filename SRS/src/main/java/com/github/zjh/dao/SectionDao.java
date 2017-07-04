package com.github.zjh.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;

public interface SectionDao {
   
	/**
	 * @Method 添加课程
	 * @author ZJH
	 * @ 2017年6月29日 上午11:33:19
	 * @param section
	 */
	void addSection(Section section);
	
	/**
	 * @Method 删除课程
	 * @author ZJH
	 * @ 2017年6月29日 上午11:33:21
	 * @param sectionNo
	 */
	void delete(String sectionNo);
	
	/**
	 * @Method 重置课程
	 * @author ZJH
	 * @ 2017年6月29日 上午11:33:23
	 * @param section
	 */
	void resetSection(Section section);

	
	
	/**
	 * @Method 根据课程号找到课程班次
	 * @author ZJH
	 * @ 2017年6月29日 上午11:49:13
	 * @param courseNo
	 * @return List<Section>
	 */
	ArrayList<Section> getSectionByCourseNo(String courseNo);

	/**
	 * @Method 根据班次找学生
	 * @author ZJH
	 * @ 2017年6月29日 下午6:41:47
	 * @param sectionNo
	 * @return List<Students>
	 */
	ArrayList<Students> findStudentBySectionNo(String sectionNo);

	/**
	 * @Method 根据老师Id和学期找所有section
	 * @author ZJH
	 * @ 2017年6月29日 下午7:14:16
	 * @param professorId
	 * @return
	 */
	ArrayList<Section> findSectionByProfessorId(String professorId);

	/**
	 * @Method 根据学生找班次
	 * @author ZJH
	 * @ 2017年7月1日 上午10:25:00
	 * @param id
	 * @return
	 */
	List<Section> findSectionByStudent(String id);

	/**
	 * @Method 找到course 、section、teacher
	 * @author ZJH
	 * @ 2017年7月4日 下午12:47:58
	 * @param courseNo
	 * @param sectionNo
	 * @return
	 */
	Section findSectionByCSNo(String courseNo, int sectionNo);

	HashMap<String, Section> findBySemester(String semester);

	
}
