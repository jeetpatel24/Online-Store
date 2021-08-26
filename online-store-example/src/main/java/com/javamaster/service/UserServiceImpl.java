package com.javamaster.service;

import com.javamaster.entity.UserEntity;
import com.javamaster.entity.UserRole;
import com.javamaster.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.javamaster.entity.UserRole.*;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;

    @Override
    public UserEntity findOrCreateUser(String name, String surname, String email, String phone, String address) {
        UserEntity userEntity = userEntityRepository.findByEmail(email);
        if(nonNull(userEntity)) {
            return userEntity;
        }
        userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setSurname(surname);
        userEntity.setEmail(email);
        userEntity.setPhone(phone);
        userEntity.setRole(CUSTOMER.name());
        userEntity.setAddress(address);

        userEntityRepository.save(userEntity);
        return userEntity;
    }
}
