package edu.pasudo123.app.album.photo;

import edu.pasudo123.app.album.Album;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by pasudo123 on 2019-07-07
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Entity
@Table(name = "ALBUM_PHOTO")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class AlbumPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @Builder
    public AlbumPhoto(String photoUrl){
        this.photoUrl = photoUrl;
    }

    public void setAlbum(Album album){
        if(this.album != null){
            this.album.deletePhoto(this);
        }

        this.album = album;
        this.album.addPhoto(this);
    }
}
