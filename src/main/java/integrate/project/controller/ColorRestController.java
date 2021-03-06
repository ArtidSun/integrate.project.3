package integrate.project.controller;

import integrate.project.models.Brand;
import integrate.project.models.Color;
import integrate.project.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ColorRestController {
    @Autowired
    ColorRepository colorRepository;

    @GetMapping("/showallcolor")
    public List<Color> showBrand(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "50") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Color> pageResult = colorRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/showcolorbyid/{id}")
    public Color showById(@PathVariable long id){
        return colorRepository.findById(id).orElse(null);
    }
}
