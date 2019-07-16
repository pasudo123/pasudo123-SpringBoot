package edu.pasudo123.app.album;

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
@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping("/album")
    public ResponseEntity<ResponseAlbumDto> createAlbum(@RequestBody RequestAlbumDto requestAlbumDto){

        ResponseAlbumDto responseAlbumDto = albumService.createAlbum(requestAlbumDto);

        return new ResponseEntity<>(responseAlbumDto, HttpStatus.OK);
    }

    @GetMapping("/album")
    public ResponseEntity<List<ResponseAlbumDto>> findAll(){

        List<ResponseAlbumDto> responseAlbumDtoList = albumService.findAll();

        return new ResponseEntity<>(responseAlbumDtoList, HttpStatus.OK);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<ResponseAlbumDto> findById(@PathVariable Long id) throws ResourceNotFoundException{

        ResponseAlbumDto responseAlbumDto = albumService.findById(id);

        return new ResponseEntity<>(responseAlbumDto, HttpStatus.OK);
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
