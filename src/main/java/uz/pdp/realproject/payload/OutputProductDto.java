package uz.pdp.realproject.payload;

import lombok.Data;

import java.util.Date;

@Data
public class OutputProductDto {
    private Integer id;
    private Double amount;
    private Double price;

    private Integer productId;
    private Integer outputId;


}
