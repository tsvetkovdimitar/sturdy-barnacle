package org.tsvetkovdimitar.sparta.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tsvetkovdimitar.sparta.domain.models.binding.UserRegisterBindingModel;
import org.tsvetkovdimitar.sparta.domain.models.service.UserServiceModel;
import org.tsvetkovdimitar.sparta.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register(){

        return super.view("register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel){

        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

            return super.view("register");

        }

        this.userService.registerUser(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return super.redirect("/login");

    }

    @GetMapping("/teacher")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerTeacher(){

        return super.view("teacher");
    }

    @PostMapping("/teacher")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerTeacherConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel){

        if(!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){

            return super.view("teacher");

        }

        this.userService.registerUser(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return super.redirect("/login");

    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login(){

        return super.view("login");

    }

}
