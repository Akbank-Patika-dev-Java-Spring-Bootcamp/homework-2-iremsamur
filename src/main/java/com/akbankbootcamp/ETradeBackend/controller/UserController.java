package com.akbankbootcamp.ETradeBackend.controller;

import com.akbankbootcamp.ETradeBackend.controller.contract.ProductControllerContract;
import com.akbankbootcamp.ETradeBackend.controller.contract.UserControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.general.RestResponse;
import com.akbankbootcamp.ETradeBackend.general.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserControllerContract userControllerContract;
    @Autowired
    public UserController(UserControllerContract userControllerContract) {
        this.userControllerContract = userControllerContract;
    }

    @ExceptionHandler
    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> add(@RequestBody UserSaveRequestDTO userSaveRequest) {
        try {
            var userDTO = userControllerContract.add(userSaveRequest);
            return ResponseEntity.ok(RestResponse.success(userDTO,"Kullanıcı başarıyla eklendi."));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @ExceptionHandler
    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> update(@RequestBody UserSaveRequestDTO userSaveRequestDTO,@PathVariable Long id) {
        var userDTO = userControllerContract.update(userSaveRequestDTO,id);
        return ResponseEntity.ok(RestResponse.success(userDTO,"Kullanıcı başarıyla güncellendi"));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable String username,@RequestBody String phoneNumber) {
        try {
            userControllerContract.delete(username,phoneNumber);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı başarıyla silindi"));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id) {
        var userDTO = userControllerContract.getById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }



}
