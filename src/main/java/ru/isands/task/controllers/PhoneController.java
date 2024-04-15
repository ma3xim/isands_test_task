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
import ru.isands.task.dto.inputDto.PhoneInputDTO;
import ru.isands.task.dto.outputDto.PhoneOutputDTO;
import ru.isands.task.mapper.PhoneMapper;
import ru.isands.task.models.Phone;
import ru.isands.task.services.PhoneService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.PhoneValidator;

import java.util.List;

@RestController
@RequestMapping("/phone")
@Tag(name="Смартфоны")
public class PhoneController {
    private final PhoneService phoneService;
    private final PhoneValidator phoneValidator;

    @Autowired
    public PhoneController(PhoneService phoneService, PhoneValidator phoneValidator) {
        this.phoneService = phoneService;
        this.phoneValidator = phoneValidator;
    }

    @Operation(summary = "Получить список телефонов")
    @GetMapping
    public List<PhoneOutputDTO> getPhones() {
        return phoneService.findAllPhones();
    }

    @Operation(summary = "Добавить новый телефон")
    @PostMapping("/add/{deviceId}")
    public ResponseEntity<HttpStatus> add(@PathVariable @Parameter(description = "К какому ID техники принадлежит эта сущность") Integer deviceId, @RequestBody @Valid PhoneInputDTO phoneInputDTO,
                                          BindingResult bindingResult){
        Phone phone = PhoneMapper.toPhone(phoneInputDTO);
        phoneValidator.validate(phone, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
        phoneService.save(deviceId,phone);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить телефон по ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        phoneService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по телефонам с использованием фильтров")
    @GetMapping("/search")
    public List<PhoneOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minCameras,
            @RequestParam(required = false) Integer maxCameras,
            @RequestParam(required = false) Integer minMemory,
            @RequestParam(required = false) Integer maxMemory
    ) {
        return phoneService.getWithSearch(name, color, minPrice, maxPrice, minCameras, maxCameras, minMemory, maxMemory);
    }

    @Operation(summary = "Сортировка телефонов по названию")
    @GetMapping("/sort/name")
    public List<PhoneOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return phoneService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка телефонов по цене")
    @GetMapping("/sort/price")
    public List<PhoneOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return phoneService.sortByPrice(sortType);
    }
}
