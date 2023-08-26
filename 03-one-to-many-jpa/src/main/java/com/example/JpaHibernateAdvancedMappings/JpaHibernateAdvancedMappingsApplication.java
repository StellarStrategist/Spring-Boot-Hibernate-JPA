package com.example.JpaHibernateAdvancedMappings;

import com.example.JpaHibernateAdvancedMappings.dao.AppDAO;
import com.example.JpaHibernateAdvancedMappings.entity.Course;
import com.example.JpaHibernateAdvancedMappings.entity.Instructor;
import com.example.JpaHibernateAdvancedMappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateAdvancedMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateAdvancedMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			deleteCourseById(appDAO);
		};
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id=10;
		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id=10;
		Course tempCourse=appDAO.findCourseById(id);
		tempCourse.setTitle("Math");
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findInstructorById(id);
		instructor.setLastName("Gupta");
		appDAO.update(instructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=1;
		Instructor instructor=appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		Instructor tempInstructor=appDAO.findInstructorById(1);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("Courses: ");
		tempInstructor.setCourses(appDAO.findCoursesByInstructorId(1));
		System.out.println(tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=appDAO.findInstructorById(1);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail instructorDetail=new InstructorDetail("youtube.channel.luv2code","guitar");
		tempInstructor.setInstructorDetail(instructorDetail);
		Course course1=new Course("course1");
		Course course2=new Course("course2");
		tempInstructor.add(course1);
		tempInstructor.add(course2);
		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorById(2);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail= appDAO.findInstructorDetailById(2);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor()); ;
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id=2;
		System.out.println("Finding instructor by id "+id);
		Instructor instructor=appDAO.findInstructorById(id);
		System.out.println("Instructor: "+instructor);
		System.out.println("Instructor Details: "+instructor.getInstructorDetail());
	}

	public void createInstructor(AppDAO appDAO) {
		/*Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");
		InstructorDetail instructorDetail=new InstructorDetail("youtube.channel.luv2code","luv 2 code");
		//associate the objects using one to one mapping
		tempInstructor.setInstructorDetail(instructorDetail);
		//save the instructor
		//NOTE: this will ALSO save the details object
		//because of CascadeType.ALL
		//
		appDAO.save(tempInstructor);
		*/
		Instructor tempInstructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail instructorDetail=new InstructorDetail("youtube.channel.luv2code","guitar");
		//associate the objects using one to one mapping
		tempInstructor.setInstructorDetail(instructorDetail);
		//save the instructor
		//NOTE: this will ALSO save the details object
		//because of CascadeType.ALL
		//
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
