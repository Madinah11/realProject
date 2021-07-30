package uz.pdp.realproject.payload;

import lombok.Data;
import uz.pdp.realproject.entity.Category;

import java.util.Set;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String code;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;


}
