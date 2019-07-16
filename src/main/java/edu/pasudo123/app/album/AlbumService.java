package edu.pasudo123.app.album;

import edu.pasudo123.app.exception.ResourceNotFoundException;
import edu.pasudo123.app.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pasudo123 on 2019-07-11
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumService {

    private final ModelMapperUtils modelMapperUtils;
    private final AlbumRepository albumRepository;

    @Transactional
    ResponseAlbumDto createAlbum(final RequestAlbumDto requestAlbumDto) {

        Album album = Album.builder()
                .title(requestAlbumDto.getTitle())
                .content(requestAlbumDto.getContent())
                .build();

        Album savedAlbum = albumRepository.save(album);

        return modelMapperUtils.map(savedAlbum, ResponseAlbumDto.class);
    }

    @Transactional(readOnly = true)
    List<ResponseAlbumDto> findAll() {

        List<Album> albumList = albumRepository.findAll();

        return modelMapperUtils.mapAll(albumList, ResponseAlbumDto.class);
    }

    @Transactional(readOnly = true)
    ResponseAlbumDto findById(Long id) throws ResourceNotFoundException {

        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("조회할 앨범이 존재하지 않습니다"));

        return modelMapperUtils.map(album, ResponseAlbumDto.class);
    }

    @Transactional
    void update(final Long id, final RequestAlbumDto requestAlbumDto) throws ResourceNotFoundException {

        Album foundAlbum = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("업데이트할 사진첩 앨범이 존재하지 않습니다."));

        /** 앨범 내용 변경 **/
        foundAlbum.updateTitle(requestAlbumDto.getTitle());
        foundAlbum.updateContent(requestAlbumDto.getContent());

        /** 댓글에 대한 앨범 내용 변경 **/
        foundAlbum.getAlbumCommentList()
                .forEach(albumComment -> {
                    albumComment.setAlbum(foundAlbum);
                });

        /** 사진에 대한 앨범 내용 변경 **/
        foundAlbum.getAlbumPhotoList()
                .forEach(albumPhoto -> {
                    albumPhoto.setAlbum(foundAlbum);
                });

        albumRepository.save(foundAlbum);
    }

    @Transactional
    void delete(final Long id){
        albumRepository.deleteById(id);
    }
}
