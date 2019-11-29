package com.assesment.recipeapp.demo;

import com.assesment.recipeapp.demo.model.Recipe;
import com.assesment.recipeapp.demo.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeDatabaseTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void givenGenericRecipeRepository_whenSaveAndRetreiveRecipeByNamethenOK( ) throws Exception{
        //given
        Recipe idliRecipe = new Recipe();
        idliRecipe.setName("idli");
        recipeRepository.save(idliRecipe);
        Recipe foundIdliRecipe = recipeRepository.findByName("idli").get(0);
        assert(idliRecipe.getName().equals(foundIdliRecipe.getName()));
    }

    public void givenGenericRecipeRepository_whenSaveAndRetreiveRecipeByIdThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenSaveAndRetreiveAllThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenSaveRetreiveAndUpdateThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenSaveRetreiveAndDeleteByidThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenSaveRetreiveAndDeleteAllThenOK()throws Exception{

    }
}
