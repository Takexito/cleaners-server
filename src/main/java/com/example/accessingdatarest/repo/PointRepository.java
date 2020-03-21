package com.example.accessingdatarest.repo;

import com.example.accessingdatarest.model.TrashPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "points", path = "points")
public interface PointRepository extends CrudRepository<TrashPoint, Long> {
}
