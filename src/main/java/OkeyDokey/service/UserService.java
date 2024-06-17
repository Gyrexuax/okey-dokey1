package OkeyDokey.service;

import OkeyDokey.domain.Order;
import OkeyDokey.domain.User;
import OkeyDokey.dto.request.ChangePasswordRequest;
import OkeyDokey.dto.request.EditUserRequest;
import OkeyDokey.dto.request.SearchRequest;
import OkeyDokey.dto.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getAuthenticatedUser();

    Page<Order> searchUserOrders(SearchRequest request, Pageable pageable);

    MessageResponse editUserInfo(EditUserRequest request);

    MessageResponse changePassword(ChangePasswordRequest request);
}
