package com.example.accessingdatarest.repo;

import com.example.accessingdatarest.model.Cleaner;
import com.example.accessingdatarest.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cleaner", path = "cleaner")
public interface CleanerRepository extends CrudRepository<Cleaner, Long> {
}
