package org.example.springboard.mapper;

import org.apache.ibatis.annotations.*;
import org.example.springboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    //추가
    @Insert("insert into board(userid, subject, content) " +
            " values(#{userid},#{subject},#{content})")
    void insertBoard(BoardDTO board);
    //전체보기
    @Select("select * from board")
    List<BoardDTO> boardList();
    //상세보기
    @Select("select * from board where num=#{num}")
    BoardDTO getBoard(int num);
    //수정
    @Update("update board set content =#{content}, subject=#{subject} where num=#{num}")
    void updateBoard(BoardDTO board);
    //삭제
    @Delete("delete from board where num=#{num}")
    void deleteBoard(int num);
    //개수
    @Select("select count(*) from board")
    int countBoard();
    /////검색
    List<BoardDTO> searchList(HashMap<String, String> map);
    int searchCount(HashMap<String, String> map);
}
