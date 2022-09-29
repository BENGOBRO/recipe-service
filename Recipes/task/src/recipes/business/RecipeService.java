package recipes.business;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistance.RecipeRepository;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public Recipe findRecipeById(Long id) {
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
