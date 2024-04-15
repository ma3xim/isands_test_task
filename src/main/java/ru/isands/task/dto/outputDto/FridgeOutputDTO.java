package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class FridgeOutputDTO extends ModelOutputDTO {

    @Schema(description = "Количество дверей холодильника")
    private Integer doors;

    @Schema(description = "Тип компрессора холодильника")
    private String compressorType;

    @Schema(description = "Тип техники")
    private DeviceDTO deviceDTO;
}
