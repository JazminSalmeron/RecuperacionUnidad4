package boot.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import boot.model.Student;
import boot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/all-students")
	public String allStudents(HttpServletRequest request){
		request.setAttribute("students",studentService.findAll());
		request.setAttribute("mode","MODE_STUDENTS");
		return "student";
	}
	
	@GetMapping("/new-student")
	public String newStudent(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "student";
	}
	
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student, BindingResult bidingResult, HttpServletRequest request){
		studentService.save(student);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "student";
		
	}
	
	@GetMapping("/update-student")
	public String updateStudent(@RequestParam int studentID, HttpServletRequest request){
		request.setAttribute("student", studentService.findStudent(studentID));
		request.setAttribute("mode", "MODE_UPDATE");
		return "student";
	}
	
	@GetMapping("/delete-student")
	public String deleteStudent(@RequestParam int studentID, HttpServletRequest request){
		studentService.delete(studentID);
		request.setAttribute("students", studentService.findAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "student";
	}



}
