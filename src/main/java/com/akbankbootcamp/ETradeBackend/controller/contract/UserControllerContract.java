package com.akbankbootcamp.ETradeBackend.controller.contract;

import com.akbankbootcamp.ETradeBackend.dto.product.ProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.product.ProductSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.entity.User;

import java.util.List;

public interface UserControllerContract {
    UserDTO add(UserSaveRequestDTO request);
    UserDTO update(UserSaveRequestDTO userSaveRequestDTO,Long userId);

    List<UserDTO> findAll();
    UserDTO getById(Long id);

    void delete(String username,String phoneNumber);
    UserDTO getByUserName(String username);
    UserDTO getByPhoneNumber(String phoneNumber);
    UserDTO getByEmail(String email);
}
