package liliana.session_8.service;

import liliana.session_8.dto.request.DishDTO;
import liliana.session_8.dto.response.ApiResponse;
import liliana.session_8.entity.Dish;
import liliana.session_8.exception.BadRequestException;
import liliana.session_8.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepo;
    private final CloudinaryService cloudinaryService;

    public ApiResponse<List<Dish>> getAllDishes() {
        List<Dish> dishes = dishRepo.findAll();
        return ApiResponse.<List<Dish>>builder()
                .status(true)
                .message("Lấy danh sách món ăn thành công")
                .data(dishes)
                .build();
    }

    public ApiResponse<Dish> getDishById(Long id) {
        return dishRepo.findById(id)
                .map(dish -> ApiResponse.<Dish>builder()
                        .status(true)
                        .message("Tìm thấy món ăn")
                        .data(dish)
                        .build())
                .orElse(ApiResponse.<Dish>builder()
                        .status(false)
                        .message("Không tìm thấy món ăn có id = " + id)
                        .data(null)
                        .build());
    }

    public ApiResponse<Dish> addDish(DishDTO request)  {
        Dish newDish = new Dish();

        newDish.setName(request.getName());
        newDish.setPrice(request.getPrice());
        newDish.setDescription(request.getDescription());
        newDish.setStatus(request.getStatus()); // khúc này mốt tạo 1 enum Status riêng rồi gán mặc định
        MultipartFile file = request.getImage();
        if (file != null && !file.isEmpty()) {
            newDish.setImage(cloudinaryService.uploadImage(file));
        }

        return ApiResponse.<Dish>builder()
                .status(true)
                .message("Thêm món ăn thành công")
                .data(dishRepo.save(newDish))
                .build();
    }

    public ApiResponse<Dish> updateDish(Long id, DishDTO dish){
        if (!dishRepo.existsById(id)) {
            return ApiResponse.<Dish>builder()
                    .status(false)
                    .message("Không tìm thấy món ăn để cập nhật")
                    .data(null)
                    .build();
        }
        Dish updateDish = dishRepo.findById(id).get();
        updateDish.setName(dish.getName());
        updateDish.setPrice(dish.getPrice());
        updateDish.setDescription(dish.getDescription());
        updateDish.setStatus(dish.getStatus());
        MultipartFile file = dish.getImage();
        if (file != null && !file.isEmpty()) {
            updateDish.setImage(cloudinaryService.uploadImage(file));
        }

        dish.setId(id);
        return ApiResponse.<Dish>builder()
                .status(true)
                .message("Cập nhật thành công")
                .data(dishRepo.save(updateDish))
                .build();
    }

    public ApiResponse<Void> deleteDish(Long id) {
        if (!dishRepo.existsById(id)) {
            return ApiResponse.<Void>builder()
                    .status(false)
                    .message("Không tìm thấy món ăn để xóa")
                    .build();
        }
        dishRepo.deleteById(id);
        return ApiResponse.<Void>builder()
                .status(true)
                .message("Xóa thành công")
                .build();
    }
}
