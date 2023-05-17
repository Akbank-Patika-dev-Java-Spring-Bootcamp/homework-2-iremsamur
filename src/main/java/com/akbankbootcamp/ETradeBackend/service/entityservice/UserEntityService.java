package com.akbankbootcamp.ETradeBackend.service.entityservice;

import com.akbankbootcamp.ETradeBackend.dao.UserRepository;
import com.akbankbootcamp.ETradeBackend.entity.User;
import com.akbankbootcamp.ETradeBackend.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{
    private UserRepository userRepository;

    @Autowired
    public UserEntityService(UserRepository repository) {
        super(repository);
    }
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
