package pl.pwojaczek.vouchershop.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CrmController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/api/clients")
    public Iterable<Client> client() {
        return clientRepository.findAll();
    }

    @GetMapping("/api/clients/{id}")
    public Client clientById(@PathVariable int id) {
        return clientRepository.findById(id).orElseThrow(()-> new IllegalStateException("There is no such client"));
    }

    @PostMapping("/api/clients/")
    public void addClient(@Valid @RequestBody Client client){
        clientRepository.save(client);
    }

    @DeleteMapping("/api/clients/{id}")
    public void deleteClient(@PathVariable int id){
        clientRepository.deleteById(id);
    }

    @PostMapping("/api/clients/{id}")
    public void updateClient(@PathVariable int id, @RequestBody Client client){
        Client loaded = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("There is no such client."));

        loaded.setAddress(client.getAddress());
        loaded.setFirstname(client.getFirstname());
        loaded.setLastname(client.getLastname());

        clientRepository.save(loaded);
    }
}
