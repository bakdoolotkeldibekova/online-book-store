package kg.online.book.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BillDTO {
    private double totalCost;
    private boolean payed = false;
    private Long orderId;
}
