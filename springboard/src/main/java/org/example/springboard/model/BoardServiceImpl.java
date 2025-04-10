package org.example.springboard.model;

import lombok.RequiredArgsConstructor;
import org.example.springboard.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public void insert(BoardDTO board) {
        boardRepository.dao_insert(board);
    }

    @Override
    public List<BoardDTO> boardList() {
        return boardRepository.dao_boardList();
    }

    @Override
    public BoardDTO boardGet(int num) {
        return boardRepository.dao_boardGet(num);
    }

    @Override
    public void update(BoardDTO board) {
            boardRepository.dao_update(board);
    }

    @Override
    public void delete(int num) {
        boardRepository.dao_delete(num);
    }

    @Override
    public int count() {
        return boardRepository.dao_count();
    }
/// /검색
    @Override
    public List<BoardDTO> searchList(HashMap<String, String> map) {
        return boardRepository.dao_searchList(map);
    }

    @Override
    public int searchCount(HashMap<String, String> map) {
        return boardRepository.dao_searchCount(map);
    }
}
