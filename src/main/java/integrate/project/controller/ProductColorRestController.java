package integrate.project.controller;

import integrate.project.models.Productcolor;
import integrate.project.repositories.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductColorRestController {

    @Autowired
    ProductColorRepository productColorRepository;

    @GetMapping("/showproductcolor")
    public List<Productcolor> allProductcolor(@RequestParam(defaultValue = "0") Integer pageNo,
                                         @RequestParam(defaultValue = "50") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Productcolor> pageResult = productColorRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/showproductcolor/{id}")
    public Productcolor showProductcolor(@PathVariable Long id) {
        return productColorRepository.findById(id).orElse(null);
    }

    @PostMapping("/addproductcolor")
    public void addProductcolor(@RequestBody Productcolor productcolor){
        productColorRepository.save(productcolor);
    }
}