package com.akbankbootcamp.ETradeBackend.service.entityservice;

import com.akbankbootcamp.ETradeBackend.dao.UserRepository;
import com.akbankbootcamp.ETradeBackend.entity.User;
import com.akbankbootcamp.ETradeBackend.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;




@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{

    private UserRepository repository;

    @Autowired
    public UserEntityService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public UserRepository getUserRepository() {
        return repository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }


}
