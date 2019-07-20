package edu.pasudo123.app.album.comment;

import edu.pasudo123.app.album.*;
import edu.pasudo123.app.annotation.CustomApiRestController;
import edu.pasudo123.app.exception.InvalidRequestException;
import edu.pasudo123.app.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by pasudo123 on 2019-07-17
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@CustomApiRestController
@Slf4j
@RequiredArgsConstructor
public class AlbumCommentController {

    private final AlbumService albumService;
    private final AlbumCommentService albumCommentService;

    @PostMapping("/album/{albumId}/comment")
    public ResponseEntity<ResponseAlbumCommentDto> createAlbumComment(@PathVariable Long albumId,
                                                                      @Valid @RequestBody RequestAlbumCommentDto requestAlbumCommentDto,
                                                                      BindingResult bindingResult) throws ResourceNotFoundException {

        Album album = findAlbumById(albumId);

        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }

        ResponseAlbumCommentDto res = albumCommentService.createAlbumComment(album, requestAlbumCommentDto);

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/album/{albumId}/comment")
    public ResponseEntity<List<ResponseAlbumCommentDto>> findAll(@PathVariable Long albumId) {



        return null;
    }

    @GetMapping("/album/{albumId}/comment/{commentId}")
    public ResponseEntity<ResponseAlbumCommentDto> findById(@PathVariable Long albumId,
                                                                  @PathVariable Long commentId) {


        return null;
    }

    @Transactional(readOnly = true)
    Album findAlbumById(Long albumId) {
        /**
         * 해당 컨트롤러는 코멘트에 대한 컨트롤러이니,
         * 앨범에 대한 서비스 처리는 여기서 처리하고
         * 앨범댓글에 대한 서비스 처리는 그것만 하도록 좀 더 명확히 하는 것
         */
        return albumService.findEntityById(albumId);
    }

}
