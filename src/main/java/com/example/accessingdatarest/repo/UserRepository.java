package com.example.accessingdatarest.repo;
import com.example.accessingdatarest.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(@Param("name") String name);
	Customer findById(@Param("id") long id);

}
