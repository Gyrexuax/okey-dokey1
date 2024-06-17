package OkeyDokey.service.impl;

import OkeyDokey.constants.ErrorMessage;
import OkeyDokey.constants.SuccessMessage;
import OkeyDokey.domain.Cloth;
import OkeyDokey.domain.Order;
import OkeyDokey.domain.User;
import OkeyDokey.dto.request.ClothRequest;
import OkeyDokey.dto.request.SearchRequest;
import OkeyDokey.dto.response.MessageResponse;
import OkeyDokey.dto.response.UserInfoResponse;
import OkeyDokey.repository.OrderRepository;
import OkeyDokey.repository.ClothRepository;
import OkeyDokey.repository.UserRepository;
import OkeyDokey.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Value("${upload.path}")
    private String uploadPath;

    private final UserRepository userRepository;
    private final ClothRepository clothRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<Cloth> getClothes(Pageable pageable) {
        return clothRepository.findAllByOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Cloth> searchClothes(SearchRequest request, Pageable pageable) {
        return clothRepository.searchClothes(request.getSearchType(), request.getText(), pageable);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchUsers(SearchRequest request, Pageable pageable) {
        return userRepository.searchUsers(request.getSearchType(), request.getText(), pageable);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.getById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ORDER_NOT_FOUND));
    }

    @Override
    public Page<Order> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);

    }

    @Override
    public Page<Order> searchOrders(SearchRequest request, Pageable pageable) {
        return orderRepository.searchOrders(request.getSearchType(), request.getText(), pageable);
    }

    @Override
    public Cloth getClothById(Long clothId) {
        return clothRepository.findById(clothId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.CLOTHES_NOT_FOUND));
    }

    @Override
    @SneakyThrows
    @Transactional
    public MessageResponse editCloth(ClothRequest clothRequest, MultipartFile file) {
        return saveCloth(clothRequest, file, SuccessMessage.CLOTH_EDITED);
    }

    @Override
    @SneakyThrows
    @Transactional
    public MessageResponse addCloth(ClothRequest clothRequest, MultipartFile file) {
        return saveCloth(clothRequest, file, SuccessMessage.CLOTH_ADDED);
    }

    @Override
    public UserInfoResponse getUserById(Long userId, Pageable pageable) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.USER_NOT_FOUND));
        Page<Order> orders = orderRepository.findOrderByUserId(userId, pageable);
        return new UserInfoResponse(user, orders);
    }

    private MessageResponse saveCloth(ClothRequest clothRequest, MultipartFile file, String message) throws IOException {
        Cloth cloth = modelMapper.map(clothRequest, Cloth.class);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            cloth.setFilename(resultFilename);
        }
        clothRepository.save(cloth);
        return new MessageResponse("alert-success", message);
    }
}
