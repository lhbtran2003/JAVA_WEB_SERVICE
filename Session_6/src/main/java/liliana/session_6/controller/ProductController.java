package liliana.session_6.controller;

import liliana.session_6.dto.pagination.ProductPagination;
import liliana.session_6.dto.response.DataResponse;
import liliana.session_6.entity.Product;
import liliana.session_6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // GET /products?search=&page=&size=&sort=
    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getAllProducts(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sortBy));
        ProductPagination result = productService.getAllProducts(pageable,search);
        DataResponse<List<Product>> dataResponse = DataResponse.<List<Product>>builder().key("products").data(result.getProducts()).build();
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<DataResponse<Product>> createProduct(@RequestBody Product product) {
       DataResponse<Product> dataResponse = DataResponse.<Product>builder().key("product").data(productService.createProduct(product)).build();
        return new ResponseEntity<>(dataResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        DataResponse<Product> dataResponse = DataResponse.<Product>builder().key("product").data(productService.createProduct(product)).build();

        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

