package OkeyDokey.service.impl;

import OkeyDokey.constants.ErrorMessage;
import OkeyDokey.domain.Cloth;
import OkeyDokey.dto.request.SearchRequest;
import OkeyDokey.repository.ClothRepository;
import OkeyDokey.service.ClothService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothServiceImpl implements ClothService {

    private final ClothRepository clothRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cloth getClothesById(Long clothId) {
        return clothRepository.findById(clothId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.CLOTHES_NOT_FOUND));
    }

    @Override
    public List<Cloth> getPopularClothes() {
        List<Long> clothIds = Arrays.asList(26L, 43L, 46L, 75L, 34L, 7L, 15L, 61L, 27L, 39L, 71L, 11L);
        return clothRepository.findByIdIn(clothIds);
    }

    @Override
    public Page<Cloth> getClothesByFilterParams(SearchRequest request, Pageable pageable) {
        Integer startingPrice = request.getPrice();
        Integer endingPrice = startingPrice + (startingPrice == 0 ? 500 : 50);
        return clothRepository.getClothesByFilterParams(
                request.getClothers(),
                request.getGenders(),
                startingPrice,
                endingPrice,
                pageable);
    }

    @Override
    public Page<Cloth> searchClothes(SearchRequest request, Pageable pageable) {
        return clothRepository.searchClothes(request.getSearchType(), request.getText(), pageable);
    }
}
