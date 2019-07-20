package edu.pasudo123.app.album;

import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.photo.AlbumPhoto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@Getter
@Setter
@EqualsAndHashCode
public class RequestAlbumDto {

    private Long id;

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "content is mandatory")
    private String content;

}