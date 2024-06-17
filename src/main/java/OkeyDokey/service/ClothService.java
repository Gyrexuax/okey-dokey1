package OkeyDokey.service;

import OkeyDokey.domain.Cloth;
import OkeyDokey.dto.request.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothService {

    Cloth getClothesById(Long clothId);

    List<Cloth> getPopularClothes();

    Page<Cloth> getClothesByFilterParams(SearchRequest searchRequest, Pageable pageable);

    Page<Cloth> searchClothes(SearchRequest searchRequest, Pageable pageable);
}
