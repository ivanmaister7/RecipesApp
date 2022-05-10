package spring.project.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.project.recipes.domain.Recipe;
import spring.project.recipes.service.IngredientService;
import spring.project.recipes.service.ProductService;
import spring.project.recipes.service.RecipeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllRecipes() {
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(recipeService.saveRecipe(recipe), HttpStatus.CREATED);
    }
    @PostMapping("/search")
    public ResponseEntity<?> findValidRecipe(@RequestBody List<String> products) {
        List<Long> productsId = productService.findProductByNames(products);
        return new ResponseEntity<>(recipeService.getRecipesByIds(ingredientService.findIngredientByQueryProducts(productsId)), HttpStatus.CREATED);
    }
}
