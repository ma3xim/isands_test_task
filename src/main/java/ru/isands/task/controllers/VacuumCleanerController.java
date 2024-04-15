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
import ru.isands.task.dto.inputDto.VacuumCleanerInputDTO;
import ru.isands.task.dto.outputDto.VacuumCleanerOutputDTO;
import ru.isands.task.mapper.VacuumCleanerMapper;
import ru.isands.task.models.VacuumCleaner;
import ru.isands.task.services.VacuumCleanerService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.VacuumCleanerValidator;

import java.util.List;

@RestController
@RequestMapping("/vacuumCleaner")
@Tag(name="Пылесосы")
public class VacuumCleanerController {
    private final VacuumCleanerService vacuumCleanerService;
    private final VacuumCleanerValidator vacuumCleanerValidator;

    @Autowired
    public VacuumCleanerController(VacuumCleanerService vacuumCleanerService, VacuumCleanerValidator vacuumCleanerValidator) {
        this.vacuumCleanerService = vacuumCleanerService;
        this.vacuumCleanerValidator = vacuumCleanerValidator;
    }

    @Operation(summary = "Получить список пылесосов")
    @GetMapping
    public List<VacuumCleanerOutputDTO> getVacuumCleaners() {
        return vacuumCleanerService.findAllCVacuumCleaners();
    }

    @Operation(summary = "Добавить новый пылесос")
    @PostMapping("/add/{deviceId}")
    public ResponseEntity<HttpStatus> add(@PathVariable @Parameter(description = "К какому ID техники принадлежит эта сущность") Integer deviceId, @RequestBody @Valid VacuumCleanerInputDTO vacuumCleanerInputDTO,
                                          BindingResult bindingResult){
        VacuumCleaner vacuumCleaner = VacuumCleanerMapper.toVacuumCleaner(vacuumCleanerInputDTO);
        vacuumCleanerValidator.validate(vacuumCleaner, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
        vacuumCleanerService.save(deviceId,vacuumCleaner);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить пылесос по ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        vacuumCleanerService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по пылесосам с использованием фильтров")
    @GetMapping("/search")
    public List<VacuumCleanerOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minCapacity,
            @RequestParam(required = false) Integer maxCapacity,
            @RequestParam(required = false) Integer minModes,
            @RequestParam(required = false) Integer maxModes
    ) {
        return vacuumCleanerService.getWithSearch(name, color, minPrice, maxPrice, minCapacity, maxCapacity, minModes, maxModes);
    }

    @Operation(summary = "Сортировка пылесосов по названию")
    @GetMapping("/sort/name")
    public List<VacuumCleanerOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") String sortType){
        return vacuumCleanerService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка пылесосов по цене")
    @GetMapping("/sort/price")
    public List<VacuumCleanerOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") String sortType){
        return vacuumCleanerService.sortByPrice(sortType);
    }
}
