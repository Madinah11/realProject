package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.*;
import uz.pdp.realproject.payload.InputProductDto;
import uz.pdp.realproject.payload.OutputProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutProductRepository outProductRepository;

    public Result add(OutputProductDto outputProductDto) {
        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new Result("Output not found",false);
        Output output = optionalOutput.get();
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found",false);
        Product product = optionalProduct.get();

        OutputProduct outputProduct=new OutputProduct(null,product,outputProductDto.getAmount(),outputProductDto.getPrice(),output);
        outProductRepository.save(outputProduct);
        return new Result("OutputProduct saved", true);
    }

    public List<OutputProduct> get() {
        List<OutputProduct> outProductAll = outProductRepository.findAll();
        return outProductAll;
    }

    public OutputProduct getById(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outProductRepository.findById(id);
        if (optionalOutputProduct.isPresent()) {
            OutputProduct outputProduct = optionalOutputProduct.get();
            return outputProduct;
        }
        return new OutputProduct();
    }

    public Result delete(Integer id) {
        try {
            outProductRepository.deleteById(id);
            return new Result("OutputProduct deleted", true);
        } catch (Exception exception) {
            return new Result("OutputProduct not found", false);
        }
    }

    public Result edit(Integer id,OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new Result("OutputProduct not found", false);
        OutputProduct editingOutputProduct = optionalOutputProduct.get();

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new Result("Output not found",false);
        Output output = optionalOutput.get();
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found",false);
        Product product = optionalProduct.get();

        editingOutputProduct.setProduct(product);
        editingOutputProduct.setOutput(output);
        editingOutputProduct.setAmount(outputProductDto.getAmount());
        editingOutputProduct.setPrice(outputProductDto.getPrice());
        outProductRepository.save(editingOutputProduct);
        return new Result("OutputProduct edited", true);
    }
}
