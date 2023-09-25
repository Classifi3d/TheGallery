package com.project.TheGallery.controller;

import com.project.TheGallery.entity.Artist;
import com.project.TheGallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

@RestController
public class ArtistsController {

    @Autowired
    private GalleryService galleryService;

    private final Logger LOGGER = LoggerFactory.getLogger(ArtistsController.class);

    @GetMapping(value = "/artists")
    public List<Artist> fetchAllArtists(){
        return galleryService.fetchArtistList();
    }

    @GetMapping(value = "/artists/{id}")
    public Artist fetchArtistById(@PathVariable("id") Integer artistId) {
        return galleryService.fetchArtistId(artistId);
    }

    @GetMapping(value = "/artists/random")
    public Artist fetchArtistRandom() {
        return galleryService.fetchArtistRandom();
    }

    @GetMapping(value = "/artists/random10")
    public List<Artist> fetchArtistRandom10() {
        return galleryService.fetchArtistRandom10();
    }

    @GetMapping(value = "/artists/random/{id}")
    public List<Artist> fetchArtistRandomList(@PathVariable("id") Integer artistCount) {
        return galleryService.fetchArtistRandomList(artistCount);
    }

    @GetMapping(value = "/artists/name/{name}")
    public Artist fetchArtistName(@PathVariable("name") String artistName) {
        return galleryService.fetchArtistByName(artistName);
    }

    @RequestMapping(value = "/photo/{name}/{id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String artistName,
                                           @PathVariable("id") Integer paintingNumber)
            throws IOException {
        LOGGER.info(artistName);
        var imgFile = new ClassPathResource("static/img/images/"+artistName+"/"+artistName+"_"+paintingNumber+".jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

//    @GetMapping(value = "/artists/name/{name}/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
//    public @ResponseBody byte[] fetchArtistPicture(@PathVariable("name") String artistName,
//                                                   @PathVariable("id") Integer pictureId)
//    throws IOException {
//
//        InputStream in = getClass()
//                .getResourceAsStream("/TheGalleryDB/images/"+artistName+"/"+artistName+pictureId);
//
//
//        return IOUtils.toByteArray(in);
//    }

//    @RequestMapping(value = "/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//    public void getImage(HttpServletResponse response) throws IOException {
//        var imgFile = new ClassPathResource("img/images/Titian/Titian_12.jpg");
//        var imgFile = new ClassPathResource("static/img/background.png");
//
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
//    }
// http://localhost:8081/photo/Albrecht_D%C3%BCrer/67

}


