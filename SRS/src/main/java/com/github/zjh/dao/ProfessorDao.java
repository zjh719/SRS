package com.github.zjh.dao;

import com.github.zjh.domain.Professor;

public interface ProfessorDao {

	

	/**
	 * @Method
	 * @author ZJH
	 * @ 2017年6月26日 下午6:15:19
	 * @param id
	 * @return
	 */
	Professor findProfessorById(String id);

}
