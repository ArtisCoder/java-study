package com.wjg.beans;

public class TeacherFactory {

	public Teacher createTeacher() {
		Teacher teacher = new Teacher();
		System.out.println("TeacherFactory 负责创建 teacher类实例对象..");
		return teacher;
	}
}
