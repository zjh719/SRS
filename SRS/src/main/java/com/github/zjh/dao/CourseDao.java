package com.github.zjh.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.zjh.domain.Course;
import com.sun.javafx.collections.MappingChange.Map;


/**
 * @author ZJH
 * @ 2017年6月26日 下午6:15:10
 * @describe
 */
public interface CourseDao {

	/**
	 * @Method 查所有课程
	 * @author ZJH
	 * @ 2017年6月28日 下午12:12:05
	 * @return
	 */
	ArrayList<Course> findAllCourse();

	/**
	 * @Method 添加课程
	 * @author ZJH
	 * @ 2017年6月28日 下午12:12:02
	 * @param course
	 */
	void addCourse(Course course);
	
	
	/**
	 * @Method 删除课程
	 * @author ZJH
	 * @ 2017年6月28日 下午8:12:18
	 * @param courseNo
	 */
	void delete(String courseNo);

	/**
	 * @Method  得到课程总数
	 * @author ZJH
	 * @ 2017年6月28日 下午8:12:21
	 * @return 
	 */
	int getTotal();

	/**
	 * @Method  模糊查询
	 * @author ZJH
	 * @ 2017年6月28日 下午8:12:23
	 * @param searchCourse
	 * @return ArrayList<Course>
	 */
	ArrayList<Course> fuzzyFindCourse(String searchCourse);

	/**
	 * @Method  更新实验
	 * @author ZJH
	 * @ 2017年6月29日 上午12:00:40
	 * @param course
	 */
	void resetCourse(Course course);

	/**
	 * @Method  找出前置课程
	 * @author ZJH
	 * @ 2017年7月4日 下午12:55:37
	 * @param courseNo
	 * @return
	 */
	ArrayList<Course> findPreCourse(String courseNo);

}
