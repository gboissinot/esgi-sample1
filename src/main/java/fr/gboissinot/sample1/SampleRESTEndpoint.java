package fr.gboissinot.sample1;

import fr.gboissinot.kernel.cqs.command.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleRESTEndpoint {

    private final CommandBus commandBus;

    @Autowired
    public SampleRESTEndpoint(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> placeOrder(@PathVariable long id){
        return ResponseEntity.ok("SAMPLE 1");

}
}
