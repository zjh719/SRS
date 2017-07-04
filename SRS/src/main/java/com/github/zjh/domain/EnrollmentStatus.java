package com.github.zjh.domain;

// EnrollmentStatus.java - Chapter 14, Java 5 version.

// Copyright 2005 by Jacquie Barker - all rights reserved.

// A SUPPORT enum.


// Used by the Section class to represent various possible outcomes of
// an attempt to enroll by a Student.

public enum EnrollmentStatus {
	// Enumerate the values that the enum can assume.
	success("报名成功!  :o)"), 
	secFull("报名失败;  班次已排满.  :op"), 
	prereq("报名失败; 未满足前置课程.  :op"), 
	prevEnroll("报名失败; 已报名.  :op");

	// 枚举实例的值
	private final String value;

	// A "constructor" of sorts (used above).
	EnrollmentStatus(String value) {
		this.value = value;
	}

	// Accessor for the value of an enum instance.
	/**
	 * @Method 对枚举实例的访问
	 * @author ZJH
	 * @ 2017年6月23日 下午1:12:43
	 * @return String
	 */
	public String value() {
		return value;
	}
}
