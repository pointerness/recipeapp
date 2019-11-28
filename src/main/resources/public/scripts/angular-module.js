// Fix for unhandled rejections bug.
const app = angular.module('recipeAppModule', ['ui.bootstrap']);
app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.controller('RecipeAppController', function($http, $location, $uibModal, $scope) {
    $scope.modified=false;
    $scope.init = function () {
        $http.get('api/recipies').then(function (response){
            if(response){
                console.info('response :: '+response.data[0]);
                $scope.recipies = response.data;
                recipe1 = this.recipies[1];
            }
        },function (error) {
            $scope.responseMsg = "Service not Exists";
        });
    }

    $scope.saveRecipe = function(){
/*        var recipe = "{";
        recipe +=  "name:" + $scope.recipeName + ",";
        recipe +=  "ingredients:" +  $scope.ingredients + ",";
        recipe +=  "description:" + $scope.description + ",";
        recipe +=  "vegetarian:" + $scope.vegetarian + "";
        recipe += "";
        recipe += "}";*/
        if($scope.modified == false ){
             var recipe = {
                 name:  $scope.recipeName,
                 ingredients:   $scope.ingredients,
                 description:  $scope.description,
                 vegetarian:  $scope.vegetarian.toString()
            };

            console.info($scope.recipeName);
            $http.post("api/recipies/create",JSON.stringify(recipe)).then(function(response){
                //console.info(JSON.parse(response.data));
                $scope.init();
                $scope.modified=true;
                alert("Successfully  saved recipe " + response.data.name);
                $scope.recipe.id = response.data.id;
            },function(error){
                console.info("Failed Sav ing Recipe");
            });
        }else{
             var recipe = {
                 name:  $scope.recipeName,
                 ingredients:   $scope.ingredients,
                 description:  $scope.description,
                 vegetarian:  $scope.vegetarian.toString(),
                 id: $scope.recipe.id.id
            };

            console.info($scope.recipeName);
            $http.put("api/recipies/update/" + $scope.recipe.id.id,JSON.stringify(recipe)).then(function(response){
                //console.info(JSON.parse(response.data));
                $scope.init();
                $scope.modified=true;
                alert("Successfully  saved recipe " + response.data.name);

            },function(error){
                console.info("Failed Sav ing Recipe");
            });
        }
    }

    $scope.clearForm = function(){
        $scope.recipeName = null;
        $scope.description = null;
        $scope.vegetarian = null;
        $scope.ingredients = null;
        $scope.modified=false;
    }
    $scope.getRecipe = function(recipeId){
        console.info(recipeId);
        console.info($scope.recipeName);
        $http.get("api/recipies/" + recipeId.id).then(function(response){
            console.info(response.data);
            var recipe = response.data;
            setRecipeValues(recipe.name,recipe.description,recipe.vegetarian,recipe.ingredients);
            $scope.modified=true;
        },function(error){
            console.info("Failed to get the recipe");
            alert("Failed fetching the recipe");
        });

    }
    $scope.deleteRecipe = function(){
        if($scope.recipe.id){
        var recipeId = $scope.recipe.id.id;
        $http.delete("api/recipies/delete/" + recipeId).then(function(response){
            console.info(response.data);
            $scope.init();
            $scope.clearForm();
        },function(error){
            console.info("Failed to delete the recipe");
            alert("Failed deleting the recipe");
        });
        }
    }

    function setRecipeValues(name, description, vegetarian, ingredients){
        $scope.recipeName = name;
        $scope.description = description;
        $scope.vegetarian = vegetarian;
        $scope.ingredients = ingredients;
    }

});