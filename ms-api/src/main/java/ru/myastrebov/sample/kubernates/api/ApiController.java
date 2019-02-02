package ru.myastrebov.sample.kubernates.api;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m.yastrebov
 */
@RequestMapping("/api")
@RestController
public class ApiController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/ping/{name}")
    public ResponseEntity<String> ping(@PathVariable("name") String name) {
        return ResponseEntity.ok(String.format("Hello, %s! I am %s", name, applicationName));
    }

}
