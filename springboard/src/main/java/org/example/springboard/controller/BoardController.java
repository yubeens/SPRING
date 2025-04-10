package org.example.springboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.springboard.dto.BoardDTO;
import org.example.springboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    //추가폼
    @GetMapping("boardInsert")
    public String boardInsert() {
        log.info("boardInsert called");
        return "board/boardWrite";
    }
    //추가
    @PostMapping("boardInsert")
    public  String boardPostInsert(@ModelAttribute BoardDTO boardDTO) {
        log.info(boardDTO);
        boardService.insert(boardDTO);
        return "redirect:boardList";
    }
    //전체보기
    @GetMapping("boardList")
    public String boardList(Model model,
          @RequestParam(value = "searchField",defaultValue = "subject") String searchField,
          @RequestParam(value = "searchWord",defaultValue = "") String searchWord)  {
       //List<BoardDTO> blist =  boardService.boardList();
      // int count = boardService.count();
        HashMap<String, String> map = new HashMap<>();
        map.put("searchField",searchField);
        map.put("searchWord",searchWord);
        List<BoardDTO> blist = boardService.searchList(map);
        int count = boardService.searchCount(map);
       model.addAttribute("barr", blist);
       model.addAttribute("count", count);
       return "board/boardList";
    }
    //상세보기
    @GetMapping("boardView")
    public String boardView(@RequestParam("num") int num, Model model) {
       BoardDTO board= boardService.boardGet(num);
       model.addAttribute("board", board);
       return "board/boardView";
    }
    //삭제
    @GetMapping("boardDelete")
    public String boardDelete(@RequestParam("num") int num) {
        log.info("boardDelete num : " +num);
        boardService.delete(num);
        return "redirect:boardList";
    }
    //수정폼
    @GetMapping("boardUpdate")
    public String boardUpdate(@RequestParam("num") int num, Model model) {
        log.info("boardUpdate num : " +num);
        BoardDTO board= boardService.boardGet(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }
    //수정
     @PostMapping("boardUpdate")
    public  String boardPostUpdate(@ModelAttribute BoardDTO boardDTO) {
       boardService.update(boardDTO);

        return "redirect:boardList";
     }
}

