package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class ComputerOutputDTO extends ModelOutputDTO {

    @Schema(description = "Категория компьютера")
    private String category;

    @Schema(description = "Процессор компьютера")
    private String processorType;

    @Schema(description = "Тип техники")
    private DeviceDTO deviceDTO;

}
