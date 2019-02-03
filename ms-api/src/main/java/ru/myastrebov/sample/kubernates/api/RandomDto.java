package ru.myastrebov.sample.kubernates.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author m.yastrebov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class RandomDto {

    private String randomString;

    private Integer randomInt;
}
