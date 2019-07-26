package edu.pasudo123.app.album;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.photo.AlbumPhoto;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by pasudo123 on 2019-07-16
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 *
 * 특정 앨범 조회 Dto Class
 * 해당 Dto 가 있으므로, album id 외래키를 이용하여 댓글과 사진을 들고온다.
 **/
@Getter
@ToString(exclude = {"albumCommentList", "albumPhotoList"})
public class ResponseAlbumPostDto {

    private Long id;
    private String title;
    private String content;
    private List<AlbumPhoto> albumPhotoList;
    private List<AlbumComment> albumCommentList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;
}
