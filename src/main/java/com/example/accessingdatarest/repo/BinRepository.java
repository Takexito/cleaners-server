package com.example.accessingdatarest.repo;

import com.example.accessingdatarest.model.TrashBin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bins", path = "bins")
public interface BinRepository extends CrudRepository<TrashBin, Long> {
}
