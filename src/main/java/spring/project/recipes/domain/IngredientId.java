package spring.project.recipes.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IngredientId implements Serializable {
    private Long recipeId;
    private Long productId;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientId)) return false;
        IngredientId ingredientId = (IngredientId) o;
        return Objects.equals(getRecipeId(), ingredientId.getRecipeId()) &&
                Objects.equals(getProductId(), ingredientId.getProductId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRecipeId(), getProductId());
    }

    @Override
    public String toString() {
        return "IngredientId{" +
                "recipeId=" + recipeId +
                ", productId=" + productId +
                '}';
    }
}
