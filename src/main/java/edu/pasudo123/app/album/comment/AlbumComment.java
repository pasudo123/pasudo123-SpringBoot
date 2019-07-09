package edu.pasudo123.app.album.comment;

import edu.pasudo123.app.album.Album;
import edu.pasudo123.app.common.TimeEntity;
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
@Table(name = "ALBUM_COMMENT")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class AlbumComment extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMENT")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @Builder
    public AlbumComment(String comment){
        this.comment = comment;
    }

    public void setAlbum(Album album){
        if(this.album != null){
            this.album.deleteComment(this);
        }

        this.album = album;
        this.album.addComment(this);
    }
}
