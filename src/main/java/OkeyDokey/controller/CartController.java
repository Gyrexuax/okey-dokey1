package OkeyDokey.controller;

import OkeyDokey.constants.Pages;
import OkeyDokey.constants.PathConstants;
import OkeyDokey.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(PathConstants.CART)
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String getCart(Model model) {
        model.addAttribute("cloths", cartService.getClothInCart());
        return Pages.CART;
    }

    @PostMapping("/add")
    public String addClothToCart(@RequestParam("clothId") Long clothId) {
        cartService.addClothToCart(clothId);
        return "redirect:" + PathConstants.CART;
    }

    @PostMapping("/remove")
    public String removeClothFromCart(@RequestParam("clothId") Long clothId) {
        cartService.removeClothFromCart(clothId);
        return "redirect:" + PathConstants.CART;
    }
}
