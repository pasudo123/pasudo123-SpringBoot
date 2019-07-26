package edu.pasudo123.app.album.comment;

import edu.pasudo123.app.album.Album;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@Getter
@Setter
public class RequestAlbumCommentDto {

    private Long id;

    @NotBlank(message = "comment is mandatory")
    private String comment;

}
