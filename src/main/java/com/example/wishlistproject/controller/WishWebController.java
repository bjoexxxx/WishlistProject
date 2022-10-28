package com.example.wishlistproject.controller;

import com.example.wishlistproject.repository.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishWebController {

    private WishRepository wishRepository;


    public WishWebController(WishRepository p) {
        wishRepository = p;
    }

    @GetMapping("/")
    public String showIndex(){
        return "html/index";
    }

    @GetMapping("/showWishLists")
    public String showWishLists () {

        return "";

    }





}
