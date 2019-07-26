package edu.pasudo123.app.album;

import edu.pasudo123.app.annotation.CustomApiRestController;
import edu.pasudo123.app.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pasudo123 on 2019-07-11
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@CustomApiRestController
@Slf4j
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping("/album")
    public ResponseEntity<ResponseAlbumSelectDto> createAlbum(@RequestBody RequestAlbumDto requestAlbumDto){

        ResponseAlbumSelectDto responseAlbumSelectDto = albumService.createAlbum(requestAlbumDto);

        return new ResponseEntity<>(responseAlbumSelectDto, HttpStatus.OK);
    }

    @GetMapping("/album")
    public ResponseEntity<List<ResponseAlbumSelectDto>> findAll(){

        List<ResponseAlbumSelectDto> responseAlbumSelectDtoList = albumService.findAll();

        return new ResponseEntity<>(responseAlbumSelectDtoList, HttpStatus.OK);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<ResponseAlbumPostDto> findById(@PathVariable Long id) throws ResourceNotFoundException{

        ResponseAlbumPostDto responseAlbumPostDto = albumService.findDtoById(id);

        return new ResponseEntity<>(responseAlbumPostDto, HttpStatus.OK);
    }


    @PatchMapping("/album/{id}")
    public void update(@RequestBody RequestAlbumDto requestAlbumDto,
                       @PathVariable Long id) throws ResourceNotFoundException {

        albumService.update(id, requestAlbumDto);

    }

    @DeleteMapping("/album/{id}")
    public void delete(@PathVariable Long id){

        albumService.delete(id);

    }
}
