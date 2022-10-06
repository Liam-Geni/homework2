package com.sparta.test01.dto;


import com.sparta.test01.entity.Member;
import lombok.Getter;

@Getter
public class CommonResponse {

    @Getter
    public class ofList{
        private String name;
        private String email;
        private String pw;

        public ofList(Member member){
            this.name = member.getName();
            this.email = member.getEmail();
            this.pw = member.getPw();
        }
    }
}
