package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Table(name = "STUDENT_LIST")
@Entity
public class Student
{
	
	private @Id @GeneratedValue Long id;
	
	private String name;
	private String course;
	private Status status;
	
	public Status getStatus()
	{
		return this.status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public Student(String name, String course, Status status)
	{
		this.name = name;
		this.course = course;
		this.status = status;
	}

	private Student()
	{
		
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(course, id, name, status);
	}
	

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(course, other.course) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(status, other.status);
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", status=" + status + "]";
	}
	
	
}
