package fr.gboissinot.sample1.exposition;

import fr.gboissinot.sample1.application.ClientApplicationService;
import fr.gboissinot.sample1.domain.model.Client;
import fr.gboissinot.sample1.domain.model.ClientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    private final ClientApplicationService clientApplicationService;

    @Autowired
    public ClientResource(ClientApplicationService clientApplicationService) {
        this.clientApplicationService = clientApplicationService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ClientResponse> placeOrder(@PathVariable long id) {

        final Client client = clientApplicationService.find(ClientId.of(String.valueOf(id)));

        ClientResponse clientResponse = new ClientResponse();
        clientResponse.lastname = client.lastname();
        clientResponse.firstname = client.firstname();

        return ResponseEntity.ok(clientResponse);

    }
}
