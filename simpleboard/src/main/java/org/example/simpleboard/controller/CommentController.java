package org.example.simpleboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.CommentDTO;
import org.example.simpleboard.model.BoardService;
import org.example.simpleboard.model.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RequestMapping("/reply/*")
@RequiredArgsConstructor
//@Controller
@RestController  //@Controller + @ResponseBody
@Log4j2
public class CommentController {
    private final CommentService commentService;
    private final BoardService boardService;
    //전체보기
    @GetMapping("commentList/{num}")
   // @ResponseBody
    public ResponseEntity<HashMap<String, Object>> getCommentList(@PathVariable("num") int num) {
      log.info("getCommentList " + num);
      List<CommentDTO> clist = commentService.selectAll(num);
      int count = boardService.update(num).getReplyCnt();
      HashMap<String, Object> hm = new HashMap<>();
      hm.put("clist", clist);
      hm.put("count", count);
      log.info("hm " + hm);
      return  new ResponseEntity<>(hm, HttpStatus.OK);
    }



    //추가
//    @PostMapping("commentInsert")
//    @ResponseBody
//    public String insertComment(@RequestBody CommentDTO comment) {
//        comment.setUserid("aaa");
//        commentService.insert(comment);
//        return "success";
//    }
    @PostMapping("commentInsert")
  //  @ResponseBody
    public ResponseEntity<String> insertComment(@RequestBody CommentDTO comment) {
        comment.setUserid("aaa");
        commentService.insert(comment);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    //댓글삭제
    @DeleteMapping("delete/{cnum}")
    public String deleteComment(@PathVariable("cnum") Integer cnum) {
        log.info("deleteComment cnum " + cnum);
        commentService.delete(cnum);
        return  cnum.toString();
    }


//    @DeleteMapping("delete/{cnum}/{bnum}")
//    public String deleteComment(@PathVariable("cnum") Integer cnum,
//                                @PathVariable("bnum") Integer bnum) {
//
//        return  "success";
//    }
}
