package uz.pdp.realproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDateTime expireDate;

    @ManyToOne
    private Input input;


}
