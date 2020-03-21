package com.example.accessingdatarest.repo;

import com.example.accessingdatarest.model.Client;
import com.example.accessingdatarest.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface OrderRepository extends CrudRepository<Order, Long> {
}
