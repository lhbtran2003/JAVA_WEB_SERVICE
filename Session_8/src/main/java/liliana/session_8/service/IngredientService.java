package liliana.session_8.service;


import liliana.session_8.dto.request.IngredianDto;
import liliana.session_8.dto.response.ApiResponse;
import liliana.session_8.entity.Dish;
import liliana.session_8.entity.Ingredient;
import liliana.session_8.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final CloudinaryService cloudinaryService;

    public ApiResponse<List<Ingredient>> getAlles() {
        List<Ingredient> dishes = ingredientRepository.findAll();
        return ApiResponse.<List<Ingredient>>builder()
                .status(true)
                .message("Lấy danh sách món ăn thành công")
                .data(dishes)
                .build();
    }

    public ApiResponse<Ingredient> getById(Long id) {
        return ingredientRepository.findById(id)
                .map(dish -> ApiResponse.<Ingredient>builder()
                        .status(true)
                        .message("Tìm thấy món ăn")
                        .data(dish)
                        .build())
                .orElse(ApiResponse.<Ingredient>builder()
                        .status(false)
                        .message("Không tìm thấy món ăn có id = " + id)
                        .data(null)
                        .build());
    }

    public ApiResponse<Ingredient> add(IngredianDto request)  {
        Ingredient newIngredient = new Ingredient();

        newIngredient.setName(request.getName());
        newIngredient.setStock(request.getStock());
        newIngredient.setExpiry(request.getExpiry());

        MultipartFile file = request.getImage();
        if (file != null && !file.isEmpty()) {
            newIngredient.setImage(cloudinaryService.uploadImage(file));
        }

        return ApiResponse.<Ingredient>builder()
                .status(true)
                .message("Thêm món ăn thành công")
                .data(ingredientRepository.save(newIngredient))
                .build();
    }

    public ApiResponse<Ingredient> update(Long id, IngredianDto dish){
        if (!ingredientRepository.existsById(id)) {
            return ApiResponse.<Ingredient>builder()
                    .status(false)
                    .message("Không tìm thấy món ăn để cập nhật")
                    .data(null)
                    .build();
        }
         Ingredient ingredientUpdate = ingredientRepository.findById(id).get();
        ingredientUpdate.setName(dish.getName());
        ingredientUpdate.setStock(dish.getStock());
        ingredientUpdate.setExpiry(dish.getExpiry());

        MultipartFile file = dish.getImage();
        if (file != null && !file.isEmpty()) {
            ingredientUpdate.setImage(cloudinaryService.uploadImage(file));
        }

        dish.setId(id);
        return ApiResponse.<Ingredient>builder()
                .status(true)
                .message("Cập nhật thành công")
                .data(ingredientRepository.save(ingredientUpdate))
                .build();
    }

    public ApiResponse<Void> delete(Long id) {
        if (!ingredientRepository.existsById(id)) {
            return ApiResponse.<Void>builder()
                    .status(false)
                    .message("Không tìm thấy món ăn để xóa")
                    .build();
        }
        ingredientRepository.deleteById(id);
        return ApiResponse.<Void>builder()
                .status(true)
                .message("Xóa thành công")
                .build();
    }
}
