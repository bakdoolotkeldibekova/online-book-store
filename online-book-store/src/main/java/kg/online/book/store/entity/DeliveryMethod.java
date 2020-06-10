package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery_method")
public class DeliveryMethod extends BaseEntity{

    @Column(name = "delivery_name", nullable = false)
    private String deliveryName;

    @Column(name = "delivery_cost")
    private Integer deliveryCost;

}
