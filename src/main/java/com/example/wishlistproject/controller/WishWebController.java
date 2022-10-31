package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.User;
import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.repository.WishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishWebController {

    private WishRepository wishRepository;


    public WishWebController(WishRepository p) {
        wishRepository = p;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("wishlists", wishRepository.getAllWishLists());
        return "html/index";
    }


    @GetMapping("/showWishlists")
    public String showWishLists(Model model) {
        model.addAttribute("wishlists", wishRepository.getAllWishLists());
        return "html/index";

    }


    @GetMapping("/showWishes/{id}")
    public String showWishes(@PathVariable("id") int id, Model model) {
        model.addAttribute("wishes", wishRepository.selectWishlist(id));
        return "html/wishlistWishes";
    }

    @GetMapping("/create")
    public String derp() {
        return null;
    }


    @PostMapping("/createwishlist")
    public String createWishlist(
        Model model,
        @RequestParam("wishlist_name") String wishlistName,
        @RequestParam("user_first_name") String userFirstName,
        @RequestParam("user_last_name") String userLastName) {
        model.addAttribute("wishlist_name", wishlistName);
        model.addAttribute("user_first_name", userFirstName);
        model.addAttribute("user_last_name", userLastName);

        User user = new User();
        Wishlist newWishlist = new Wishlist();

        user.setFirst_name(userFirstName);
        user.setLast_name(userLastName);

        int userId = wishRepository.findUserIdByName(user);
        if (userId == 0) {
            wishRepository.createUser(user);
            userId = wishRepository.findUserIdByName(user);

        }


        newWishlist.setWishlist_name(wishlistName);
        newWishlist.setWishlist_userId(userId);

        model.addAttribute("userId", userId);
        wishRepository.createWishlist(newWishlist);

        return "redirect:/";

    }


    //TODO RESERVE
    //TODO EDIT
    //TODO DELETE
    //TODO SHOWWISH/{WISHLIST}/{WISH}


}
