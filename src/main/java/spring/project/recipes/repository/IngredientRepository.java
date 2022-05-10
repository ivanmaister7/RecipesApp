package spring.project.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.project.recipes.domain.Ingredient;

import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
@Query(value = " SELECT DISTINCT r.recipe.recipeId " +
        "FROM Ingredient r " +
        "WHERE r.product.productId IN :products " +
        "AND r.recipe.recipeId NOT IN ( " +
                "SELECT rr.recipe.recipeId " +
                "FROM Ingredient rr " +
                "WHERE rr.product.productId NOT IN :products ) " )
    List<Long> findIngredientByQueryProducts(@Param("products") Collection<Long> products);
}
