package site.metacoding.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.board.domain.BoardTbl;
import site.metacoding.board.service.BoardTblService;

@RequiredArgsConstructor
@Controller
public class BoardTblController {

    private final BoardTblService boardTblService;

    @GetMapping("/")
    public String home(Model model, String keyword) {

        if (keyword == null) {
            List<BoardTbl> boards = boardTblService.글검색("");
            model.addAttribute("boards", boards);

        } else {
            List<BoardTbl> boards = boardTblService.글검색(keyword);
            model.addAttribute("boards", boards);
        }
        return "list";
    }

}
