package edu.pasudo123.app.album.photo;

import edu.pasudo123.app.album.Album;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author pasudo123
 * @since 2019-07-11
 * blog: https://pasudo123.tistory.com/
 * email: oraedoa@gmail.com
 */
@Getter
@Setter
@ToString(exclude = {"album"})
public class RequestAlbumPhotoDto {

    private Long id;
    private String photoUrl;
    private Album album;

}
