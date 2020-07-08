package kg.online.book.store.service;

import kg.online.book.store.dto.StarsDTO;
import kg.online.book.store.entity.Product;
import kg.online.book.store.entity.Stars;
import kg.online.book.store.repository.StarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarsServiceImpl implements StarsService {
    @Autowired
    private StarsRepository starsRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Stars create(String login, StarsDTO starsDTO) {
        Product product = productService.getById(starsDTO.getProductId());
        if(product == null) return null;

        Stars stars = new Stars();
        stars.setNumber(starsDTO.getNumber());
        stars.setProduct(product);
        stars.setUserAccount(userAccountService.getByLogin(login));
        return starsRepository.save(stars);
    }

    @Override
    public Stars deleteById(Long id) {
        Stars stars = starsRepository.findById(id).orElse(null);
        starsRepository.deleteById(id);
        return stars;
    }

    @Override
    public List<Stars> getAllByProductId(Long id) {
        return starsRepository.findAllByProduct_Id(id);
    }

    @Override
    public Integer getAverage(Long productId) {
        Integer sum = 0, count = 0;
        List<Stars> starsList = getAllByProductId(productId);
        for (Stars s : starsList){
            sum += s.getNumber();
            count++;
        }
        if (count == 0) return sum;
        return sum/count;
    }
}
