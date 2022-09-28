package recipes.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistance.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe findRecipeById(Long id) {
        Optional<Recipe> receivedRecipe = recipeRepository.findById(id);
        return recipeRepository.findRecipeById(id);
    }

    public boolean existsRecipe(Long id) {
        return recipeRepository.existsById(id);
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe save(Recipe toSave) {
        return recipeRepository.save(toSave);
    }
}
