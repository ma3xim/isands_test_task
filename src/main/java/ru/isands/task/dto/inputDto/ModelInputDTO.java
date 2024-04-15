package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ModelInputDTO {
    @Schema(description = "Наименование модели")
    @NotEmpty
    private String name;

    @Schema(description = "Серийный номер модели")
    @NotEmpty
    private String serialNumber;

    @Schema(description = "Цвет модели")
    @NotEmpty
    private String color;

    @Schema(description = "Размер модели")
    @Min(value = 0)
    private Double size;

    @Schema(description = "Цена модели")
    @Min(value = 0)
    private Double price;

    @Schema(description = "Наличие модели")
    @NotNull
    private Boolean isAvailable;

}
