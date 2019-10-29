package com.example.schoolmanagementtool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.schoolmanagementtool.domain.Course;
import com.example.schoolmanagementtool.domain.CourseDAO;
import com.example.schoolmanagementtool.domain.Enrollments;
import com.example.schoolmanagementtool.domain.EnrollmentsDAO;
import com.example.schoolmanagementtool.domain.Student;
import com.example.schoolmanagementtool.domain.StudentDAO;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private EnrollmentsDAO enrollmentsDAO;
    
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
	  public String deleteStudent(@PathVariable("id") long studentId) {
	  	studentDAO.delete(studentId);
	      return "redirect:../studentlist";
  	} 
  	
  	//Edit a student
  	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
      public String editStudent(@PathVariable("id") long studentId, Model model) {
  		model.addAttribute("student", studentDAO.findOne(studentId));
          return "editstudent";
    }
  	
  	//Manage a student
  	@RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
      public String manageStudent(@PathVariable("id") long studentId, Model model) {
  		model.addAttribute("student", studentDAO.findOne(studentId));
  		List<Course> current = courseDAO.findAll();
  		List<Enrollments> currentEnroll = enrollmentsDAO.findAllfromStudent(studentId);
  		for(int i=0;i<current.size();i++) {
  			for(int j=0;j<currentEnroll.size();j++) {
  				if(currentEnroll.get(j).getCourse_id() == current.get(i).getId()) {
  					current.get(i).setEnrolled(true);
  		  			current.get(i).setGrade(currentEnroll.get(j).getGrade());
  					break;
  				}
  			}
  		};
  		model.addAttribute("courses", current);
 
        return "managestudent";
    }
  	
  	//Enroll courses for a specific students
  	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public String enrollStudent(@RequestParam("studentId") long studentId,@Param("courseEnrolled") int[] courseEnrolled) {
  		
  		//Delete where no grades
  		enrollmentsDAO.deleteNoGrades(studentId);
  		
  		if(courseEnrolled != null) {
	  		//System.out.println("Bonjour student: "+studendId);
	  		for(int i=0; i< courseEnrolled.length; i++) {
	  			//Delete previous stored
	  			enrollmentsDAO.deleteFromDetails(courseEnrolled[i], studentId);
	  			//System.out.println("student: "+studendId+" enroll for course :" +courseEnrolled[i]);
	  			Enrollments myEnrollment = new Enrollments(studentId,courseEnrolled[i],0);
	  			//System.out.println(myEnrollment.toString());
	  			enrollmentsDAO.save(myEnrollment);
	  			
	  		}
  		}
  		
  		return "redirect:studentlist";
  	}
  	
  	//Restful service to get all students
  	@RequestMapping(value="/students",method=RequestMethod.GET)
  	public @ResponseBody List<Student>studentListRest(){ 
  		return (List<Student>)studentDAO.findAll();
  	}
  	
  	//Restful service to get all courses from one student
  	@RequestMapping(value="/mycourses/{id}",method=RequestMethod.GET)
  	public @ResponseBody List<Course>courseListRest(@PathVariable("id") long studentId){ 
  
  		List<Course> current = courseDAO.findAll();
  		List<Enrollments> currentEnroll = enrollmentsDAO.findAllfromStudent(studentId);
  		for(int i=0;i<current.size();i++) {
  			for(int j=0;j<currentEnroll.size();j++) {
  				if(currentEnroll.get(j).getCourse_id() == current.get(i).getId()) {
  					current.get(i).setEnrolled(true);
  		  			current.get(i).setGrade(currentEnroll.get(j).getGrade());
  					break;
  				}
  			}
  		};
  		
  		return current;
  	}
}
 


