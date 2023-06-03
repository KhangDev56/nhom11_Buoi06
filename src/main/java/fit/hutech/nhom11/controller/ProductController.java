package fit.hutech.nhom11.controller;

import fit.hutech.nhom11.model.Product;
import fit.hutech.nhom11.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model)
    {
        model.addAttribute("listProduct", productService.GetAll());
        return "products/index";
    }

    @GetMapping("/create")
    public String createModelForm (Model model)
    {
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product )
    {
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") int id, Model model)
    {
        Product editProduct = productService.getProductByID(id);
        if(editProduct != null){
            model.addAttribute("product", editProduct);
            return "products/edit";
        }else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("product") Product updateProcudt )
    {
        productService.GetAll().stream()
                .filter(product -> product.getId() == updateProcudt.getId())
                .findFirst()
                .ifPresent(product -> {
                    productService.update(updateProcudt);
                });
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id)
    {
        productService.delete(id);
        return "redirect:/products";
    }
}
