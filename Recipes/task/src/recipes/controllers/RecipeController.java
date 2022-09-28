package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.dto.BookOfRecipes;
import recipes.dto.Recipe;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private BookOfRecipes bookOfRecipe = new BookOfRecipes(new HashMap<>());
    private static int id = 0;

    @GetMapping("/recipes")
    public Map<Integer, Recipe> getRecipes() {
        return bookOfRecipe.getRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> returnRecipe(@PathVariable int id) {
        if (bookOfRecipe.getRecipes().containsKey(id)) {
            return new ResponseEntity<>(bookOfRecipe.getRecipes().get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new")
    public Map<String, Integer> addRecipe(@RequestBody Recipe recipe) {
        Map<String, Integer> jsonObject = new HashMap<>();
        bookOfRecipe.getRecipes().put(++id, recipe);
        jsonObject.put("id", id);
        return jsonObject;
    }
}
