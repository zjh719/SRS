package com.github.zjh.domain;

public abstract class Person {
	private String id; //用户Id
	private String name; //用户姓名
	private String password; //用户密码
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


	/**
	 * @method 带参数的构造函数
	 * @author ZJH
	 * @param id
	 * @param name
	 * @param password
	 */
	public Person(String id,String name,String password){
		this.name = name;
		this.id = id;
		this.setPassword(password);
	}
	public Person(){
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString(); 

	/**
	 * @Method 在控制台打印用户信息
	 * @author ZJH
	 * @ 2017年6月22日 下午5:03:33
	 */
	public void display() {
		System.out.println("用户信息:");
		System.out.println("\t姓名:  " + this.getName());
		System.out.println("\t编号.:  " + this.getId());
	}

}
