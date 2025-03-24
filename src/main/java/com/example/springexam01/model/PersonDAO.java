package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    private SqlSession sqlMapper;

    //추가
    public void dao_insert(Person person) {
        sqlMapper.insert("personInsert", person);

    }
    //전체보기
    public List<Person> dao_list() {
        return sqlMapper.selectList("personList");
    }
    //개수
    public int dao_count() {
        return sqlMapper.selectOne("personCount");
    }
    //상세보기
    public Person dao_view(String id) {
        return sqlMapper.selectOne("personView", id);
    }
    //삭제하기
    public void dao_delete(String id){
        sqlMapper.delete("personDelete",id);
    }
    //수정
    public void dao_update(Person person) {
        sqlMapper.update("personUpdate", person);
    }
}
