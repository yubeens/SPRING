package com.example.springexam01.model;

import com.example.springexam01.dto.AddressDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements  AddressService{
    @Autowired
    private SqlSession sqlMapper;
    @Override
    public void insertAddress(AddressDTO addressDTO) {
        sqlMapper.insert("insertData",addressDTO );
    }

    @Override
    public List<AddressDTO> getAddress() {
        return sqlMapper.selectList("listData");
    }

    @Override
    public AddressDTO viewAddress(int num) {
        return sqlMapper.selectOne("viewData",num);
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {

    }

    @Override
    public void deleteAddress(int num) {

    }

    @Override
    public int countAddress() {
        return sqlMapper.selectOne("countData");
    }
}
