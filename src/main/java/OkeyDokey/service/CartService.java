package OkeyDokey.service;

import OkeyDokey.domain.Cloth;

import java.util.List;

public interface CartService {

    List<Cloth> getClothInCart();

    void addClothToCart(Long clothId);

    void removeClothFromCart(Long clothId);
}
