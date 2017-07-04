package com.github.zjh.dao;

import java.util.ArrayList;

import com.github.zjh.domain.Students;
import com.github.zjh.domain.TranscriptEntry;

/**
 * @author ZJH
 * @ 2017年7月4日 下午2:39:58
 * @describe
 */
public interface TranscriptDao {

	/**
	 * @Method  根据学生找成绩
	 * @author ZJH
	 * @ 2017年7月4日 下午2:40:05
	 * @param student
	 * @return
	 */
	ArrayList<TranscriptEntry> findTranscriptForStudent(Students student);

	/**
	 * @Method 插入学生选课记录
	 * @author ZJH
	 * @ 2017年7月4日 下午2:40:03
	 * @param id
	 * @param sectionNo
	 * @param courseNo
	 */
	void addTranscript(String id, int sectionNo, String courseNo);
 
}
