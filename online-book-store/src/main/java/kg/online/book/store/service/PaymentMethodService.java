package kg.online.book.store.service;

import kg.online.book.store.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod create(PaymentMethod paymentMethod);
    PaymentMethod deleteById(Long id);
    PaymentMethod getById(Long id);
    List<PaymentMethod> getAll();

}
