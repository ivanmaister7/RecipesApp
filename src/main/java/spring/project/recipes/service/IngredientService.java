package spring.project.recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.recipes.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Long> findIngredientByQueryProducts(List<Long> productsId) {
        return ingredientRepository.findIngredientByQueryProducts(productsId);
    }

}
