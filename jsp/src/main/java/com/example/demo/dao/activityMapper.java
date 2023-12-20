package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.activity;
import com.example.demo.vo.porder;

@Mapper
public interface activityMapper {
	//create
	@Insert("insert into activity(name,content,eventtime) values(#{name},#{content},#{eventtime})")
	void add(activity a);
	
	
	//read
	@Select("Select * from activity")
	List<activity> queryAll();
	
	@Select("Select * from activity where id=#{id}")
	activity queryId(@Param("id")int id);
		
	//update
	@Update("update activity set name=#{name},content=#{content},eventtime=#{eventtime} where id=#{id}")
	void update(activity a);
	
	
	//delete
	@Delete("delete from activity where id=#{id}")
	void delete(int id);
}
