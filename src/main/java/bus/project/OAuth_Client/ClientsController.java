package bus.project.OAuth_Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ClientsController {
    @Autowired
    ClientDataService clientDataService;

    @GetMapping("/")
    public Mono<String> getClientsData(){
        return clientDataService.getClientData();
    }

    @GetMapping("/client-by-name")
    public Mono<String> getClientByName(@RequestParam String firstName) {
        return clientDataService.getClientByName(firstName);
    }
}
