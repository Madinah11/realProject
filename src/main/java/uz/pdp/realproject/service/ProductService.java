package uz.pdp.realproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.realproject.entity.*;
import uz.pdp.realproject.payload.ProductDto;
import uz.pdp.realproject.payload.Result;
import uz.pdp.realproject.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public Result add(ProductDto productDto) {
        boolean existsByName = productRepository.existsByName(productDto.getName());
        if (existsByName)
            return new Result("There is such a product", false);
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Category not found",false);
        Category category = optionalCategory.get();
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found",false);
        Measurement measurement = optionalMeasurement.get();
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("Photo not found",false);
        Attachment attachment = optionalAttachment.get();

        Product product=new Product(null,(productDto.getId().toString()),productDto.getName(),true,category,attachment,measurement);
        productRepository.save(product);
        return new Result("Product saved", true);
    }

    public List<Product> get() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Product getById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return product;
        }
        return new Product();
    }

    public Result delete(Integer id) {
        try {
            productRepository.deleteById(id);
            return new Result("Product deleted", true);
        } catch (Exception exception) {
            return new Result("Product not found", false);
        }
    }

    public Result edit(Integer id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent())
            return new Result("Product not found", false);
        Product product = productOptional.get();

        boolean existsByName = productRepository.existsByName(productDto.getName());
        if (existsByName)
            return new Result("There is such a product", false);
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Category not found",false);
        Category category = optionalCategory.get();
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found",false);
        Measurement measurement = optionalMeasurement.get();
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("Photo not found",false);
        Attachment attachment = optionalAttachment.get();

        product.setName(productDto.getName());
        product.setCode(productDto.getId().toString());
        product.setCategory(category);
        product.setMeasurement(measurement);
        product.setPhoto(attachment);
        productRepository.save(product);
        return new Result("User edited", true);
    }
}
