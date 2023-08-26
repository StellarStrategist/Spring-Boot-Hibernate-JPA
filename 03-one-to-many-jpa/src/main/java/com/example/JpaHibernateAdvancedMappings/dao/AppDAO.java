package com.example.JpaHibernateAdvancedMappings.dao;

import com.example.JpaHibernateAdvancedMappings.entity.Course;
import com.example.JpaHibernateAdvancedMappings.entity.Instructor;
import com.example.JpaHibernateAdvancedMappings.entity.InstructorDetail;
import org.springframework.boot.autoconfigure.cache.CacheProperties;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int theId);
    void update(Instructor instructor);
    void update(Course course);
    public Course findCourseById(int id);
    void deleteCourseById(int id);
}
