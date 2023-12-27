package com.example.demo.controller;

import com.example.demo.dto.PageDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductsService;
import com.example.demo.service.impl.ProductsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor //антоция к классу контроллер
@RestController
@RequestMapping("/reservation") // логика перехода по адресу (endpoint)
public class ProductsController { //за все api методы

    private ProductsService productsService; //сервис
    private final ModelMapper modelMapper = new ModelMapper(); //маппер

    @GetMapping("/{id}") //метод get(получить по id)
    public Product getProductById(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @GetMapping //метод get(весь список продуктов)
    public Page<Product> getProducts(PageDto pageDto) {
        return productsService.getProducts(pageDto.getPageable());
    }

    @PostMapping //метод post(добавляет новый продукт)
    public Product addProduct(@RequestBody ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return productsService.addProduct(product); //добавляет в сервис
    }

    @PutMapping("/{id}") //метод put(изменить продукт по id)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}") //метод delete(удаляет продукт по id)
    public void deleteProductById(@PathVariable Long id) {
        productsService.deleteProductById(id);
    }

}
