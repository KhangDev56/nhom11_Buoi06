package fit.hutech.nhom11.service;

import fit.hutech.nhom11.model.Product;
import fit.hutech.nhom11.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository repo;

    public List<Product> GetAll()
    {
        return repo.findAll();
    }

    public Product getProductByID(int id)
    {
        Optional<Product> optionalBook = repo.findById(id);
        return optionalBook.orElse(null);
    }
    public void add(Product newProduct)
    {
        repo.save(newProduct);
    }
    public void update(Product newProduct)
    {
        repo.save(newProduct);
    }
    public void delete(int  id)
    {
        repo.deleteById(id);
    }
}
