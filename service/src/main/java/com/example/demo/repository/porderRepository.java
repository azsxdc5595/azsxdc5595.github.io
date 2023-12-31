package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.porder;

public interface porderRepository extends JpaRepository<porder,Integer>{
	List<porder> findByName(String name);
}
