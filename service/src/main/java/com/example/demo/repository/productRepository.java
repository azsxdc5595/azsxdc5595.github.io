package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.product;

public interface productRepository extends JpaRepository<product, Integer>{

}
