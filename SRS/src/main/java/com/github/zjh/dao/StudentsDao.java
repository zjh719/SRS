package com.github.zjh.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;



/**
 * @author ZJH
 * @since Jdk1.8
 * @describe 
 * @time 2017年6月1日下午5:13:20
 */
public interface StudentsDao {

	
	/**
	 * @method 根据id删除student
	 * @author ZJH
	 * @param id
	 */
	void deleteById(String id); 
	
	/**
	 * @method 查询所有students
	 * @author ZJH
	 * @return List<Students>
	 */
	List<Students> queryAll();

	/**
	 * @method 查询总数
	 * @author ZJH
	 * @return
	 */
	int count();

	/**
	 * @method 检查登录
	 * @author ZJH
	 * @param students_id
	 * @param password
	 * @return List<Students>
	 */
	List<Students> checkLogin(@Param("students_id")String students_id, @Param("password")String password);

	/**
	 * @method 根据ID查询students
	 * @author ZJH
	 * @param students_id
	 * @return List<Students>
	 */
	Students queryById(String id);

	/**
	 * @method 添加学生
	 * @author ZJH
	 * @param students
	 */
	void addStudents(Students students);

	/**
	 * @Method 根据 no 找学生(成绩)
	 * @author ZJH
	 * @ 2017年7月4日 下午12:53:23
	 * @param sectionNo
	 * @param courseNo
	 * @return
	 */
	ArrayList<Students> findStudentBySCNo(int sectionNo, String courseNo);
	
}
