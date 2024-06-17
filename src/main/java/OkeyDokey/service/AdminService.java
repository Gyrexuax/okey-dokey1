package OkeyDokey.service;

import OkeyDokey.domain.Order;
import OkeyDokey.domain.Cloth;
import OkeyDokey.domain.User;
import OkeyDokey.dto.request.ClothRequest;
import OkeyDokey.dto.request.SearchRequest;
import OkeyDokey.dto.response.MessageResponse;
import OkeyDokey.dto.response.UserInfoResponse;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {

    Page<Cloth> getClothes(Pageable pageable);

    Page<Cloth> searchClothes(SearchRequest request, Pageable pageable);

    Page<User> getUsers(Pageable pageable);

    Page<User> searchUsers(SearchRequest request, Pageable pageable);

    Order getOrder(Long orderId);

    Page<Order> getOrders(Pageable pageable);

    Page<Order> searchOrders(SearchRequest request, Pageable pageable);

    Cloth getClothById(Long ClothId);

    @SneakyThrows
    @Transactional
    MessageResponse editCloth(ClothRequest clothRequest, MultipartFile file);

    @SneakyThrows
    @Transactional
    MessageResponse addCloth(ClothRequest clothRequest, MultipartFile file);

    UserInfoResponse getUserById(Long userId, Pageable pageable);
}
