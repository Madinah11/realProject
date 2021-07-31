package uz.pdp.realproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.realproject.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Supplier extends AbsEntity {
    @Column(nullable = false,unique = true)
    private String phoneNumber;
}
