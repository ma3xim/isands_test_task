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
public class PhoneInputDTO extends ModelInputDTO {
    @Schema(description = "Память телефона")
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    private Integer memory;

    @Schema(description = "Количество камер телефона")
    @Min(value = 0)
    @Max(value = Integer.MAX_VALUE)
    private Integer cameras;
}
