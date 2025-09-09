package inventory.service;

import inventory.model.Product;
import inventory.repository.Repository;
import inventory.utils.GenericSearch;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InventoryService {
    private final Repository<Product, String> repo;

    public InventoryService(Repository<Product, String> repo) {
        this.repo = repo;
    }

    public boolean addProduct(Product p) {
        if (repo.findById(p.getCode()).isPresent()) return false;
        repo.save(p);
        return true;
    }

    public boolean updateProduct(Product p) {
        if (repo.findById(p.getCode()).isEmpty()) return false;
        repo.save(p);
        return true;
    }

    public boolean deleteProduct(String code) {
        return repo.deleteById(code);
    }

    public Optional<Product> findByCode(String code) {
        return repo.findById(code);
    }

    public List<Product> listAll() {
        List<Product> list = repo.findAll();
        GenericSearch.sort(list, Comparator.comparing(Product::getCode));
        return list;
    }

    public List<Product> searchByName(String namePart) {
        return repo.findBy(p -> p.getName().toLowerCase().contains(namePart.toLowerCase()));
    }

    // Seed example data similar to original
    public void seed() {
        addProduct(new Product("A001","Manzana",12.5,100,"Fruta", LocalDate.now().plusDays(10)));
        addProduct(new Product("B010","Leche 1L",22.0,50,"Lácteos", LocalDate.now().plusDays(5)));
        addProduct(new Product("C777","Pasta 200g",9.0,200,"Despensa", LocalDate.now().plusMonths(6)));
    }
}