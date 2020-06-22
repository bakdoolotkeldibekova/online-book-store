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
            product.setDiscount(productDTO.getDiscount());
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
}
