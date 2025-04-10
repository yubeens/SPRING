package org.example.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageDTO {
    private int totPage; //총페이지수
    private int blockPage;
    private int startPage;
    private int endPage;
    private int currentPage;
    private String searchWord;
    private String searchField;

    public PageDTO(int count, int currentPage, int pageSize) { //count = 37
        totPage = count/pageSize + (count%pageSize==0?0:1);  // total = 37/5==>7+1=8
        blockPage = 3;  //[이전] 456[다음]  currentPage = 7
        startPage = ((currentPage-1)/blockPage)*blockPage + 1;  //startPage = 7
        endPage = startPage + blockPage-1;  //endPage = 7+3-1  [이전] 7 8 9

        if(totPage < endPage) endPage = totPage;
        setStartPage(startPage);
        setEndPage(endPage);
        setTotPage(totPage);
        setBlockPage(blockPage);
        setCurrentPage(currentPage);
    }
}
