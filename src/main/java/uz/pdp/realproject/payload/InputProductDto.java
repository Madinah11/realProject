package uz.pdp.realproject.payload;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class InputProductDto {
    private Integer id;
    private Double amount;
    private Double price;
    private LocalDateTime expireDate;

    private Integer productId;
    private Integer inputId;


}
