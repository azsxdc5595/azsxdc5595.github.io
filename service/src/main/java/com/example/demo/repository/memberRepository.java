package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.member;




public interface memberRepository extends JpaRepository<member, Integer>{
	@Query(value="select * from member where username=?1 and password=?2",nativeQuery = true) 
	member findmember(String username,String password);
	member findByUsername(String username);	
		

}
