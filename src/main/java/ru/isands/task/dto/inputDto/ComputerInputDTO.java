package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class ComputerInputDTO extends ModelInputDTO {

    @Schema(description = "Категория компьютера")
    @NotEmpty
    private String category;

    @Schema(description = "Процессор компьютера")
    @NotEmpty
    private String processorType;

}
