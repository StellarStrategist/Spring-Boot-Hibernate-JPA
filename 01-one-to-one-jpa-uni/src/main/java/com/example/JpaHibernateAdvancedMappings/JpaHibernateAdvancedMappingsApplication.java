package com.example.JpaHibernateAdvancedMappings;

import com.example.JpaHibernateAdvancedMappings.dao.AppDAO;
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
			deleteInstructor(appDAO);
		};
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
