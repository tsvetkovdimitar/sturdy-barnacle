package org.tsvetkovdimitar.sparta.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsvetkovdimitar.sparta.domain.entities.Role;
import org.tsvetkovdimitar.sparta.domain.models.service.RoleServiceModel;
import org.tsvetkovdimitar.sparta.domain.models.service.UserServiceModel;
import org.tsvetkovdimitar.sparta.repository.RoleRepository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRolesInDb() {

        if(this.roleRepository.count() == 0){

            this.roleRepository.saveAndFlush(new Role("ROLE_ADMIN"));

        }

            this.roleRepository.saveAndFlush(new Role("ROLE_USER"));
    }

//    @Override
//    public void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers) {
//
//        if(numberOfUsers == 0){
//
//            userServiceModel
//                    .setAuthorities(this.roleRepository
//                            .findAll()
//                            .stream()
//                            .map(r -> this.modelMapper.map(r, RoleServiceModel.class))
//                            .collect(Collectors.toSet()));
//
//        }
//
//    }


    @Override
    public Set<RoleServiceModel> findAllRoles() {

        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, RoleServiceModel.class)).collect(Collectors.toSet());

    }

    @Override
    public RoleServiceModel findByAuthority(String authority){

        return this.modelMapper.map(authority, RoleServiceModel.class);
    }
}
