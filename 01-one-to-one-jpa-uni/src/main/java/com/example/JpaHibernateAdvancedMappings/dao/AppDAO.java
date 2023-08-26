package com.example.JpaHibernateAdvancedMappings.dao;

import com.example.JpaHibernateAdvancedMappings.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
