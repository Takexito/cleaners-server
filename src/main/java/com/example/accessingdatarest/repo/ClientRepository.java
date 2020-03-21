package com.example.accessingdatarest.repo;
import com.example.accessingdatarest.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends CrudRepository<Client, Long> {

	List<Client> findByLastName(@Param("name") String name);

}
