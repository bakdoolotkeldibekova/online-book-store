package kg.online.book.store.service;

import kg.online.book.store.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image create(MultipartFile multipartFile);
    List<Image> getAll();
    Image getById(Long id);
    Boolean deleteByName(String name);
}