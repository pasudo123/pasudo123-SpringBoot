package edu.pasudo123.app.album;

import edu.pasudo123.app.util.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

/**
 * Created by pasudo123 on 2019-07-11
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 *
 * -
 * classes 를 지정하여, ApplicationContext 에 등록한 클래스를 설정한다.
 * 없으면 @Configuration 또는 @SpringBootConfiguration 붙은 클래스를 로드한다.
 *
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AlbumService.class})
@Slf4j
public class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;

    @MockBean
    private ModelMapperUtils modelMapperUtils;

    @MockBean
    private AlbumRepository albumRepository;

    public Album savedAlbum;

    @Before
    public void initAlbum(){

        /***
         * mockbean 테스트를 위해서, responseAlbum 의 내용 값을
         * savedAlbum 객체로 변환. DB 에 저장하였다 가정하고 다시 리턴된 상태를 만들어주기 위해서
         */

        ResponseAlbumSelectDto responseDto = new ResponseAlbumSelectDto();
        responseDto.setId(1L);
        responseDto.setTitle("첫번째 사진첩");
        responseDto.setContent("첫번째 사진첩의 내용");
        responseDto.setCreateDate(LocalDateTime.now());
        responseDto.setUpdateDate(LocalDateTime.now());

        this.savedAlbum = modelMapperUtils.map(responseDto, Album.class);
    }

    @Test
    public void 앨범_생성_서비스_테스트(){

        /** given **/
        RequestAlbumDto requestDto = new RequestAlbumDto();
        requestDto.setTitle("첫번쨰 사진첩");
        requestDto.setContent("첫번째 사진첩의 내용");

        ResponseAlbumSelectDto responseDto = new ResponseAlbumSelectDto();
        responseDto.setId(1L);
        responseDto.setTitle("첫번째 사진첩");
        responseDto.setContent("첫번째 사진첩의 내용");
        responseDto.setCreateDate(LocalDateTime.now());
        responseDto.setUpdateDate(LocalDateTime.now());

        given(modelMapperUtils.map(savedAlbum, ResponseAlbumSelectDto.class)).willReturn(responseDto);

        /** when **/
        ResponseAlbumSelectDto createdAlbumDto = albumService.createAlbum(requestDto);

        /** then **/
        assertThat(createdAlbumDto.getTitle(), is(responseDto.getTitle()));
    }
}
