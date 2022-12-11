package edu.neu.csye6200.repository;

import org.springframework.stereotype.Repository;

import edu.neu.csye6200.model.Teacher;

@Repository
public interface TeacherRepository extends AbstractPersonRepository<Teacher> {
}
