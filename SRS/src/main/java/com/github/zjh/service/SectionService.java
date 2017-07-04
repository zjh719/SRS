package com.github.zjh.service;

import java.util.HashMap;
import java.util.List;

import com.github.zjh.domain.EnrollmentStatus;
import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;

/**
 * @author ZJH
 * @ 2017年6月25日 下午11:12:19
 * @describe
 */
public interface SectionService {
    
	
	
       /**
     * @Method 添加班次
     * @author ZJH
     * @ 2017年6月29日 上午10:39:48
     * @param section
     */
    void addSection(Section section);
    
    /**
     * @Method 删除班次
     * @author ZJH
     * @ 2017年6月29日 上午11:09:32
     * @param sectionNo
     */
    void delete(String sectionNo);
    
    /**
     * @Method 修改班次
     * @author ZJH
     * @ 2017年6月29日 上午11:09:48
     * @param section
     */
    void resetSection(Section section);
    
    /**
     * @Method  根据课程号找课程班次
     * @author ZJH
     * @ 2017年6月29日 上午11:49:59
     * @param courseNo
     * @return List<Section>
     */
    List<Section> getSectionByCourseNo(String courseNo);

	/**
	 * @Method 根据班次找学生
	 * @author ZJH
	 * @ 2017年6月29日 下午4:09:05
	 * @param sectionNo
	 * @return
	 */
    List<Students> findStudentBySectionNo(String sectionNo);

	/**
	 * @Method 找到老师这学期的所有课程
	 * @author ZJH
	 * @ 2017年6月29日 下午7:12:18
	 * @param professorId
	 * @return List
	 */
	List<Section> findSectionByProfessorId(String professorId);

	/**
	 * @Method 得到学生的所有班次
	 * @author ZJH
	 * @ 2017年7月1日 上午10:20:24
	 * @param id
	 * @return
	 */
	List<Section> findSectionByStudent(String id);

	/** 
	 * @Method 选课
	 * @author ZJH
	 * @ 2017年7月4日 下午12:48:57
	 * @param student
	 * @param sectionNo
	 * @param courseNo
	 * @return
	 */
	EnrollmentStatus selectCourse(Students student, int sectionNo, String courseNo);

	/** 添加选课
	 * @Method
	 * @author ZJH
	 * @ 2017年7月4日 下午2:38:22
	 * @param id
	 * @param sectionNo
	 * @param courseNo
	 */
	void addTranscript(String id, int sectionNo, String courseNo);

	HashMap<String, Section> findBySemester(String string);

	
	
    
}
