package com.assesment.recipeapp.demo.repository;

import com.assesment.recipeapp.demo.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    List<Recipe> findByName(String name);
/*
    List<Recipe> findByIngredientsId(long id);
*/

/*    @Query("select recipe.ingredients from Recipe recipe")
    Iterable<Recipe> findIngredientsById(long id);*/
}
