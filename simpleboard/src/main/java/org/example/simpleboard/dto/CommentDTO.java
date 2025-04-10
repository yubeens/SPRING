package org.example.simpleboard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter  @Setter
public class CommentDTO {
    private int cnum;
    private String userid;
    private String  content;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date regdate;
    private int bnum; //boards 테이블과 연관(외래키)
}
