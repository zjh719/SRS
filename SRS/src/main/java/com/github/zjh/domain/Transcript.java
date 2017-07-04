package com.github.zjh.domain;
// Transcript.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A MODEL class.


import java.util.ArrayList;

/**
 * @author ZJH
 * @ 2017年6月23日 下午5:48:18
 * @describe 成绩单类
 */
public class Transcript {

	private ArrayList<TranscriptEntry> transcriptEntries; //成绩集合
	private Students studentOwner;//学生

	public ArrayList<TranscriptEntry> getTranscriptEntries() {
		return transcriptEntries;
	}

	public void setTranscriptEntries(ArrayList<TranscriptEntry> transcriptEntries) {
		this.transcriptEntries = transcriptEntries;
	}

	public void setStudentOwner(Students s) {
		studentOwner = s;
	}

	public Students getStudentOwner() {
		return studentOwner;
	}
	
	public Transcript(Students s) {
		setStudentOwner(s);
		transcriptEntries = new ArrayList<TranscriptEntry>();
	}


	/**
	 * @Method 确认是否完成该课程
	 * @author ZJH
	 * @ 2017年6月23日 下午5:51:00
	 * @param course
	 * @return boolean
	 */
	public boolean verifyCompletion(Course course) {
		
		boolean outcome = false;
		for (TranscriptEntry te : transcriptEntries) {
			Section s = te.getSection();
			
			// 判断班次是否属于课程
			if (s.isSectionOf(course)) {
				// 判断成绩是否通过
			    if (TranscriptEntry.passingGrade(te.getGrade())) {
				outcome = true;
				break;
			    }
			}
		}
		return outcome;
	}

	/**
	 * @Method 添加成绩
	 * @author ZJH
	 * @ 2017年6月23日 下午5:52:39
	 * @param te
	 */
	public void addTranscriptEntry(TranscriptEntry te) {
		transcriptEntries.add(te);
	}

	/**
	 * @Method 在控制台打印学生个人成绩单
	 * @author ZJH
	 * @ 2017年6月23日 下午5:53:12
	 */
	public void display() {
		System.out.println("学生个人成绩单:  " +
				   getStudentOwner().toString());

		if (transcriptEntries.size() == 0) {
			System.out.println("\t(无成绩)");
		}
		else for (TranscriptEntry te : transcriptEntries) {
			Section sec = te.getSection();

			Course c = sec.getRepresentedCourse();

			ScheduleOfClasses soc = sec.getOfferedIn();

			System.out.println("\t学期:        " +
					   soc.getSemester());
			System.out.println("\t课程编号.:      " +
					   c.getCourseNo());
			System.out.println("\t学分:         " +
					   c.getCredits());
			System.out.println("\t获得成绩:  " +
					   te.getGrade());
			System.out.println("\t-----");
		}
	}
}
