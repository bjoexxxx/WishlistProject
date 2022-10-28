package com.example.wishlistproject.controller;

import com.example.wishlistproject.repository.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WishWebController {

    private WishRepository wishRepository;


    public WishWebController(WishRepository p) {
        wishRepository = p;
    }

    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("wishlists",wishRepository.getAll());
        return "html/index";
    }


    @GetMapping("/showWishlists")
    public String showWishLists (Model model) {
        model.addAttribute("wishlists",wishRepository.getAll());
        return "html/index";

    }
    @GetMapping("/showWishes/{id}")
    public String showWishes (@PathVariable("id") int id, Model model) {
        model.addAttribute("wishes", wishRepository.findWishesById(id));

        return "html/wishlistWishes";

    }





}
