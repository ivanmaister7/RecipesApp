package spring.project.recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.recipes.domain.Product;
import spring.project.recipes.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long vehicleId) {
        return productRepository.findByProductId(vehicleId);
    }

    public List<Long> findProductByNames(List<String> names) {
        return productRepository.findProductByNames(names);
    }

    public List<Product> findAll() {
        return productRepository.findAllProducts();
    }
}
