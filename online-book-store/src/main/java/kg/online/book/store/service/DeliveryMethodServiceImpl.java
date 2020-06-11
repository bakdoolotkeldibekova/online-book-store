package kg.online.book.store.service;

import kg.online.book.store.entity.DeliveryMethod;
import kg.online.book.store.repository.DeliveryMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService {
    @Autowired
    private DeliveryMethodRepository deliveryMethodRepository;

    @Override
    public DeliveryMethod create(DeliveryMethod deliveryMethod) {
        return deliveryMethodRepository.save(deliveryMethod);
    }

    @Override
    public DeliveryMethod deleteById(Long id) {
        DeliveryMethod deliveryMethod = getById(id);
        deliveryMethodRepository.deleteById(id);
        return deliveryMethod;
    }

    @Override
    public DeliveryMethod getById(Long id) {
        return deliveryMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryMethod> getAll() {
        return deliveryMethodRepository.findAll();
    }
}
