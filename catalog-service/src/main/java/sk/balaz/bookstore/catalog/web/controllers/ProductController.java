package sk.balaz.bookstore.catalog.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.balaz.bookstore.catalog.domain.PagedResult;
import sk.balaz.bookstore.catalog.domain.Product;
import sk.balaz.bookstore.catalog.domain.ProductNotFoundException;
import sk.balaz.bookstore.catalog.domain.ProductService;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getAllProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProduct(@PathVariable String code) {
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }
}
