package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ModelOutputDTO {
    @Schema(description = "ID модели")
    private Integer id;

    @Schema(description = "Наименование модели")
    private String name;

    @Schema(description = "Серийный номер модели")
    private String serialNumber;

    @Schema(description = "Цвет модели")
    private String color;

    @Schema(description = "Размер модели")
    private Double size;

    @Schema(description = "Цена модели")
    private Double price;

    @Schema(description = "Наличие модели")
    private Boolean isAvailable;

    @Schema(description = "Вид техники")
    private String typeOfDevice;

//    @Schema(description = "Вид техники")
//    private String typeOfDevice;
//    показывает null в ответе, но вроде был нужен для чего то(не помню)


}
