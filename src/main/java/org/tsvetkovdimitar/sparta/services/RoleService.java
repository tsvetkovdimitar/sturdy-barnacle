package org.tsvetkovdimitar.sparta.services;

import org.tsvetkovdimitar.sparta.domain.models.service.RoleServiceModel;
import org.tsvetkovdimitar.sparta.domain.models.service.UserServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

   // void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers);

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);

}
