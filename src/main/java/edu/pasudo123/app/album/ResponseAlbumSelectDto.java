package edu.pasudo123.app.album;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.photo.AlbumPhoto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 *
 * 앨범목록 Dto Class
 * - 앨범의 목록만을 필요로 하기 때문에
 * - 다른 필드는 딱히 필요없음
 */
@Getter
@Setter
public class ResponseAlbumSelectDto {

    private Long id;
    private String title;
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
