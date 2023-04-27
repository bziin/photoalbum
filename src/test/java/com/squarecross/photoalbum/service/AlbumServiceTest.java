package com.squarecross.photoalbum.service;
import com.squarecross.photoalbum.domain.Photo;
import com.squarecross.photoalbum.dto.AlbumDto;
import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.repository.AlbumRepository;
import com.squarecross.photoalbum.repository.PhotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class AlbumServiceTest {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;
    @Autowired
    private PhotoRepository photoRepository;

    @Test
    void getAlbum() {
        Album album = new Album();
        album.setAlbumName("테스트");
        Album savedAlbum = albumRepository.save(album);

        AlbumDto resAlbum = albumService.getAlbum(savedAlbum.getAlbumId());
        assertEquals("테스트", resAlbum.getAlbumName());


    }
}
//    @Test
//    void testPhotoCount() {
//        Album album = new Album();
//        album.setAlbumName("테스트");
//        Album savedAlbum = albumRepository.save(album);
//        //사진을 생성하고 ,setAllbum 을 통해 앨범을 지정해준 후 ,repository 에 사진을 저장한다.
//        Photo photo1 = new Photo();
//        photo1.setFileName("사진1");
//        photo1.setAlbum(savedAlbum);
//        photoRepository.save(photo1);
//
//    }
//}
