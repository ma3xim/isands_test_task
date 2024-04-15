package ru.isands.task.dto.inputDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DeviceInputDTO {
    @Schema(description = "Наименование вида техники")
    @NotEmpty
    private String name;

    @Schema(description = "Страна производитель техники")
    @NotEmpty
    private String countryManufacturer;

    @Schema(description = "Фирма производитель техники")
    @NotEmpty
    private String companyManufacturer;

    @Schema(description = "Возможность заказа онлайн")
    @NotNull
    private Boolean isOnlineOrder;

    @Schema(description = "Возможность оформления рассрочки")
    @NotNull
    private Boolean isInstallment;

}
