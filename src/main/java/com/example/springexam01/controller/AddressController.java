package com.example.springexam01.controller;

import com.example.springexam01.dto.AddressDTO;
import com.example.springexam01.model.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/address")
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("insert")
    public String insert() {
        return "address/insert";
    }
    //추가
    @PostMapping("insert")
    public String insert(AddressDTO addressDTO) {
        addressService.insertAddress(addressDTO);
        return "redirect:alist";
    }
    //전체보기
    @GetMapping("alist")
    public String list(Model model) {
        List<AddressDTO> alist = addressService.getAddress();
        int count = addressService.countAddress();
        System.out.println(alist);
        System.out.println(count);
        model.addAttribute("count", count);
        model.addAttribute("alist", alist);
        return "address/list";
    }
    //상세보기
    @GetMapping("view")
    public String view(@RequestParam("num") int num,
                       Model model) {
        AddressDTO address = addressService.viewAddress(num);
        model.addAttribute("address", address);

        return "address/view";
    }
}
