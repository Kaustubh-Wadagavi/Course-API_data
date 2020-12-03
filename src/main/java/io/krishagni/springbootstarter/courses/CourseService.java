package io.krishagni.springbootstarter.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses() {
		//return topics;
		List<Course> topics = new ArrayList<>();
		courseRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().contentEquals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(String id, Course course) {
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		courseRepository.deleteById(id);
	}
	
	
}
