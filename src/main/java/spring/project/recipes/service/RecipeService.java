package spring.project.recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.recipes.domain.Recipe;
import spring.project.recipes.domain.Ingredient;
import spring.project.recipes.domain.Product;
import spring.project.recipes.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ProductService productService;

    public Recipe saveRecipe(Recipe recipe) {
        Recipe newRecipe = new Recipe();
        newRecipe.setRecipeName(recipe.getRecipeName());
        newRecipe.setInfo(recipe.getInfo());
        newRecipe.getIngredients().addAll((recipe.getIngredients()
                .stream()
                .map(ingredient -> {
                    Product product = productService.findProductById(ingredient.getProduct().getProductId());
                    Ingredient newIngredient = new Ingredient();
                    newIngredient.setProduct(product);
                    newIngredient.setRecipe(newRecipe);
                    newIngredient.setQuantity(ingredient.getQuantity());
                    newIngredient.setUnit(ingredient.getUnit());
                    return newIngredient;
                })
                .collect(Collectors.toList())
        ));
        return recipeRepository.save(newRecipe);
    }

    public List<Recipe> getRecipesByIds(List<Long> ids){
        return recipeRepository.findAllByIds(ids);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAllRecipe();
    }
}
