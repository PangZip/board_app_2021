package com.webjjang.board.util;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageingInfo {
   // 보고있는 페이지에서 시작번호 ( 예) 10개씩이라고하면 1 , 11 , 21 , 31 ..... )
   private int startPage;
   // 보고있는 페이지에서 끝번호 ( 예) 10개씩이라고하면 10, 20, 30 ,40 ,50 .....)
   private int endPage;
   // 이번페이지가 있는지 다음페이지가 있는지 확인
   private boolean prev,next;
   
   private int lastPage;
   // 전체 게시글 수
   private int total;
   // 요청이 온 페이지의 페이지번호와 몇개씩 보고 싶은지
   private Criteria cri;
   
   public PageingInfo(Criteria cri, int total) {
      this.cri = cri; // 요청 정보
      this.total = total; // 전체 게시글 수
      
      System.out.println("This is PageingInfo");
      System.out.println("cri.getPageNum() : " + cri.getPageNum());
      System.out.println("cri.getPageNum() / 10.0 : " + cri.getPageNum() / 10.0);
      System.out.println("Math.ceil(cri.getPageNum() / 10.0) : " + Math.ceil(cri.getPageNum() / 10.0));
      System.out.println("(int) (Math.ceil(cri.getPageNum() / 10.0)) : " + (int) (Math.ceil(cri.getPageNum() / 10.0)));
      
      this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0))*10;
      this.startPage = this.endPage - 9;
      
      int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
      
      lastPage = realEnd;
      
      if(realEnd < this.endPage) {
         this.endPage = realEnd;
      }
      
      this.prev = this.startPage > 1;
      this.next = this.endPage < realEnd;
   }
}