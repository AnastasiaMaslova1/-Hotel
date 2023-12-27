package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //репозиторий
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {

}
