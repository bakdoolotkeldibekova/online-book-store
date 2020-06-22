package kg.online.book.store.service;

import kg.online.book.store.dto.OrderDTO;
import kg.online.book.store.dto.OrderedProductDTO;
import kg.online.book.store.entity.*;
import kg.online.book.store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private BillService billService;

    @Override
    public Order create(String login, OrderDTO orderDTO) {
        DeliveryMethod deliveryMethod = deliveryMethodService.getById(orderDTO.getDeliveryMethodId());
        PaymentMethod paymentMethod = paymentMethodService.getById(orderDTO.getPaymentMethodId());
        UserAccount userAccount = userAccountService.getByLogin(login);
        if(deliveryMethod == null || paymentMethod == null || userAccount == null) return null;

        Order order = new Order();
        order.setDeliveryMethod(deliveryMethod);
        order.setPaymentMethod(paymentMethod);
        order.setUserAccount(userAccount);
        order.setOrderedProductList(orderDTO.getOrderedProductList());

        Double productsCost = 0.0;
        for (OrderedProduct o : orderDTO.getOrderedProductList()){
            Double discountPrice = o.getProduct().getPrice() - (o.getProduct().getPrice() * o.getProduct().getDiscount() / 100);
            productsCost += o.getQuantity() * discountPrice;
        }
        order.setProductsCost(productsCost);

        Bill bill = new Bill(productsCost+deliveryMethod.getDeliveryCost(), false, order);
        billService.create(bill);

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
    public Order getByLogin(String login) {
        UserAccount userAccount = userAccountService.getByLogin(login);
        return orderRepository.findByUserAccount(userAccount);
    }

    @Override
    public List<Order> getAllByProductCostBetween(Double a, Double b) {
        return orderRepository.findAllByProductsCostBetween(a, b);
    }
}
