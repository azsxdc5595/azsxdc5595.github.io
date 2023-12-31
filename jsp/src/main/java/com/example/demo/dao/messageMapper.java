package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.message;
import com.github.pagehelper.Page;

@Mapper
public interface messageMapper {
    // create
    @Insert("INSERT INTO message(memberno, title, content) VALUES(#{memberno}, #{title}, #{content})")
    void add(message m);

    // read
 // 分页查询所有留言
    @Select("SELECT * FROM message WHERE memberno = #{memberno}")
    Page<message> queryByMemberno(String memberno);
    @Select("SELECT * FROM message")
    Page<message> queryAll();

    @Select("SELECT * FROM message WHERE id = #{id}")
    message getMessageById(@Param("id") Integer id);

    // update
    @Update("UPDATE message SET title = #{title}, content = #{content} WHERE id = #{id}")
    void update(message m);

    // delete
    @Delete("DELETE FROM message WHERE id = #{id}")
    void delete(Integer id);

    
}
