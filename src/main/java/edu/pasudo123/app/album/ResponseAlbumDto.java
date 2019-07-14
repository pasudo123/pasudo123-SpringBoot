package edu.pasudo123.app.album;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.photo.AlbumPhoto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@Getter
@Setter
@ToString(exclude = {"albumCommentList", "albumPhotoList"})
public class ResponseAlbumDto {

    private Long id;
    private String title;
    private String content;
    private List<AlbumComment> albumCommentList;
    private List<AlbumPhoto> albumPhotoList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updateDate;

}
