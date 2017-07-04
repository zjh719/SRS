package com.github.zjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zjh.dao.ProfessorDao;
import com.github.zjh.domain.Professor;
import com.github.zjh.service.ProfessorService;
@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
    private ProfessorDao professorDao;
	
	@Override
	public boolean checkLogin(String id, String password) {
		// TODO Auto-generated method stub
		if (professorDao.findProfessorById(id) != null && password.equals(professorDao.findProfessorById(id).getPassword())) return true;
		else return false;
	}
	@Override
	public Professor findProfessorById(String id) {
		// TODO Auto-generated method stub
		return professorDao.findProfessorById(id);
	}

}
