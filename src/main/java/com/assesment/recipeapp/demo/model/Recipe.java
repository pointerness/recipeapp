package com.assesment.recipeapp.demo.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;



    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name="ingredients")
    private String ingredients;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name="recipe_image")
    private byte[] recipeImage;

    public Recipe() {
    }

    public Recipe(String name, boolean calories, String ingredients, String description) {
        this.name = name;
        this.vegetarian = calories;
        this.ingredients = ingredients;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        recipeImage = recipeImage;
    }
}
