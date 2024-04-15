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
import ru.isands.task.dto.inputDto.FridgeInputDTO;
import ru.isands.task.dto.outputDto.FridgeOutputDTO;
import ru.isands.task.mapper.FridgeMapper;
import ru.isands.task.models.Fridge;
import ru.isands.task.services.FridgeService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.FridgeValidator;

import java.util.List;

@RestController
@RequestMapping("/fridge")
@Tag(name="Холодильники")
public class FridgeController {
    private final FridgeService fridgeService;
    private final FridgeValidator fridgeValidator;

    @Autowired
    public FridgeController(FridgeService fridgeService, FridgeValidator fridgeValidator) {
        this.fridgeService = fridgeService;
        this.fridgeValidator = fridgeValidator;
    }

    @Operation(summary = "Получить список холодильников")
    @GetMapping
    public List<FridgeOutputDTO> getFridges() {
        return fridgeService.findAllFridges();
    }

    @Operation(summary = "Добавить новый холодильник")
    @PostMapping("/add/{deviceId}")
    public ResponseEntity<HttpStatus> add(@PathVariable @Parameter(description = "К какому ID техники принадлежит эта сущность") Integer deviceId, @RequestBody @Valid FridgeInputDTO fridgeInputDTO,
                                          BindingResult bindingResult){
        Fridge fridge = FridgeMapper.toFridge(fridgeInputDTO);
        fridgeValidator.validate(fridge, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
        fridgeService.save(deviceId,fridge);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить холодильник по ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        fridgeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по холодильникам с использованием фильтров")
    @GetMapping("/search")
    public List<FridgeOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minDoors,
            @RequestParam(required = false) Integer maxDoors,
            @RequestParam(required = false) @Parameter(description = "например Инверторный/Линейный/...") String compressorType
    ) {
        return fridgeService.getWithSearch(name, color, minPrice, maxPrice, minDoors, maxDoors, compressorType);
    }

    @Operation(summary = "Сортировка холодильников по названию")
    @GetMapping("/sort/name")
    public List<FridgeOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return fridgeService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка холодильников по цене")
    @GetMapping("/sort/price")
    public List<FridgeOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") @Parameter(description = "ASC или DESC") String sortType){
        return fridgeService.sortByPrice(sortType);
    }
}
