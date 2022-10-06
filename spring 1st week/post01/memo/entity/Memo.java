package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Memo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(){
        // 파라미터가 있는 생성자를 하나라도 정의하게 되면
        // 더이상 기본생성자를 생성하지 않기때문에 기본생성자를 꼭 만들어줘야한다.
    }
    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
    //getter를 만들지 않으면 클라이언트에게 데이터를 전달할수 없다.
    public Long getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getContents(){
        return this.contents;
    }
    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}
