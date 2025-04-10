package org.example.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.BoardDTO;
import org.example.simpleboard.dto.PageDTO;
import org.example.simpleboard.model.BoardService;
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
    @GetMapping("insert")
    public String insert() {
        return "board/boardWrite";
    }
    @PostMapping("insert")
    public String insert(BoardDTO board) {
        boardService.insert(board);
        return  "board/boardWrite";
    }
    @GetMapping("list")
    public String list(Model model,
           @RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
           @RequestParam(value = "searchField" , defaultValue ="") String searchField,
           @RequestParam(value = "searchWord", defaultValue = "") String searchWord ) {

       ////
        int currentPage = Integer.parseInt(pageNum);
        int pageSize = 5;

        HashMap<String,Object> map = new HashMap<>();
        map.put("searchField", searchField);
        map.put("searchWord", searchWord);
        map.put("pageStart", (currentPage-1)*pageSize);  //1페이지 ->1, 2페이지->6, 3페이지 ->11
        map.put("pageSize", pageSize);
        log.info("map: " + map);

        int total = boardService.getCount(map);
        List<BoardDTO> lists =  boardService.findAll(map);
        PageDTO pageDTO = new PageDTO(total, currentPage, pageSize);
        pageDTO.setSearchWord(searchWord);
        pageDTO.setSearchField(searchField);
        model.addAttribute("barr",lists);
        model.addAttribute("count",total);
        model.addAttribute("p",pageDTO);
        return "board/boardList";
    }
    @GetMapping("view")
    public String view(@RequestParam("num") int num,
                       Model model) {
      BoardDTO board =  boardService.findByNum(num);
      model.addAttribute("board",board);
      return "board/boardView";
    }
    //삭제
    @DeleteMapping("delete/{num}")
    @ResponseBody
    public int delete(@PathVariable("num") int num) {
        boardService.delete(num);
        return num;
    }
    //수정폼
    @GetMapping("update/{num}")
    public String update(@PathVariable("num") int num,
                         Model model) {
        BoardDTO board =  boardService.update(num);
        model.addAttribute("board",board);
        return "board/boardUpdate";
    }
    //수정
    @PutMapping("update")
    @ResponseBody
    public int update(@RequestBody BoardDTO board) {
        boardService.update(board);
        return board.getNum();
    }



}
