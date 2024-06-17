package OkeyDokey.service;

import OkeyDokey.domain.Order;
import OkeyDokey.domain.Cloth;
import OkeyDokey.domain.User;
import OkeyDokey.dto.request.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    Order getOrder(Long orderId);

    List<Cloth> getOrdering();

    Page<Order> getUserOrdersList(Pageable pageable);

    Long postOrder(User user, OrderRequest orderRequest);
}
