package bus.project.OAuth_Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;

@Service
public class ClientDataService {

    @Autowired
    private WebClient springClient;

    public Mono<String> getClientData(){
        return springClient
                .get()
                .uri("http://localhost:10000/all-clients")
                .retrieve()
                .onStatus(HttpStatusCode::isError, ClientResponse::createException)
                .bodyToMono(String.class);
    }

    public Mono<String> getClientByName(String firstName) {
        return springClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port(10000)
                        .path("/get-clients-by-name")
                        .queryParam("firstName", firstName)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, ClientResponse::createException)
                .bodyToMono(String.class);
    }
}
