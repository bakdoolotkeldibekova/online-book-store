package kg.online.book.store.service;

import kg.online.book.store.dto.OrderedProductDTO;
import kg.online.book.store.entity.*;
import kg.online.book.store.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedProductServiceImpl implements OrderedProductService {
    @Autowired
    private OrderedProductRepository orderedProductRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public OrderedProduct create(OrderedProductDTO orderedProductDTO) {
        Order order = orderService.getById(orderedProductDTO.getOrderId());
        Product product = productService.getById(orderedProductDTO.getProductId());
        if(order == null || product == null) return null;

        OrderedProduct orderedProduct = new OrderedProduct();
        orderedProduct.setOrder(order);
        orderedProduct.setProduct(product);
        orderedProduct.setQuantity(orderedProductDTO.getQuantity());
        return orderedProductRepository.save(orderedProduct);
    }

    @Override
    public OrderedProduct deleteById(Long id) {
        OrderedProduct orderedProduct = getById(id);
        orderedProductRepository.deleteById(id);
        return orderedProduct;
    }

    @Override
    public OrderedProduct getById(Long id) {
        return orderedProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderedProduct> getAll() {
        return orderedProductRepository.findAll();
    }

    @Override
    public List<OrderedProduct> getAllMine(String login) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        if (userAccount == null) return null;

        Order order = orderService.getByUserAccount(userAccount);
        if (order == null) return null;

        return orderedProductRepository.findAllByOrder(order);
    }
}
