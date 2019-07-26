package edu.pasudo123.app.album.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.pasudo123.app.album.Album;
import edu.pasudo123.app.common.TimeEntity;
import lombok.*;

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
@ToString(exclude = {"album"})
public class AlbumComment extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMMENT")
    private String comment;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALBUM_ID", nullable = false)
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
        album.addComment(this);
    }
}
