package liliana.session_6.controller;

import jakarta.servlet.http.HttpSession;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.entity.ProductCart;
import liliana.session_6.entity.User;
import liliana.session_6.service.ProductCartService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ProductCartController {
    private final ProductCartService productCartService;

    @GetMapping
    public ResponseEntity<DataResponse<List<ProductCart>>> getProductCart(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new ResponseEntity<>(DataResponse
                .<List<ProductCart>>builder()
                .key("productCart")
                .data(productCartService.getCartItemsByUser(user))
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<ProductCart>> addProductCart( @RequestBody ProductCart productCart) {
        return new ResponseEntity<>(DataResponse
                .<ProductCart>builder()
                .key("productCart")
                .data(productCartService.addToCart(productCart))
                .build(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<ProductCart>> updateProductCart( @PathVariable Long id, @RequestBody Integer quantity) {
        return new ResponseEntity<>(DataResponse
                .<ProductCart>builder()
                .key("productCart")
                .data(productCartService.updateQuantity(id,quantity))
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCart( @PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
