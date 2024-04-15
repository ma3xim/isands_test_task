package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class TvInputDTO extends ModelInputDTO {
    @Schema(description = "Категория(разрешение) телевизора")
    private String category;

    @Schema(description = "Технология экрана телевизора")
    private String technology;
}
