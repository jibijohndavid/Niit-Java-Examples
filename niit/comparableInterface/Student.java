package com.niit.comparableInterface;

public class Student implements Comparable<Student> {
	String Name;
	int Id;
	double Gpa;

	@Override
	public int compareTo(Student o) {
		int result = 0;
		result = this.Name.compareTo(o.Name);		
		return result;
	}

	Student(String Name, int Id, double Gpa) {
		this.Name = Name;
		this.Id = Id;
		this.Gpa = Gpa;
	}

	public String toString() {
		return ( '\n' +" Name : " + Name + " Id = " + Id + " Gpa = " + Gpa );
	}
}
