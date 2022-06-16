package site.metacoding.hospital;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.hospital.domain.Hospital;
import site.metacoding.hospital.domain.HospitalRespository;

@RequiredArgsConstructor
@Controller
public class HospitalController {

    private final HospitalRespository hospitalRespository;

    @GetMapping("/download")
    public String download() {
        RestTemplate rt = new RestTemplate();

        Hospital[] response = rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구",
                Hospital[].class);

        List<Hospital> hospitals = Arrays.asList(response);

        hospitalRespository.saveAll(hospitals);

        return "download";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<Hospital> hospitals = hospitalRespository.findAll();

        model.addAttribute("hospitals", hospitals);

        return "list";
    }
}
