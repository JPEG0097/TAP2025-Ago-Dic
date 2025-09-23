package service;

import model.Client;
import repository.Repository;
import utils.GenericSearch;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientService {
    private final Repository<Client, Integer> repo;
    private final AtomicInteger autoId = new AtomicInteger(0);

    public ClientService(Repository<Client, Integer> repo) {
        this.repo = repo;
    }

    public Client addClient(String name, String email, String phone, double balance) {
        int id = autoId.incrementAndGet();
        Client c = new Client(id, name, email, phone, balance);
        repo.save(c);
        return c;
    }

    public boolean updateClient(Client c) {
        if (repo.findById(c.getId()).isEmpty()) return false;
        repo.save(c);
        return true;
    }

    public boolean deleteClient(int id) {
        return repo.deleteById(id);
    }

    public Optional<Client> findById(int id) {
        return repo.findById(id);
    }

    public List<Client> listAll() {
        List<Client> list = repo.findAll();
        GenericSearch.sort(list, Comparator.comparing(Client::getId));
        return list;
    }

    public List<Client> searchByName(String namePart) {
        return repo.findBy(c -> c.getName().toLowerCase().contains(namePart.toLowerCase()));
    }

    public List<Client> searchByEmail(String emailPart) {
        return repo.findBy(c -> c.getEmail().toLowerCase().contains(emailPart.toLowerCase()));
    }

    public void seed() {
        addClient("Juan Perez","juan@example.com","461-000-0011",100.0);
        addClient("Maria Lopez","maria@example.com","461-000-0022",50.0);
        addClient("Karla Diaz","karla@example.com","461-000-0033",0.0);
    }
}