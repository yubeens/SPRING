package org.example.simpleboard.model;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.CommentDTO;
import org.example.simpleboard.mapper.BoardMapper;
import org.example.simpleboard.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl
        implements CommentService {
    private final CommentMapper commentMapper;
    private final BoardMapper boardMapper;
    @Override
    @Transactional
    public void insert(CommentDTO comment) {
        //replyCnt 1 증가
        boardMapper.replyCnt(comment.getBnum(),1);
        commentMapper.insert(comment);
    }

    @Override
    public List<CommentDTO> selectAll(int bnum) {
        return commentMapper.selectAll(bnum);
    }
   
    
    //삭제
    @Override
    @Transactional
    public void delete(int cnum) {
        //댓글 개수 -1
        CommentDTO commentDTO = commentMapper.read(cnum);
        boardMapper.replyCnt(commentDTO.getBnum(), -1);
        commentMapper.delete(cnum);

    }

    @Override
    public int count(int b) {
        return 0;
    }
}
