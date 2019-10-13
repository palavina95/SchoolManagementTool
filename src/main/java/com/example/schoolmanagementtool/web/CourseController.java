package com.example.schoolmanagementtool.web;

import java.util.ArrayList;
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
public class CourseController {
	
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
    private CourseDAO courseDAO;
	@Autowired
	private EnrollmentsDAO enrollmentsDAO;
    
	// Login
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
    @RequestMapping(value="/courselist")
    public String courseList(Model model) {	
        // Fetch all courses
        List<Course> courses = courseDAO.findAll();
        // Add courselist to model and return view name
        model.addAttribute("courses", courses);
        return "courselist";
    }	
    
    // Add new course
    @RequestMapping(value = "/addcourse")
    public String addCourse(Model model){
    	model.addAttribute("course", new Course());
        return "addcourse";
    }  
    
    // Save new course
    @RequestMapping(value = "/savecourse", method = RequestMethod.POST)
    public String save(Course course){
        courseDAO.save(course);
        return "redirect:courselist";
    }  
    
    // Update a course
    @RequestMapping(value = "/updatecourse", method = RequestMethod.POST)
    public String update(Course course){
        courseDAO.update(course);
        return "redirect:courselist";
    }
    
    //Delete course
  	@RequestMapping(value = "/deletecourse/{id}", method = RequestMethod.GET)
	  public String deleteBook(@PathVariable("id") long courseId) {
	  	courseDAO.delete(courseId);
	      return "redirect:../courselist";
	  } 
  	
  	//Edit a course
  	@RequestMapping(value = "/editcourse/{id}", method = RequestMethod.GET)
      public String editBook(@PathVariable("id") long courseId, Model model) {
  		model.addAttribute("course", courseDAO.findOne(courseId));
          return "editcourse";
      }
  	
  	//Manage a course
	@RequestMapping(value = "/managecourse/{id}", method = RequestMethod.GET)
      public String manageCourse(@PathVariable("id") long courseId, Model model) {
  		model.addAttribute("course", courseDAO.findOne(courseId));
  		List<Student> students = new ArrayList<Student>();
  		List<Enrollments> currentEnroll = enrollmentsDAO.findAllfromCourse(courseId);
  		//System.out.println(currentEnroll);
  		for(int i=0;i<currentEnroll.size();i++) {
  			students.add(studentDAO.findOne(currentEnroll.get(i).getStudent_id()));
  			students.get(i).setGrade(currentEnroll.get(i).getGrade());
  		}
  		model.addAttribute("students", students);
 
        return "managecourse";
    }
	
	//Confirm grading for a course
  	@RequestMapping(value = "/confirmgrading", method = RequestMethod.POST)
    public String enrollStudent(@RequestParam("courseId") long courseId,@Param("grades") int[] grades) {
  		
  		//Pre-save for studentId's
  		List<Enrollments> currentEnroll = enrollmentsDAO.findAllfromCourse(courseId);
  		
  		if(grades != null) {
  			
	  		for(int i=0; i<grades.length; i++) {
	  			//Delete previous stored
	  			enrollmentsDAO.deleteFromDetails(courseId, currentEnroll.get(i).getStudent_id());
	  			//We save the result in the database
	  			Enrollments myEnrollment = new Enrollments(currentEnroll.get(i).getStudent_id(),courseId,grades[i]);
	  			enrollmentsDAO.save(myEnrollment);
	  			
	  		}
  		}
  		
  		return "redirect:courselist";
  	}
  	
  	//Restful service to get all courses
  	@RequestMapping(value="/courses",method=RequestMethod.GET)
  	public @ResponseBody List<Course>courseListRest(){ 
  		return (List<Course>)courseDAO.findAll();
  	}
  	
  	//Restful service to get all grades from one student
  	@RequestMapping(value="/grades",method=RequestMethod.GET)
  	public @ResponseBody List<Enrollments>gradesFromStudentListRest(@RequestParam(value="studentId",defaultValue="1")Long studentId){ 
  		return (List<Enrollments>)enrollmentsDAO.findAllfromStudent(studentId);
  	}
}
