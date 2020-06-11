package kg.online.book.store.service;

import kg.online.book.store.dto.ProductDTO;
import kg.online.book.store.entity.Author;
import kg.online.book.store.entity.Product;
import kg.online.book.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public Product create(ProductDTO productDTO) {
        Author author = authorService.getById(productDTO.getAuthorId());
        if(author != null){
            Product product = new Product();
            product.setAuthor(author);
            product.setAvailable(productDTO.isAvailable());
            product.setDescription(productDTO.getDescription());
            product.setGenreSet(productDTO.getGenreSet());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
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
        productRepository.deleteById(id);
        return product;
    }
}
