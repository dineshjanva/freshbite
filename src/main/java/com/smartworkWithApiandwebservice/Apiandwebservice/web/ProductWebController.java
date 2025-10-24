package com.smartworkWithApiandwebservice.Apiandwebservice.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.ProductRepository;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.bind.annotation.RequestMethod;
// import java.util.List;
// import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("products")
public class ProductWebController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "allproduct";    
    }

    @GetMapping("create")
    public String showform(Model model) {
        //TODO: process POST request
        model.addAttribute("product",new Product());

        return "createproduct";
    }

    
@PostMapping("/save")
public String save(@ModelAttribute Product product) throws IOException {

    MultipartFile file = product.getFile();
    if (file != null && !file.isEmpty()) {
        // Get original extension
        String originalFilename = file.getOriginalFilename();
        String extension = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        // Create new file name (e.g., "product-<timestamp>.ext")
        String newFileName = "product-" + System.currentTimeMillis() + extension;

        // Path to save
        Path uploadPath = Paths.get("src/main/resources/static/uploads/");
        Files.createDirectories(uploadPath); // create folder if not exists

        // Copy file to folder
        Files.copy(file.getInputStream(), uploadPath.resolve(newFileName));

        // Save new file name in DB
        product.setImage(newFileName);
    }

    productService.save(product);

    return "redirect:/products";
}




    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        System.out.println(id);
        //TODO: process POST request
        productRepository.deleteById(id);
        return "redirect:/products";
    }
    
    
    
}
