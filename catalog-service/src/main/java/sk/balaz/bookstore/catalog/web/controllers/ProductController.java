package sk.balaz.bookstore.catalog.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.balaz.bookstore.catalog.domain.PagedResult;
import sk.balaz.bookstore.catalog.domain.ProductEntity;
import sk.balaz.bookstore.catalog.domain.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<ProductEntity> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getAllProducts(pageNo);
    }
}
