package ru.myastrebov.sample.kubernates.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author m.yastrebov
 */
@FeignClient(value = "random-service", url = "http://ms-core/api/")
interface RandomService {

    @GetMapping("/generate/{from}")
    RandomDto generateFromString(@PathVariable("from") String from);
}
