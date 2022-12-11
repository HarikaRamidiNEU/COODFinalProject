package edu.neu.csye6200.repository;

import org.springframework.stereotype.Repository;

import edu.neu.csye6200.model.Student;

@Repository
public interface StudentRepository extends AbstractPersonRepository<Student> {
}
