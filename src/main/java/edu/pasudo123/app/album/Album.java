package edu.pasudo123.app.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.photo.AlbumPhoto;
import edu.pasudo123.app.common.TimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pasudo123 on 2019-07-07
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Entity
@Table(name = "ALBUM")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@ToString(exclude = {"albumPhotoList", "albumCommentList"})
public class Album extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<AlbumPhoto> albumPhotoList = new ArrayList<>();

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<AlbumComment> albumCommentList = new ArrayList<>();

    /**
     * TODO (1) : 작성자 등록
     * TODO (2) : 좋아요 등록
     */
    @Builder
    public Album(String content){
        this.content = content;
    }

    public void addPhoto(AlbumPhoto photo){
        if(albumPhotoList == null){
            albumPhotoList = new ArrayList<>();
        }

        albumPhotoList.add(photo);
    }

    public void deletePhoto(AlbumPhoto photo){
        if(albumPhotoList == null){
            return;
        }

        if(albumPhotoList.size() == 0){
            return;
        }

        albumPhotoList.remove(photo);
    }

    public void addComment(AlbumComment comment){
        if(albumCommentList == null){
            albumCommentList = new ArrayList<>();
        }

        albumCommentList.add(comment);
    }

    public void deleteComment(AlbumComment comment){
        if(albumCommentList == null){
            return;
        }

        if(albumCommentList.size() == 0){
            return;
        }

        albumCommentList.remove(comment);
    }
}
