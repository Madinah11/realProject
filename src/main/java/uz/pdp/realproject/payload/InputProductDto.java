package uz.pdp.realproject.payload;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class InputProductDto {
    private Integer id;
    private Double amount;
    private Double price;
    private Date expireDate;

    private Integer productId;
    private Integer inputId;


}
