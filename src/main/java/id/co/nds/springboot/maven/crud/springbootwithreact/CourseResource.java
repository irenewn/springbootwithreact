package id.co.nds.springboot.maven.crud.springbootwithreact;

import java.net.URI;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "")
@CrossOrigin(origins = {"http://localhost:3000/", "http://localhost:4200/"})
public class CourseResource {
	
	@Autowired //spring annotations --> allow controller to get details from CoursesServices
	private CourseRepository courseRepository;

	@Autowired
	Gson gson;	
	
	//getting all from localhost:8080/instructors/nds/courses 
	@RequestMapping(value="/instructors/{username}/courses",method = RequestMethod.GET)
	public ResponseEntity<List<NewCourse>> getAllCourses(){
		List<NewCourse> courses = courseRepository.findAll();
		courses.forEach(System.out :: println);
		
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@RequestMapping(value="/instructors/{username}/courses/{id}", method = RequestMethod.GET) //return a list of courses
	//getting all from localhost:8080/instructors/nds/courses
	public Optional<NewCourse> getCourse(@PathVariable String username, @PathVariable long id){
		return courseRepository.findById(id);
	}

	@RequestMapping(value="/instructors/{username}/courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String username, @PathVariable long id){
		courseRepository.deleteById(id);
				
	}
	
	@RequestMapping(value="/instructors/{username}/courses/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NewCourse> updateCourse(@PathVariable String username, @PathVariable long id, @RequestBody NewCourse course){		
		NewCourse courseUpdated = courseRepository.save(course); 
		
		return new ResponseEntity<NewCourse>(courseUpdated, HttpStatus.OK);
	}
	
	@RequestMapping(value="/instructors/{username}/courses", method = RequestMethod.POST)
	public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody NewCourse course){
		NewCourse createdCourse = courseRepository.save(course); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
