package liliana.seesion_1.entity.ex1;

import jakarta.persistence.*;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 200)
    private String productName;
}
