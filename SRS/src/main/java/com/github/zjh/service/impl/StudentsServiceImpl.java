/**
 * @author ZJH
 * @since JDK1.8
 * @describe 
 * @time 2017��6��1������6:46:18
 */
package com.github.zjh.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.zjh.dao.StudentsDao;
import com.github.zjh.domain.Section;
import com.github.zjh.domain.Students;
import com.github.zjh.service.StudentsService;
import com.github.pagehelper.PageHelper;

/**
 * @author ZJH
 * @ 2017年6月26日 下午6:22:58
 * @describe
 */
@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private StudentsDao studentsDao;

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		studentsDao.deleteById(id);
	}

	@Override
	public List<Students> queryAll() {
		// TODO Auto-generated method stub
		return studentsDao.queryAll();
	}

	@Override
	public List<Students> queryByPage(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		return studentsDao.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return studentsDao.count();
	}

	@Override
	public Students queryById(String students_id) {
		// TODO Auto-generated method stub
		return studentsDao.queryById(students_id);
	}

	@Override
	public void addStudents(Students students) {
		// TODO Auto-generated method stub
		studentsDao.addStudents(students);
	}

	@Override
	public Boolean checkLogin(String students_id, String password) {
		if (studentsDao.queryById(students_id) != null && password.equals(studentsDao.queryById(students_id).getPassword())) return true;
		else return false;
	}
    

	
	

}
