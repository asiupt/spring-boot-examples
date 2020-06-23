package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDBController
{
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentDBController(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}

	@GetMapping("/students")
	public List<Student> findStudentAll()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student findStudentById(@PathVariable Long id)
	{
		//Student student = studentRepository.findById(id);
		Optional<Student> optStudent = studentRepository.findById(id);
		if(optStudent.isPresent())
		{
			return optStudent.get();
		}
		return null;
		
	}
	
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
	}
	
	@PutMapping("/students/{id}")
	public void updateStudentById(@RequestBody Student student, @PathVariable Long id)
	{
		studentRepository.save(student);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteStudentById(@PathVariable Long id)
	{
		studentRepository.deleteById(id);
	}
	
}
