package edu.neu.csye6200.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import edu.neu.csye6200.model.AbstractPerson;

@NoRepositoryBean
public interface AbstractPersonRepository<T extends AbstractPerson> extends CrudRepository<T, Integer> {
}
