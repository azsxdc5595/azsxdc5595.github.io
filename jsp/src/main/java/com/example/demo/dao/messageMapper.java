package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.message;

@Mapper
public interface messageMapper {
	//create
	@Insert("Insert into message(memberno,title,content)" + "values(#{memberno},#{title},#{content})")
	void add(message m);
	
	//read
	@Select("select * from message")
	List<message> queryAll();
	
	@Select("select * from message where memberno=#{memberno}")
	List<message> queryByMemberno(String memberno);
	
	@Select("select * from message where id=#{id}")
	message getMessageById(@Param("id") Integer id);
	
	//update
	@Update("update message set title=#{title},content=#{content} where id=#{id}")
	void update(message m);
	
	
	//delete
	@Delete("delete from message where id=#{id}")
	void delete(Integer id);
	
	
}
