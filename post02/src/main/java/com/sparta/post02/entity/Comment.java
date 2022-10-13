package com.sparta.post02.entity;

import com.sparta.post02.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentDto commentDto, User user) {
        this.postId = commentDto.getPostId();
        this.comment = commentDto.getComment();
        this.user = user;
    }

    public void update (CommentDto commentDto) {

        this.comment = commentDto.getComment();
    }
}
