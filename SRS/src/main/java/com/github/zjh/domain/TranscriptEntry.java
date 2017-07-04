package com.github.zjh.domain;

public class TranscriptEntry {

	private String grade; //成绩
	private Students student; //学生
	private Section section; //选课记录
	private Transcript transcript; //成绩单

	public void setStudent(Students s) {
		student = s;
	}

	public Students getStudent() {
		return student;
	}

	public void setSection(Section s) {
		section = s;
	}

	public Section getSection() {
		return section;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setTranscript(Transcript t) {
		transcript = t;
	}

	public Transcript getTranscript() {
		return transcript;
	}
	
	public TranscriptEntry(Students s, String grade, Section se) {
		this.setStudent(s);
		this.setSection(se);
		this.setGrade(grade);

		Transcript t = s.getTranscript();
		this.setTranscript(t);
		t.addTranscriptEntry(this);
	}

	/**
	 * @Method 验证成绩等级是否正确
	 * @author ZJH
	 * @ 2017年6月23日 下午5:57:44
	 * @param grade
	 * @return boolean
	 */
	public static boolean validateGrade(String grade) {
		boolean outcome = false;

		if (grade.equals("F") ||
		    grade.equals("I")) {
			outcome = true;
		}

		if (grade.startsWith("A") ||
		    grade.startsWith("B") ||
		    grade.startsWith("C") ||
		    grade.startsWith("D")) {
			if (grade.length() == 1) outcome = true;
			else if (grade.length() == 2) {
				if (grade.endsWith("+") ||
				    grade.endsWith("-")) {
					outcome = true;
				}
			}
		}

		return outcome;
	}

	/**
	 * @Method 
	 * @author ZJH
	 * @ 2017年6月23日 下午5:59:30
	 * @param grade
	 * @return boolean
	 */
	public static boolean passingGrade(String grade) {
		boolean outcome = false;

		// First, make sure it is a valid grade.验证成绩是否有效

		if (validateGrade(grade)) {
			// Next, make sure that the grade is a D or better.
             //哦按段等级是否合格
			if (grade.startsWith("A") ||
			    grade.startsWith("B") ||
			    grade.startsWith("C") ||
			    grade.startsWith("D")) {
				outcome = true;
			}
		}
		return outcome;
	}
}
