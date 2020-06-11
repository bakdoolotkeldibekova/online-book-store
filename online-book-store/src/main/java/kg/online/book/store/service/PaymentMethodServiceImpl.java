package kg.online.book.store.service;

import kg.online.book.store.entity.PaymentMethod;
import kg.online.book.store.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod create(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod deleteById(Long id) {
        PaymentMethod paymentMethod = getById(id);
        paymentMethodRepository.deleteById(id);
        return paymentMethod;
    }

    @Override
    public PaymentMethod getById(Long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();
    }
}
