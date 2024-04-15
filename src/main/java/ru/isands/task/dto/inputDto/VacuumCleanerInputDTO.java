package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class VacuumCleanerInputDTO extends ModelInputDTO {
    @Schema(description = "Объем пылесборника пылесоса")
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    private Integer dustBagCapacity;

    @Schema(description = "Количество режимов пылесоса")
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    private Integer cleanerModes;
}
