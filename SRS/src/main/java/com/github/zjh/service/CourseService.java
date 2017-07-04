package com.github.zjh.service;

import java.util.ArrayList;
import java.util.List;

import com.github.zjh.domain.Course;

/**
 * @author ZJH
 * @ 2017年6月25日 下午11:12:01
 * @describe
 */
public interface CourseService {

	/**
	 * @Method 查找所有课程
	 * @author ZJH
	 * @ 2017年6月26日 上午11:26:18
	 * @return  HashMap
	 */
	List<Course> findAllCourse(int pageNumber, int pageSize);

	/**
	 * @Method 添加课程
	 * @author ZJH
	 * @ 2017年6月28日 下午8:04:02
	 * @param course
	 */
	void addCourse(Course course);

	/**
	 * @Method 删除课程
	 * @author ZJH
	 * @ 2017年6月28日 下午8:04:18
	 * @param courseNo
	 */
	void delete(String courseNo);

	/**
	 * @Method 分页
	 * @author ZJH
	 * @ 2017年6月28日 下午8:04:28
	 * @return
	 */
	int getTotal();

	/**
	 * @Method 模糊查询
	 * @author ZJH
	 * @ 2017年6月28日 下午8:04:37
	 * @param searchText
	 * @param pageNumber
	 * @param pageSize
	 * @return ArrayList<Course>
	 */
	ArrayList<Course> fuzzyFindCourse(String searchCourse, int pageNumber, int pageSize);

	void resetCourse(Course course);

	/**
	 * @Method 得到所有课程
	 * @author ZJH
	 * @ 2017年7月4日 下午7:27:07
	 * @return
	 */
}
