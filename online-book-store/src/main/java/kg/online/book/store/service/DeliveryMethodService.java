package kg.online.book.store.service;

import kg.online.book.store.entity.DeliveryMethod;

import java.util.List;

public interface DeliveryMethodService {
    DeliveryMethod create(DeliveryMethod deliveryMethod);
    DeliveryMethod deleteById(Long id);
    DeliveryMethod getById(Long id);
    List<DeliveryMethod> getAll();
}
