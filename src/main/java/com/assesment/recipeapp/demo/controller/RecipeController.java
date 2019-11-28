package  com.assesment.recipeapp.demo.controller;


import com.assesment.recipeapp.demo.model.Ingredients;
import com.assesment.recipeapp.demo.model.Recipe;
import com.assesment.recipeapp.demo.repository.IngredientsRepository;
import com.assesment.recipeapp.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    @GetMapping(value="/ingredients")
    public List<Ingredients> getIngrendientsOrderByName() {
        return (List<Ingredients>) ingredientsRepository.findAllByOrderByName();
    }

/*    @GetMapping("/ingredients/recipies/{id}")
    public List<Recipe> getIngredientsByRecipeId(@PathVariable(value = "id") long id){
        return (List<Recipe>) recipeRepository.findIngredientsById(id);
    }*/


    @GetMapping("/recipies")
    public List<Recipe> getAllRecipies() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @GetMapping("/recipies/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable(value = "id") long id){
        return recipeRepository.findById(id);
    }

/*    @GetMapping("/recipies/ingredients/{id}")
    public List<Recipe> getRecipeByIngredientsId(@PathVariable(value = "id") long id){
        return recipeRepository.findByIngredientsId(id);
    }*/


    @PostMapping(value = "/recipies/create")
    public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe) {
        Recipe _recipe = recipeRepository.save(new Recipe(recipe.getName(), recipe.isVegetarian(), recipe.getIngredients(), recipe.getDescription()));
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(_recipe);
    }


    @DeleteMapping("/recipies/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") long id) {
        recipeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("{\"response\":\"Recipe has been deleted!\"}");
    }

    @DeleteMapping("/recipies/delete")
    public ResponseEntity<String> deleteAllRecipies() {
        recipeRepository.deleteAll();
        return new ResponseEntity<>("All recipies have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/recipies/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        Optional<Recipe> recipeData = recipeRepository.findById(id);

        if (recipeData.isPresent()) {
            Recipe _recipe = recipeData.get();
            _recipe.setName(recipe.getName());
            _recipe.setVegetarian(recipe.isVegetarian());
            _recipe.setIngredients(recipe.getIngredients());
            _recipe.setDescription(recipe.getDescription());
            return new ResponseEntity<>(recipeRepository.save(_recipe), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}