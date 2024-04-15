package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class TvOutputDTO extends ModelOutputDTO {
    @Schema(description = "Категория(разрешение) телевизора")
    private String category;

    @Schema(description = "Технология экрана телевизора")
    private String technology;

    @Schema(description = "Тип техники")
    private DeviceDTO deviceDTO;
}
