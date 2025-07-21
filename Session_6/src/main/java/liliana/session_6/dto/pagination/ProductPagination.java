package liliana.session_6.dto.pagination;

import liliana.session_6.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class ProductPagination {
    private List<Product> products;
    private int totalPage;
    private int pageSize;
    private int currentPage;
}
