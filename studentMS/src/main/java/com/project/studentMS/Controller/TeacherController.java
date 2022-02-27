package com.project.studentMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.studentMS.Business.ITeacherService;
import com.project.studentMS.Entities.Teacher;

@Controller
public class TeacherController {
	private ITeacherService teacherService;

	@Autowired
	public TeacherController(ITeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}
	
	@GetMapping("/teachers")
	public String get(Model model){
		model.addAttribute("teachers",teacherService.getAll());
		return "teachers";
	}
	

	  @GetMapping("/teachers/addT") 
	  public String add(Model model) {
		  Teacher teacher = new Teacher();
		  model.addAttribute("teacher",teacher);
		  return "addT";
	  }
	  
	 @PostMapping("/teachers")
	 public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		 teacherService.add(teacher);
		 return "redirect:/teachers";
	 }
	 
	 @GetMapping("/teachers/editT/{id}")
	 public String editTeacher(@PathVariable int id,Model model) {
		 model.addAttribute("teacher",teacherService.getById(id));
		 return "editT";
	 }
	 @PostMapping("/teachers/{id}")
	 public String updateTeacher(@PathVariable int id, @ModelAttribute("teacher")Teacher teacher,Model model) {
		 Teacher existedOne = teacherService.getById(id);
		 existedOne.setFirstName(teacher.getFirstName());
		 existedOne.setLastName(teacher.getLastName());
		 existedOne.setEmail(teacher.getEmail());
		 existedOne.setSchool(teacher.getSchool());
		 
		 teacherService.update(existedOne);
		 return "redirect:/teachers";
	 }
	 
	 @GetMapping("/teachers/{id}")
	 public String delete(@PathVariable int id) {
		 Teacher deleted = teacherService.getById(id);
		 teacherService.delete(deleted);
		 return "redirect:/teachers";
		 
	 }

}