package kg.online.book.store.service;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.entity.DeliveryMethod;
import kg.online.book.store.entity.Order;
import kg.online.book.store.entity.PaymentMethod;
import kg.online.book.store.entity.UserAccount;
import kg.online.book.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DeliveryMethodService deliveryMethodService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public Order create(OrderDTO orderDTO) {
        DeliveryMethod deliveryMethod = deliveryMethodService.getById(orderDTO.getDeliveryMethodId());
        PaymentMethod paymentMethod = paymentMethodService.getById(orderDTO.getPaymentMethodId());
        UserAccount userAccount = userAccountService.getById(orderDTO.getUserAccountId());
        if(deliveryMethod == null || paymentMethod == null || userAccount == null) return null;

        Order order = new Order();
        order.setDeliveryMethod(deliveryMethod);
        order.setPaymentMethod(paymentMethod);
        order.setProductsCost(orderDTO.getProductsCost());
        order.setUserAccount(userAccount);
        return orderRepository.save(order);
    }

    @Override
    public Order deleteById(Long id) {
        Order order = getById(id);
        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getByUserAccount(UserAccount userAccount) {
        return orderRepository.findByUserAccount(userAccount);
    }
}
