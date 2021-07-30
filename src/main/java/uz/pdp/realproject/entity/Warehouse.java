package uz.pdp.realproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.realproject.entity.template.AbsEntity;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Warehouse extends AbsEntity {
}
