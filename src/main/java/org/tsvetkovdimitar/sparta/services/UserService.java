package org.tsvetkovdimitar.sparta.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.tsvetkovdimitar.sparta.domain.models.service.UserServiceModel;

public interface UserService extends UserDetailsService {

        UserServiceModel registerUser(UserServiceModel userServiceModel);

}
