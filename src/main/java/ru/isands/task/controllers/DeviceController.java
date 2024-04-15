package ru.isands.task.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.isands.task.dto.inputDto.DeviceInputDTO;
import ru.isands.task.dto.outputDto.ComputerOutputDTO;
import ru.isands.task.dto.outputDto.DeviceOutputDTO;
import ru.isands.task.dto.outputDto.ModelOutputDTO;
import ru.isands.task.mapper.DeviceMapper;
import ru.isands.task.models.Device;
import ru.isands.task.services.DeviceService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.DeviceValidator;

import java.util.List;

@RestController
@RequestMapping("/devices")
@Tag(name="Вся техника")
public class DeviceController {
    private final DeviceService deviceService;
    private final DeviceValidator deviceValidator;

    @Autowired
    public DeviceController(DeviceService deviceService, DeviceValidator deviceValidator) {
        this.deviceService = deviceService;
        this.deviceValidator = deviceValidator;
    }

    @Operation(summary = "Получить список видов техники")
    @GetMapping
    public List<DeviceOutputDTO> getDevices() {
        return deviceService.findAllDevices();
    }

    @Operation(summary = "Получить вид техники по ID")
    @GetMapping("/{id}")
    public DeviceOutputDTO getDevice(@PathVariable Integer id) {
        return deviceService.findById(id);
    }

    @Operation(summary = "Добавить новый вид техники")
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid DeviceInputDTO deviceInputDTO,
                                             BindingResult bindingResult){
        Device device = DeviceMapper.toDevice(deviceInputDTO);
        deviceValidator.validate(device, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }

        deviceService.save(device);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по всей технике с использованием фильтров")
    @GetMapping("/search")
    public List<ModelOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return deviceService.getWithSearch(name, color, minPrice, maxPrice);
    }

    @Operation(summary = "Сортировка техники по названию")
    @GetMapping("/sort/name")
    public List<ModelOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return deviceService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка техники по цене")
    @GetMapping("/sort/price")
    public List<ModelOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return deviceService.sortByPrice(sortType);
    }
}
