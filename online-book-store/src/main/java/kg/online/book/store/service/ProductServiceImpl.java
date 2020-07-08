package kg.online.book.store.service;

import kg.online.book.store.dto.ProductDTO;
import kg.online.book.store.entity.Author;
import kg.online.book.store.entity.Genre;
import kg.online.book.store.entity.Image;
import kg.online.book.store.entity.Product;
import kg.online.book.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private GenreService genreService;

    @Override
    public Product create(ProductDTO productDTO) {
        Author author = authorService.getById(productDTO.getAuthorId());
        if(author != null){
            Product product = new Product();
            product.setAuthor(author);
            product.setAvailable(productDTO.isAvailable());
            product.setDescription(productDTO.getDescription());
            product.setGenreList(productDTO.getGenreList());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDiscount(productDTO.getDiscount());
            product.setImage(productDTO.getImage());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product deleteById(Long id) {
        Product product = getById(id);
        if(product != null){
            imageService.deleteByName(product.getImage().getName());
        }
       productRepository.deleteById(id);
        return product;
    }

    @Override
    public Product changeAvailable(Long productId, Boolean isAvailable) {
        Product product = getById(productId);
        if(product == null) return null;

        product.setAvailable(isAvailable);
        return productRepository.save(product);
    }

    @Override
    public Product changeDiscount(Long productId, Integer discount) {
        Product product = getById(productId);
        if(product == null) return null;

        if(discount <= 100 && discount >= 0){
            product.setDiscount(discount);
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateImage(Long productId, Image image) {
        Product product = getById(productId);
        if(product == null) return null;

        product.setImage(image);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllByName(String name) {
        return productRepository.findAllByNameContainingIgnoringCase(name);
    }

    @Override
    public List<Product> getAllByNameOrAuthorName(String name) {
        List<Product> productList = productRepository.findAllByNameContainingIgnoringCase(name);
        productList.addAll(productRepository.findAllByAuthorNameContainingIgnoringCase(name));
        return productList;
    }

//    @Override
//    public List<Product> getAllByGenreList(String genre) {
//        List<Genre> genreList = new ArrayList<>();
//        Genre genre1 = genreService.getByName(genre);
//        genreList.add(genre1);
//        return productRepository.findAllByGenreList(genreList);
//    }
}
