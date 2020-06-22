package kg.online.book.store.dto;

import kg.online.book.store.entity.OrderedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {
    private Long deliveryMethodId;
    private Long paymentMethodId;
    private List<OrderedProduct> orderedProductList;
}
