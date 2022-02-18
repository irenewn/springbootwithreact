package id.co.nds.springboot.maven.crud.springbootwithreact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CoursesService {
	public static List<Course> courses = new ArrayList<>();
	private static long idCounter  = 0;
	
	static {
		courses.add(new Course(++idCounter,"nds","Learn JNDS Struts"));
		courses.add(new Course(++idCounter,"nds","Learn JNDS Spring"));
		courses.add(new Course(++idCounter,"nds","Learn React.js and Angular.js"));
		courses.add(new Course(++idCounter,"nds","Learn to Escalate to your seniors"));
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	public Course findById(long id) {
		for (Course course: courses) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public Course deleteById(long id) {
		Course course = findById(id);
				
		if (course == null) {
			return null;
		}
		
		if (courses.remove(course)) {
			return course;
		}
		
		return null;
	}
	
	public Course save(Course course) {
		idCounter = courses.size();
		if(course.getId() == -1 || course.getId() == 0) {
			course.setId(++idCounter);
			courses.add(course);
		}else {
			deleteById(course.getId());
			courses.add(course);
		}
		return course;
	}

}
