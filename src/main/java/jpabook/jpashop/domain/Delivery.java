package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;
}