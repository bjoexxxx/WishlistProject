package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.User;
import com.example.wishlistproject.model.Wish;
import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WishWebController {

    @Autowired
    private WishRepository wishRepository;

    @Autowired
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
        model.addAttribute("wishListId", id);
        return "html/wishlistWishes";
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


        newWishlist.setName(wishlistName);
        newWishlist.setUserId(userId);

        model.addAttribute("userId", userId);
        wishRepository.createWishlist(newWishlist);

        return "redirect:/";

    }

    @PostMapping("/createWish")
    public String createWishPost(
            RedirectAttributes attributes,
            @RequestParam("name") String wishName,
            @RequestParam("price") double wishPrice,
            @RequestParam("wishListId") int id) {
        attributes.addAttribute("name", wishName);
        attributes.addAttribute("price", wishPrice);

        System.out.println(wishName + " " + wishPrice + " " + id);

        return "redirect:" + id;

    }

    @GetMapping("/createWish/{id}")
    public String createWish(
            Model model,
            @PathVariable("id") int id,
            @RequestParam("name") String wishName,
            @RequestParam("price") double wishPrice) {
        model.addAttribute("name", wishName);
        model.addAttribute("price", wishPrice);

        Wish wish = new Wish();

        wish.setName(wishName);
        wish.setPrice(wishPrice);

        wishRepository.createWish(wish,id);

        return "redirect:/showWishes/" + id ;
    }
    @GetMapping("/updateWish/{id}")
    public String updateWishGet(@PathVariable("id") int id,
                                Model model) {
        Wish wish = wishRepository.selectWish(id);
        model.addAttribute("wishId",id);
        model.addAttribute("name",wish.getName());
        model.addAttribute("price",wish.getPrice());

        return "html/updateWish";
    }

    @PostMapping("/updateWish")
    public String updateWishGet(@RequestParam("name") String name,
                                @RequestParam("price") double price,
                                @RequestParam("wishId") int wishId) {

        Wish wish = wishRepository.selectWish(wishId);

        wish.setWish_name(name);
        wish.setWish_price(price);
        wish.setWishID(wishId);

        wishRepository.updateWish(wish);

        int wishListId = wish.getWishlistID();

        return "redirect:/showWishes/" + wishListId;
    }



    @GetMapping("/deleteWishList/{id}")
    public String deleteWishList(@PathVariable("id") int id) {

        wishRepository.deleteWishList(id);

        return "redirect:/";
    }

    @GetMapping("/deleteWish/{id}")
    public String deleteWish(@PathVariable("id") int id){
        Wish wish = wishRepository.selectWish(id);

        int wishlistIDid = wish.getWishlistID();
        wishRepository.deleteWish(id);
        return "redirect:/showWishes/"+wishlistIDid;
    }


}
