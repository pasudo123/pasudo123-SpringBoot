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

    /**
     * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm/jpa/TestEntityManager.html
     * 참고하기
     */

    @Test
    public void 엔티티매니저_앨범_작성_및_댓글_테스트(){

        Album album = Album.builder()
                .content("백투더퓨처에 대한 사진첩")
                .build();

        // insert 쿼리 호출
        Album savedAlbum = testEntityManager.persist(album);
        testEntityManager.flush();
        testEntityManager.detach(savedAlbum);

        AlbumComment albumComment = AlbumComment.builder()
                .comment("첫번째 이야기")
                .build();

        // select 쿼리 호출 (FetchType.LAZY, FetchType.EAGER 를 구분하면 내용값이 달라짐)
        // FetchType.LAZY 는 필드값으로 가지는 컬렉션들에게도 영속성을 부여하기 때문이라고 추측
        Album foundAlbum = testEntityManager.find(Album.class, 1L);

        log.debug("== 첫번째 비교");
        assertThat(savedAlbum.getContent(), is(foundAlbum.getContent()));

        foundAlbum.addComment(albumComment);

        // setAlbum() 메소드 호출 시, albumComment 에 insert 쿼리 호출
        albumComment.setAlbum(foundAlbum);

        AlbumComment savedAlbumComment = testEntityManager.persist(albumComment);
        testEntityManager.flush();

        log.debug("== 두번째 비교");

        /**
         *
         * [FetchType.LAZY]
         * testEntityManager 에서 find() 메소드를 수행할 때,
         * 연관관계를 맺고있는 엔티티를 바로 조회하지 않는다.
         * 대신에 해당 엔티티를 가져올 때 그제서야 조회한다.
         *
         * [FetchType.EAGER]
         * testEntityManager 에서 find() 메소드를 수행할 때,
         * left outer join 을 수행하여 연관된 엔티티까지 한번에 조회한다.
         *
         *  **/

        // FetchType.LAZY
        // select 된 foundAlbum 은 영속성 컨텍스트에 계속 머물고 있다.
        // foundAlbum 에서 연관관계를 맺고있는 AlbumComment 를 찾을 때 select 쿼리가 시행된다.

        // FetchType.EAGER 로 하면 아래의 테스트는 실패한다. 실제 값이 `2` 찍힌다. 왜 그럴까?
        // 그에 대한 답변은 위에 있다.
        assertThat(foundAlbum.getAlbumCommentList().size(), is(1));

        log.debug("== 세번째 일반 출력");
        log.debug("== 댓글 : {}", albumComment.getComment());

        testEntityManager.detach(foundAlbum);
        testEntityManager.detach(savedAlbumComment);
    }

    @Test
    public void 앨범_작성_및_댓글테스트(){

        /**
         * log 의 디버깅 내용이 다르게 나온다.
         */

        Album album = Album.builder()
                .content("백투더퓨처를 보고 댓글좀 달아주세요")
                .build();

        // insert Album
        Album savedAlbum = albumRepository.save(album);
        albumRepository.flush();

        AlbumComment albumComment = AlbumComment.builder()
                .comment("첫번재 댓글을 달았습니다.")
                .build();

        /**
         * 특정 앨범에 댓글을 달았음
         * (1) 앨범을 찾아, 찾은 앨범에 댓글을 추가.
         * (2) 댓글 저장
         * **/

        // select Album
        Album foundAlbum = albumRepository.findById(savedAlbum.getId()).get();
        albumRepository.flush();

        /** 양방향 매핑관계에서 양쪽 다 데이터 삽입 **/
        albumComment.setAlbum(foundAlbum);

        // insert AlbumComment
        AlbumComment savedAlbumComment = albumCommentRepository.save(albumComment);
        albumCommentRepository.flush();

        foundAlbum.addComment(savedAlbumComment);

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


        log.debug("=== 로그 디버그 출력");
        log.debug("사진첩 내용 : {}", foundAlbum.getContent());

        List<AlbumComment> albumCommentList = foundAlbum.getAlbumCommentList();
        log.debug("사진첩의 댓글 개수 : {}", albumCommentList.size());
        for(AlbumComment comment : albumCommentList){
            log.debug("사진첩 댓글 : {}", comment.getComment());
        }
    }
}
