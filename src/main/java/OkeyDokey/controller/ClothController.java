package OkeyDokey.controller;

import OkeyDokey.constants.Pages;
import OkeyDokey.constants.PathConstants;
import OkeyDokey.dto.request.SearchRequest;
import OkeyDokey.service.ClothService;
import OkeyDokey.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(PathConstants.CLOTH)
public class ClothController {

    private final ClothService clothService;
    private final ControllerUtils controllerUtils;

    @GetMapping("/{clothId}")
    public String getClothById(@PathVariable Long clothId, Model model) {
        model.addAttribute("cloth", clothService.getClothesById(clothId));
        return Pages.CLOTH;
    }

    @GetMapping
    public String getClothesByFilterParams(SearchRequest request, Model model, Pageable pageable) {
        controllerUtils.addPagination(request, model, clothService.getClothesByFilterParams(request, pageable));
        return Pages.CLOTHES;
    }

    @GetMapping("/search")
    public String searchClothes(SearchRequest request, Model model, Pageable pageable) {
        controllerUtils.addPagination(request, model, clothService.searchClothes(request, pageable));
        return Pages.CLOTHES;
    }
}
