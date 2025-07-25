package liliana.session_8.controller;

import liliana.session_8.dto.request.DishDTO;
import liliana.session_8.dto.response.ApiResponse;
import liliana.session_8.entity.Dish;
import liliana.session_8.exception.BadRequestException;
import liliana.session_8.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public  ResponseEntity<ApiResponse<List<Dish>>> getAllDishes() {
        return new ResponseEntity<>(dishService.getAllDishes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Dish>> addDish(@RequestBody DishDTO dish) throws BadRequestException {
        return new ResponseEntity<>(dishService.addDish(dish), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Dish>> updateDish(@RequestParam long id,@RequestBody DishDTO dish) throws BadRequestException {
        return new ResponseEntity<>(dishService.updateDish(id, dish), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Dish>> deleteDish(@PathVariable long id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
