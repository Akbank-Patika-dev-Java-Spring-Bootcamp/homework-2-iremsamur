package com.akbankbootcamp.ETradeBackend.controller.contract.impl;

import com.akbankbootcamp.ETradeBackend.controller.contract.UserControllerContract;
import com.akbankbootcamp.ETradeBackend.dao.UserRepository;
import com.akbankbootcamp.ETradeBackend.dto.user.UserDTO;
import com.akbankbootcamp.ETradeBackend.dto.user.UserSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.entity.User;
import com.akbankbootcamp.ETradeBackend.general.BusinessException;
import com.akbankbootcamp.ETradeBackend.mapper.UserMapper;
import com.akbankbootcamp.ETradeBackend.service.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserControllerContractImpl implements UserControllerContract {
    private final UserEntityService userEntityService;
    @Autowired
    public UserControllerContractImpl(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @Override
    public UserDTO add(UserSaveRequestDTO request) {
        User user = UserMapper.INSTANCE.convertToUser(request);
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public UserDTO update(UserSaveRequestDTO userSaveRequestDTO,Long userId) {
        User user = userEntityService.findById(userId).orElse(null);
        user.setName(userSaveRequestDTO.getName());
        user.setSurname(userSaveRequestDTO.getSurname());
        user.setBirthDate(userSaveRequestDTO.getBirthDate());
        user.setUsername(userSaveRequestDTO.getUsername());
        user.setPassword(userSaveRequestDTO.getPassword());
        user.setEmail(userSaveRequestDTO.getEmail());
        user.setPhoneNumber(userSaveRequestDTO.getPhoneNumber());
        user.setStatus(userSaveRequestDTO.getStatus());
        user = userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userEntityService.findById(id).orElse(null);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public boolean delete(String username, String phoneNumber) {

        User userByUsername = userEntityService.getUserRepository().findByUsername(username);
        User userByPhoneNumber = userEntityService.getUserRepository().findByPhoneNumber(phoneNumber);
        if(userByUsername.getId() == userByPhoneNumber.getId()){
            userEntityService.delete(userByUsername.getId());
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public UserDTO getByUserName(String username) {
        return null;
    }
}
