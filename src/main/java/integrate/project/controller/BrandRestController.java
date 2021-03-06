package integrate.project.controller;

import integrate.project.models.Brand;
import integrate.project.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandRestController {
    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/showbrand")
    public List<Brand> showBrand(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "50") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Brand> pageResult = brandRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/showbrand/{id}")
    public Brand showById(@PathVariable long id){
        return brandRepository.findById(id).orElse(null);
    }
}
