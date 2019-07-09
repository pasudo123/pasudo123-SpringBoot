package edu.pasudo123.app.album;

import edu.pasudo123.app.album.comment.AlbumComment;
import edu.pasudo123.app.album.comment.AlbumCommentRepository;
import edu.pasudo123.app.album.photo.AlbumPhotoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by pasudo123 on 2019-07-07
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
@Slf4j
public class AlbumJpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired private AlbumRepository albumRepository;

    @Autowired private AlbumPhotoRepository albumPhotoRepository;

    @Autowired private AlbumCommentRepository albumCommentRepository;

    @Test
    public void 앨범_작성_테스트(){

        Album album = Album.builder()
                .content("영화보시고 댓글좀 달아주세요.")
                .build();

        Album savedAlbum = albumRepository.save(album);

        log.debug("(1) Id {}, hashcode {} ", album.getId(), album.hashCode());
        log.debug("(2) Id {}, hashcode {} ", savedAlbum.getId(), savedAlbum.hashCode());

        assertThat(album.getContent(), is(savedAlbum.getContent()));
    }

    @Test
    public void 앨범_작성_및_댓글_테스트_ByTestEntityManager(){

        Album album = Album.builder()
                .content("백투더퓨처에 대한 사진첩")
                .build();

        Album savedAlbum = testEntityManager.persist(album);
        testEntityManager.flush();
    }

    @Test
    public void 앨범_작성_및_댓글테스트(){

        /**
         * log 의 디버깅 내용이 다르게 나온다.
         */

        Album album = Album.builder()
                .content("백투더퓨처를 보고 댓글좀 달아주세요")
                .build();

        // insert
        Album savedAlbum = albumRepository.save(album);

        AlbumComment albumComment = AlbumComment.builder()
                .comment("첫번재 댓글을 달았습니다.")
                .build();

        /** 양방향 매핑관계에서 양쪽 다 데이터 삽입 **/
        savedAlbum.addComment(albumComment);
        albumComment.setAlbum(savedAlbum);

        // insert
        AlbumComment savedAlbumComment = albumCommentRepository.save(albumComment);


        /**
         * Repository 에 저장되기 이전에, Repository 에 저장되고 난 이후에
         * 앨범의 내용을 비교한다.
         */
        assertThat(album.getContent(), is(albumComment.getAlbum().getContent()));
        assertThat(savedAlbum.getContent(), is(albumComment.getAlbum().getContent()));
        assertThat(album.getContent(), is(savedAlbumComment.getAlbum() .getContent()));
        assertThat(savedAlbum.getContent(), is(savedAlbumComment.getAlbum() .getContent()));

        /**
         * Repository 에 저장되기 이전에, Repository 에 저장되고 난 이후에
         * 앨범의 댓글을 비교한다.
         */
        assertThat(album.getAlbumCommentList().get(0).getComment(), is(albumComment.getComment()));
        assertThat(savedAlbum.getAlbumCommentList().get(0).getComment(), is(savedAlbumComment.getComment()));


        Album foundAlbum = albumRepository.findById(savedAlbum.getId()).get();
        log.debug("=== 로그 디버그 출력");
        log.debug("사진첩 내용 : {}", foundAlbum.getContent());

        List<AlbumComment> albumCommentList = foundAlbum.getAlbumCommentList();
        log.debug("사진첩의 댓글 개수 : {}", albumCommentList.size());
        for(AlbumComment comment : albumCommentList){
            log.debug("사진첩 댓글 : {}", comment.getComment());
        }
    }
}