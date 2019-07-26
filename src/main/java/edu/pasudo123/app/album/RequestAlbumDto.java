package edu.pasudo123.app.album;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@Getter
@EqualsAndHashCode
public class RequestAlbumDto {

    private Long id;

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "content is mandatory")
    private String content;

}
