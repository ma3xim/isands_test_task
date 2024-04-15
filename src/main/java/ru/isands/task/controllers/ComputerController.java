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
import ru.isands.task.dto.inputDto.ComputerInputDTO;
import ru.isands.task.dto.outputDto.ComputerOutputDTO;
import ru.isands.task.mapper.ComputerMapper;
import ru.isands.task.models.Computer;
import ru.isands.task.services.ComputerService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.ComputerValidator;

import java.util.List;

@RestController
@RequestMapping("/computer")
@Tag(name="Компьютеры")
public class ComputerController {
    private final ComputerService computerService;
    private final ComputerValidator computerValidator;


    @Autowired
    public ComputerController(ComputerService computerService, ComputerValidator computerValidator) {
        this.computerService = computerService;
        this.computerValidator = computerValidator;
    }

    @Operation(summary = "Получить список компьютеров")
    @GetMapping
    public List<ComputerOutputDTO> getComputers() {
        return computerService.findAllComputers();
    }

    @Operation(summary = "Добавить новый компьютер")
    @PostMapping("/add/{deviceId}")
    public ResponseEntity<HttpStatus> add(@PathVariable @Parameter(description = "К какому ID техники принадлежит эта сущность") Integer deviceId, @RequestBody @Valid ComputerInputDTO computerInputDTO,
                                          BindingResult bindingResult){
        Computer computer = ComputerMapper.toComputer(computerInputDTO);
        computerValidator.validate(computer, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
        computerService.save(deviceId,computer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить компьютер по ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        computerService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по компьютерам с использованием фильтров")
    @GetMapping("/search")
    public List<ComputerOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) @Parameter(description = "например Офисный/Игровой/...") String category,
            @RequestParam(required = false) String processorType
    ) {
        return computerService.getWithSearch(name, color, minPrice, maxPrice, category, processorType);
    }

    @Operation(summary = "Сортировка компьютеров по названию")
    @GetMapping("/sort/name")
    public List<ComputerOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") String sortType){
        return computerService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка компьютеров по цене")
    @GetMapping("/sort/price")
    public List<ComputerOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") String sortType){
        return computerService.sortByPrice(sortType);
    }
}
