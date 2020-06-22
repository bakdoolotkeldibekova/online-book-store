package kg.online.book.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customer_order")
public class Order extends BaseEntity {

    @Column(name = "products_cost", nullable = false)
    private double productsCost;

    @ManyToOne
    @JoinColumn(name = "deivery_method_id")
    private DeliveryMethod deliveryMethod;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "user_account__id", nullable = false)
    private UserAccount userAccount;

    @OneToMany
    @JoinColumn(name = "ordered_product_id",nullable  = false)
    private List<OrderedProduct> orderedProductList = new ArrayList<>();

}