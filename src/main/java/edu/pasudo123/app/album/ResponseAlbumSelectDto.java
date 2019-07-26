package edu.pasudo123.app.album;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.pasudo123.app.common.TimeEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
public class ResponseAlbumSelectDto{

    private Long id;
    private String title;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updateDate;

}
