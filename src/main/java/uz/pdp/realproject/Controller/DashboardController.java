package uz.pdp.realproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.realproject.entity.InputProduct;
import uz.pdp.realproject.entity.OutputProduct;
import uz.pdp.realproject.repository.InputProductRepository;
import uz.pdp.realproject.repository.OutProductRepository;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    OutProductRepository outProductRepository;

    @GetMapping("/sumInputProducts")
    public Double getSumInputProducts() {
        Double totalAmount = inputProductRepository.sumInputProducts();
        return totalAmount;
    }

    @GetMapping("/mostSellProducts")
    public List<OutputProduct> get() {
        List<OutputProduct> bestSellers = outProductRepository.getBestSelledProducts();
        return bestSellers;
    }

    @GetMapping("/expire")
    public List<InputProduct> getexpireProduct() {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(3);
        List<InputProduct> expireInputProducts = inputProductRepository.findAllByExpireDateLessThan(localDateTime);
        return expireInputProducts;
    }

    @GetMapping("/totalProduct")
    public Integer getNumberOfTypeProduct(){
        Integer productNum = inputProductRepository.totalProductNum();
        return productNum;
    }
}


