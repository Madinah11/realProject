package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.*;
import uz.pdp.realproject.payload.InputDto;
import uz.pdp.realproject.payload.InputProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputProductRepository inputProductRepository;

    public Result add(InputProductDto inputProductDto) {
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent())
            return new Result("Input not found",false);
        Input input1 = optionalInput.get();
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found",false);
        Product product = optionalProduct.get();

        InputProduct inputProduct=new InputProduct(null,product,inputProductDto.getAmount(),inputProductDto.getPrice(),inputProductDto.getExpireDate(),input1);
        inputProductRepository.save(inputProduct);
        return new Result("InputProduct saved", true);
    }

    public List<InputProduct> get() {
        List<InputProduct> allInputProduct = inputProductRepository.findAll();
        return allInputProduct;
    }

    public InputProduct getById(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()) {
            InputProduct inputProduct = optionalInputProduct.get();
            return inputProduct;
        }
        return new InputProduct();
    }

    public Result delete(Integer id) {
        try {
            inputProductRepository.deleteById(id);
            return new Result("InputProduct deleted", true);
        } catch (Exception exception) {
            return new Result("InputProduct not found", false);
        }
    }

    public Result edit(Integer id,InputProductDto inputProductDto) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new Result("InputProduct not found", false);
        InputProduct editingInputProduct = optionalInputProduct.get();

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent())
            return new Result("Input not found",false);
        Input input1 = optionalInput.get();
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found",false);
        Product product = optionalProduct.get();

        editingInputProduct.setProduct(product);
        editingInputProduct.setInput(input1);
        editingInputProduct.setAmount(inputProductDto.getAmount());
        editingInputProduct.setPrice(inputProductDto.getPrice());
        editingInputProduct.setExpireDate(editingInputProduct.getExpireDate());
        inputProductRepository.save(editingInputProduct);
        return new Result("InputProduct edited", true);


    }
}
