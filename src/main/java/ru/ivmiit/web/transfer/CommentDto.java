package ru.ivmiit.web.transfer;

import lombok.*;
import ru.ivmiit.web.model.Comment;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CommentDto {
    private String text;
    private String userName;
    private Long userId;
    private Date createdDate;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .text(comment.getText())
                .userName(comment.getUser().getName())
                .userId(comment.getUser().getId())
                .createdDate(comment.getCreatedDate())
                .build();
    }
}
