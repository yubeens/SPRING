package org.example.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class FileBoardDTO {
    //번호, 제목, 저자, 내용, 이미지
    private int num;
    private String title;
    private String writer;
    private String content;
    private MultipartFile upload;
    private String fileimage; // 이미지 파일명
    

}
