package com.github.zjh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.zjh.dao.CourseDao;
import com.github.zjh.domain.Course;
import com.github.zjh.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService{
    
	@Autowired
	protected CourseDao courseDao;
	ArrayList<Course> allCourse =new ArrayList<Course>();
	HashMap<String, Course> all1Course = new HashMap<String ,Course>();
	
	@Override
	public List<Course> findAllCourse(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		allCourse=courseDao.findAllCourse();
		return allCourse;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.addCourse(course);
	}

	@Override
	public void delete(String courseNo) {
		// TODO Auto-generated method stub
		courseDao.delete(courseNo);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return courseDao.getTotal();
	}

	@Override
	public ArrayList<Course> fuzzyFindCourse(String searchCourse, int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		return courseDao.fuzzyFindCourse(searchCourse);
	}

	@Override
	public void resetCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.resetCourse(course);
	}



    
	
	
	

 
	
    
}
