package org.example.simpleboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.simpleboard.dto.FileBoardDTO;
import org.example.simpleboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@Log4j2
public class FileController {
    private final BoardService boardService;
    //파일추가폼
    @GetMapping("fileInsert")
    public String fileInsert(Model model) {
        return "fileBoardInsert";
    }
    //파일추가
    @PostMapping("fileInsert")
    public String fileInsert(FileBoardDTO fileBoardDTO,
                             HttpServletRequest request) {
        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        log.info("uploadPath1 : " + uploadPath);
        uploadPath += "resources\\images\\";
        if (!new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        log.info("uploadPath : " + uploadPath);
        MultipartFile multipartFile = fileBoardDTO.getUpload();
        //파일 이름 중복 피하기 위해 이름 수정
        UUID uuid = UUID.randomUUID();
        String fileName =uuid.toString()+"_"+multipartFile.getOriginalFilename();
        File saveFile = new File(uploadPath,fileName);
        try {
            multipartFile.transferTo(saveFile);
            fileBoardDTO.setFileimage(fileName);
        } catch (IOException e) {
            e.printStackTrace();;
        }
        boardService.fileInsert(fileBoardDTO);
        return "redirect:/fileList";
    }
    @GetMapping("fileList")
    public String fileList(Model model) {
        //boardService.fileList();
        model.addAttribute("farr", boardService.fileList());
        return "fileList";
    }

    ////
    @GetMapping("uploadFile")
    public void uploadFile() {}

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("uploads") MultipartFile[] uploads,
                             Model model) {
        String uploadFolder = "D:\\jung\\LEC\\SpringWorkspace\\uploads";
        ArrayList<String > arr = new ArrayList<>();
        for (MultipartFile multipartFile : uploads) {
            //파일 이름 중복 피하기 위해 이름 수정
            UUID uuid = UUID.randomUUID();
            String uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
            File saveFile = new File(uploadFolder, uploadFileName);
            try {
                multipartFile.transferTo(saveFile);
                arr.add(multipartFile.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("fileArr", arr);
        return "fileResult";
    }
}
