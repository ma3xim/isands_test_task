package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class FridgeInputDTO extends ModelInputDTO {
    @Schema(description = "Количество дверей холодильника")
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    private Integer doors;

    @Schema(description = "Тип компрессора холодильника")
    @NotEmpty
    private String compressorType;
}
