package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class VacuumCleanerOutputDTO extends ModelOutputDTO {

    @Schema(description = "Объем пылесборника пылесоса")
    private Integer dustBagCapacity;

    @Schema(description = "Количество режимов пылесоса")
    private Integer cleanerModes;

    @Schema(description = "Тип техники")
    private DeviceDTO deviceDTO;
}
