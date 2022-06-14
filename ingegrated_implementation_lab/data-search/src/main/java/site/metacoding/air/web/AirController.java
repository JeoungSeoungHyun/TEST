package site.metacoding.air.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.air.domain.Air;
import site.metacoding.air.domain.AirRepository;

@RequiredArgsConstructor
@Controller
public class AirController {

    private final AirRepository airRepository;

    @GetMapping({ "/", "/weather" })
    public String info(@RequestParam(defaultValue = "") String gu, Model model) {
        List<Air> airs = null;
        if (gu.equals("")) {
            airs = airRepository.mFindByGu();
        } else {
            airs = airRepository.mFindByGu(gu);
        }
        model.addAttribute("data", airs);
        return "main";
    }
}
