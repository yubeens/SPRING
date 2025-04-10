package org.example.simpleboard.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.MemberDTO;
import org.example.simpleboard.model.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member/*")
@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("join")
    public String join() {
        return "member/join";
    }
    @PostMapping("join")
    @ResponseBody
    public String joinPost(@RequestBody MemberDTO memberDTO) {
       int flag =  memberService.idCheck(memberDTO.getId());
       if(flag != 0) return  "fail";
       memberService.join(memberDTO);
       return "success";
    }
    //로그인폼
    @GetMapping("login")
    public String login() {
        return "member/login";
    }
    @PostMapping("login")
    @ResponseBody
    public String loginPost(@RequestBody MemberDTO memberDTO,
                             HttpSession session) {
       // 성공(success) / 비번오류("fail") / 회원아님("no")
       MemberDTO member = memberService.loginCheck(memberDTO.getId());
       if(member == null) return "no";
       if(member.getPassword().equals(memberDTO.getPassword())){
           session.setAttribute("sMember", member);
           return "success";
       }
       else return "fail";  //비번오류
    }
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "member/login";
    }
    @GetMapping("update")
    public void update() {   //void 는 update.jsp

    }
    @PutMapping("update")
    @ResponseBody
    public String updatePost(@RequestBody MemberDTO memberDTO,
                             HttpSession session) {
        memberService.update(memberDTO);
        session.invalidate();
        return "success";
    }

}
