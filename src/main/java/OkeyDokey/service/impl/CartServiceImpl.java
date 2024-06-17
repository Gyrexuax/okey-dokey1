package OkeyDokey.service.impl;

import OkeyDokey.domain.Cloth;
import OkeyDokey.domain.User;
import OkeyDokey.repository.ClothRepository;
import OkeyDokey.service.CartService;
import OkeyDokey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final UserService userService;
    private final ClothRepository clothRepository;

    @Override
    public List<Cloth> getClothInCart() {
        User user = userService.getAuthenticatedUser();
        return user.getClothList();
    }

    @Override
    @Transactional
    public void addClothToCart(Long ClothId) {
        User user = userService.getAuthenticatedUser();
        Cloth cloth = clothRepository.getOne(ClothId);
        user.getClothList().add(cloth);
    }

    @Override
    @Transactional
    public void removeClothFromCart(Long ClothId) {
        User user = userService.getAuthenticatedUser();
        Cloth cloth = clothRepository.getOne(ClothId);
        user.getClothList().remove(cloth);
    }
}
