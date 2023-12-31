package com.example.JpaHibernateAdvancedMappings.dao;

import com.example.JpaHibernateAdvancedMappings.entity.Instructor;
import com.example.JpaHibernateAdvancedMappings.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
