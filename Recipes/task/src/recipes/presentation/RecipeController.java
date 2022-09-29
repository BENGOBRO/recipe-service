package recipes.presentation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

//    @GetMapping("/recipes")
//    public Map<Integer, Recipe> getRecipes() {
//        return bookOfRecipe.getRecipes();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable long id) {
        if (recipeService.existsRecipe(id)) {
            return new ResponseEntity<>(recipeService.findRecipeById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public Map<String, Long> addRecipe(@Valid @RequestBody Recipe recipe) {
        Long id = recipeService.save(recipe).getId();
        return Collections.singletonMap("id", id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable long id) {
        if (recipeService.existsRecipe(id)) {
            recipeService.deleteRecipeById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
