package ru.myastrebov.smaple.kuberbates.core;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @author m.yastrebov
 */
@RequestMapping("/api")
@RestController
public class CoreController {

    @GetMapping("/random/{name}")
    public RandomDto ping(@PathVariable(value = "name") String name) {
        RandomDto randomDto = new RandomDto();
        randomDto.setRandomString(UUID.fromString(name).toString());
        randomDto.setRandomInt(new Random().nextInt());
        return randomDto;
    }

    @Data
    private static class RandomDto {

        private String randomString;

        private Integer randomInt;
    }

}
