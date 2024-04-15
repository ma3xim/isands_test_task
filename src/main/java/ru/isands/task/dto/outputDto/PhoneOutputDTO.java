package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class PhoneOutputDTO extends ModelOutputDTO {

    @Schema(description = "Память телефона")
    private Integer memory;

    @Schema(description = "Количество камер телефона")
    private Integer cameras;

    @Schema(description = "Тип техники")
    private DeviceDTO deviceDTO;
}
