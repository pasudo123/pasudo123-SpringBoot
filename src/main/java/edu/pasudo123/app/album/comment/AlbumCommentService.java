package edu.pasudo123.app.album.comment;

import edu.pasudo123.app.album.Album;
import edu.pasudo123.app.album.AlbumRepository;
import edu.pasudo123.app.exception.ResourceNotFoundException;
import edu.pasudo123.app.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pasudo123 on 2019-07-17
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Service
@Slf4j
@RequiredArgsConstructor
public class AlbumCommentService {

    private final ModelMapperUtils modelMapperUtils;
    private final AlbumCommentRepository albumCommentRepository;

    @Transactional
    ResponseAlbumCommentDto createAlbumComment(Album album, RequestAlbumCommentDto requestAlbumCommentDto) throws ResourceNotFoundException{

        // 댓글 생성 및 저장
        AlbumComment albumComment = AlbumComment.builder()
                .comment(requestAlbumCommentDto.getComment())
                .build();
        albumComment.setAlbum(album);

        albumCommentRepository.save(albumComment);

        // 앨범에도 내용 추가 (양방향으로써)
        album.addComment(albumComment);

        return modelMapperUtils.map(albumComment, ResponseAlbumCommentDto.class);
    }

}
