package com.example.mongodbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbdemo.entity.Student;
import com.example.mongodbdemo.service.StudentService;


@RestController
//@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(path = "/")
	public String imUpAndRunning() {
		return "{healthy:true}";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Student getStudentbyId(@PathVariable String id) {
		return studentService.getStudentbyId(id);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/studentsByName/{name}")
	@ResponseBody
	public List<Student> studentsByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}
	
	@GetMapping("/studentsByNameAndMail")
	@ResponseBody
	public Student studentsByNameAndMail(@RequestParam String name,
			@RequestParam String email) {
		return studentService.studentsByNameAndMail(name, email);
	}
	
	@GetMapping("/studentsByNameOrMail")
	@ResponseBody
	public Student studentsByNameOrMail(@RequestParam String name,
			@RequestParam String email) {
		return studentService.studentsByNameOrMail(name, email);
	}
	
	@GetMapping("/allWithPagination")
	@ResponseBody
	public List<Student> getAllWithPagination(@RequestParam int pageNo,
			@RequestParam int pageSize) {
		return studentService.getAllWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/allWithSorting")
	@ResponseBody
	public List<Student> allWithSorting() {
		return studentService.allWithSorting();
	}
	
	@GetMapping("/byDepartmentName")
	@ResponseBody
	public List<Student> byDepartmentName(@RequestParam String deptName) {
		return studentService.byDepartmentName(deptName);
	}
	
	@GetMapping("/bySubjectName")
	@ResponseBody
	public List<Student> bySubjectName(@RequestParam String subName) {
		return studentService.bySubjectName(subName);
	}
	
	@GetMapping("/emailLike")
	@ResponseBody
	public List<Student> emailLike(@RequestParam String email) {
		return studentService.emailLike(email);
	}
	
	@GetMapping("/nameStartsWith")
	@ResponseBody
	public List<Student> nameStartsWith(@RequestParam String name) {
		return studentService.nameStartsWith(name);
	}
	
}
