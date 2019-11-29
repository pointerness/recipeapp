package com.assesment.recipeapp.demo;

import com.assesment.recipeapp.demo.controller.RecipeController;
import com.assesment.recipeapp.demo.model.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders.;

import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(RecipeController.class)
@AutoConfigureMockMvc
public class RecipeControllerTest  {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RecipeController recipeController;

    @Test
    public void givenGenericRecipe_whenGetAll_thenOK( ) throws Exception{
        Recipe recipe = new Recipe();
        recipe.setName("idli");
        List<Recipe> allRecipies =  Collections.singletonList(recipe);
        given(recipeController.getAllRecipies()).willReturn(allRecipies);
        //MockMvcRequestBuilders
        mvc.perform(MockMvcRequestBuilders.get("/api/recipies")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    public void givenGenericRecipeRepository_whenGetRecipeByIdThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenUpdateThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenDeleteByidThenOK()throws Exception{

    }

    public void givenGenericRecipeRepository_whenDeleteAllThenOK()throws Exception{

    }
}
