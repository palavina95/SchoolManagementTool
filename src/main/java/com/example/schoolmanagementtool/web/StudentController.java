package com.example.schoolmanagementtool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.schoolmanagementtool.domain.Student;
import com.example.schoolmanagementtool.domain.StudentDAO;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping(value="/studentlist")
    public String studentList(Model model) {	
        // Fetch all students
        List<Student> students = studentDAO.findAll();
        // Add studentlist to model and return view name
        model.addAttribute("students", students);
        return "studentlist";
    }	
    
    // Add new student
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("student", new Student());
        return "addstudent";
    }  
    
    // Save new student
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Student student){
        studentDAO.save(student);
        return "redirect:studentlist";
    }  
    
    // Update a student
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Student student){
        studentDAO.update(student);
        return "redirect:studentlist";
    }
    
    //Delete student
  	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	  public String deleteBook(@PathVariable("id") long studentId) {
	  	studentDAO.delete(studentId);
	      return "redirect:../studentlist";
	  } 
  	
  	//Edit a student
  	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
      public String editBook(@PathVariable("id") long studentId, Model model) {
  		model.addAttribute("student", studentDAO.findOne(studentId));
          return "editstudent";
      }
	
}

