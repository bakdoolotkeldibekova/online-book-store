package kg.online.book.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {
    private double productsCost;
    private Long deliveryMethodId;
    private Long paymentMethodId;
    private Long userAccountId;
}
