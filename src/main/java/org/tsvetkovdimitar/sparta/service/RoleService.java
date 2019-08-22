package org.tsvetkovdimitar.sparta.service;

import org.tsvetkovdimitar.sparta.domain.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);

}
