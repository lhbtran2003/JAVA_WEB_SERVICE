package liliana.session_8.controller;

import liliana.session_8.dto.request.DishDTO;
import liliana.session_8.dto.request.IngredianDto;
import liliana.session_8.dto.response.ApiResponse;
import liliana.session_8.entity.Dish;
import liliana.session_8.entity.Ingredient;
import liliana.session_8.exception.BadRequestException;
import liliana.session_8.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Ingredient>>> getAllIngredientes() {
        return new ResponseEntity<>(ingredientService.getAlles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Ingredient>> addIngredient(@RequestBody IngredianDto ingredianDto) throws BadRequestException {
        return new ResponseEntity<>(ingredientService.add(ingredianDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Ingredient>> updateIngredient(@RequestParam long id, @RequestBody IngredianDto ingredianDto) throws BadRequestException {
        return new ResponseEntity<>(ingredientService.update(id, ingredianDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Ingredient>> deleteIngredient(@PathVariable long id) {
        ingredientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
