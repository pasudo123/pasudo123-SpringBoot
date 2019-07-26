package edu.pasudo123.app.album.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by pasudo123 on 2019-07-18
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Getter
@Setter
public class ResponseAlbumCommentDto {

    private Long id;
    private String comment;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
