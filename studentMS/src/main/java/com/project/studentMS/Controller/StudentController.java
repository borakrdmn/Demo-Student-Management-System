package com.project.studentMS.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.studentMS.Business.IStudentService;
import com.project.studentMS.Entities.Student;

@Controller
public class StudentController {
	private IStudentService studentService;

	@Autowired
	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String get(Model model){
		model.addAttribute("students",studentService.getAll());
		return "students";
	}
	

	  @GetMapping("/students/add") 
	  public String add(Model model) {
		  Student student = new Student();
		  model.addAttribute("student",student);
		  return "add";
	  }
	  
	 @PostMapping("/students")
	 public String saveStudent(@ModelAttribute("student") Student student) {
		 studentService.add(student);
		 return "redirect:/students";
	 }
	 
	 @GetMapping("/students/edit/{id}")
	 public String editStudent(@PathVariable int id,Model model) {
		 model.addAttribute("student",studentService.getById(id));
		 return "edit";
	 }
	 @PostMapping("/students/{id}")
	 public String updateStudent(@PathVariable int id, @ModelAttribute("student")Student student,Model model) {
		 Student existedOne = studentService.getById(id);
		 existedOne.setFirstName(student.getFirstName());
		 existedOne.setLastName(student.getLastName());
		 existedOne.setEmail(student.getEmail());
		 existedOne.setGrade(student.getGrade());
		 
		 studentService.update(existedOne);
		 return "redirect:/students";
	 }
	 
	 @GetMapping("/students/{id}")
	 public String delete(@PathVariable int id) {
		 Student deleted = studentService.getById(id);
		 studentService.delete(deleted);
		 return "redirect:/students";
		 
	 }

	
}
