package com.example.springexam01.controller;

import com.example.springexam01.model.PersonService;
import com.example.springexam01.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private PersonService personService;

    //추가 폼
    @GetMapping("pinsert")
    public String insert() {
        return "insert";
    }
    //추가
    @PostMapping("pinsert")
    public String insertPost(@ModelAttribute Person person) {
        personService.insert(person);
        return "redirect:plist";
    }
    //전체보기
    @GetMapping("plist")
    public String list(Model model) {
        List<Person> personList = personService.findAll();
        int count = personService.getCount();
        model.addAttribute("count", count);
        model.addAttribute("personList", personList);
        return "list";
    }
    //상세보기
    @GetMapping("pview")
    public String view(@RequestParam("id") String id, Model model) {
        Person person = personService.view(id);
        model.addAttribute("person", person);
        return "view";
    }
    //삭제하기
    @GetMapping("delete")
    public String delete(@RequestParam("id") String id) {
        personService.delete(id);
        return "redirect:plist";
    }
    //수정 폼
    @GetMapping("update")
    public String update(@RequestParam("id") String id, Model model) {
        Person person = personService.updateForm(id);
        model.addAttribute("person", person);
        return "update";
    }
    //수정
    @PostMapping("updatd")
    public String updatePost(@ModelAttribute Person person) {
        personService.update(person);
        return "redirect:plist";
    }

}
