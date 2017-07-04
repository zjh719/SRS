package com.github.zjh.service;

import com.github.zjh.domain.Professor;

/**
 * @author ZJH
 * @ 2017年6月25日 下午8:27:59
 * @describe
 */
public interface ProfessorService {

	boolean checkLogin(String id, String password);

	/**
	 * @Method 根据老师得到一个老师
	 * @author ZJH
	 * @ 2017年6月25日 下午7:26:17
	 * @param id
	 * @return Professor
	 */
	Professor findProfessorById(String id);

}
