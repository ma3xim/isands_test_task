package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class DeviceOutputDTO extends DeviceDTO{

    @Schema(description = "Модели в наличии")
    private List<ModelOutputDTO> models;
}
