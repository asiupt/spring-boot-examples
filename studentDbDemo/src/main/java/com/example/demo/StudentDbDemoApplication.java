package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class StudentDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDbDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner DatabaseInit(StudentRepository repository)
	{
		/*
		Student student1 = new Student("Akshay Singh", "Maths", Status.STUDENT);
		Student student2 = new Student("Balbir Kumar", "Science", Status.GRADUATE);
		
		List<Student> students = Arrays.asList
		(
			student1,
			student2
		);
		*/
		
		List<Student> students = Arrays.asList
		(
			new Student("Akshay Singh", "Maths", Status.STUDENT),
			new Student("Balbir Kumar", "Science", Status.GRADUATE)
		);
		
		
		return args ->
		{
			repository.saveAll(students);
		};
		
		/*
		return args ->
		{
			repository.save(new Student("Akshay Singh", "Maths", Status.STUDENT));
			repository.save(new Student("Balbir Kumar", "Science", Status.GRADUATE));
		};
		*/
	}
}
