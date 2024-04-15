package ru.isands.task.dto.outputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DeviceDTO {
    @Schema(description = "ID вида")
    private Integer id;

    @Schema(description = "Наименование вида техники")
    private String name;

    @Schema(description = "Страна производитель техники")
    private String countryManufacturer;

    @Schema(description = "Фирма производитель техники")
    private String companyManufacturer;

    @Schema(description = "Возможность заказа онлайн")
    private Boolean isOnlineOrder;

    @Schema(description = "Возможность оформления рассрочки")
    private Boolean isInstallment;
}
