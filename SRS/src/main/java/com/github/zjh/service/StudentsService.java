
package com.github.zjh.service;

import java.util.List;

import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;


/**
 * @author ZJH
 * @since Jdk1.8
 * @describe 
 * @time 2017年6月1日下午6:44:44
 */
public interface StudentsService {
	
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
	 * @method 分页查询
	 * @author ZJH
	 * @param pageNumber 当前页码
	 * @param pageSize   每页数量
	 * @return List<Students>
	 */
	List<Students> queryByPage(int pageNumber,int pageSize);
	
	/**
	 * @method 查询总页数
	 * @author ZJH
	 * @return
	 */
	int count();

	/**
	 * @method 登录验证
	 * @author ZJH
	 * @param students_id
	 * @param password
	 * @return Boolean
	 */
	Boolean checkLogin(String students_id, String password);
	
	/**
	 * @Method  得到
	 * @author ZJH
	 * @ 2017年6月28日 上午11:35:10
	 * @param students_id
	 * @return
	 */
	Students queryById(String students_id);

	/**
	 * @method 添加学生
	 * @author ZJH
	 * @param students
	 */
	void addStudents(Students students);

	

	



}
