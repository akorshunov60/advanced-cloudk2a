package com.example.cloud.product;

import com.example.cloud.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private static final Function<Product, ProductDto> mapper = p ->
            new ProductDto(p.getId(), p.getTitle(), p.getPrice());

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ProductDto> findAll() {
        return productService.findAll().stream().map(mapper).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return mapper.apply(productService.findById(id).orElseThrow());
    }
}
