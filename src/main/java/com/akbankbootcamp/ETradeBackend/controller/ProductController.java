package com.akbankbootcamp.ETradeBackend.controller;

import com.akbankbootcamp.ETradeBackend.controller.contract.ProductControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductControllerContract productControllerContract;
    @Autowired
    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }
    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> add(@RequestBody ProductSaveRequestDTO productSaveRequest) {
        var productDTO = productControllerContract.add(productSaveRequest);
        return ResponseEntity.ok(RestResponse.success(productDTO,"Ürün başarıyla eklendi."));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> update(@RequestBody String price,@PathVariable Long id) {
        var productDTO = productControllerContract.update(Double.parseDouble(price),id);
        return ResponseEntity.ok(RestResponse.success(productDTO,"Ürün başarıyla güncellendi"));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll() {
        var productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.emptySuccess("Ürün başarıyla silindi"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id) {
        var productDTO = productControllerContract.getById(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }



}
