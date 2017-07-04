package com.github.zjh.domain;

import java.util.HashMap;

public class CourseCatalog {
	private HashMap<String, Course> courses;
	
	public CourseCatalog() {
		// Note that we're instantiating empty support Collection(s).

		courses = new HashMap<String, Course>();
	}
	
	public CourseCatalog(HashMap<String, Course> courses) {
		// Note that we're instantiating empty support Collection(s).

		this.courses = courses;
	}
	public void display() {
		// Iterate through the HashMap and display all entries.

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

}
