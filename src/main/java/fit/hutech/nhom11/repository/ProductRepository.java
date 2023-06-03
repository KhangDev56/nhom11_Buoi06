package fit.hutech.nhom11.repository;

import fit.hutech.nhom11.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{

}
