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
import ru.isands.task.dto.inputDto.TvInputDTO;
import ru.isands.task.dto.outputDto.TvOutputDTO;
import ru.isands.task.mapper.TvMapper;
import ru.isands.task.models.Tv;
import ru.isands.task.services.TvService;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.validators.TvValidator;

import java.util.List;

@RestController
@RequestMapping("/tv")
@Tag(name="Телевизоры")
public class TvController {
    private final TvService tvService;
    private final TvValidator tvValidator;

    @Autowired
    public TvController(TvService tvService, TvValidator tvValidator) {
        this.tvService = tvService;
        this.tvValidator = tvValidator;
    }

    @Operation(summary = "Получить список телевизоров")
    @GetMapping
    public List<TvOutputDTO> getTvs() {
        return tvService.findAllTvs();
    }

    @Operation(summary = "Добавить новый телевизор")
    @PostMapping("/add/{deviceId}")
    public ResponseEntity<HttpStatus> add(@PathVariable @Parameter(description = "К какому ID техники принадлежит эта сущность") Integer deviceId,
                                          @RequestBody @Valid TvInputDTO tvInputDTO,
                                          BindingResult bindingResult){
        Tv tv = TvMapper.toTv(tvInputDTO);
        tvValidator.validate(tv, bindingResult);
        if (bindingResult.hasErrors()){
            throw new EntityNotValidException("Поля не должны быть пустыми, null и должны быть валидными. ");
        }
        tvService.save(deviceId,tv);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Удалить телевизор по ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        tvService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Поиск по телевизорам с использованием фильтров")
    @GetMapping("/search")
    public List<TvOutputDTO> getWithSearch(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) @Parameter(description = "например Full HD/4K UHD/...") String category,
            @RequestParam(required = false) @Parameter(description = "например Direct Led/OLED/QLED/...")String technology
    ) {
        return tvService.getWithSearch(name, color, minPrice, maxPrice, category, technology);
    }

    @Operation(summary = "Сортировка телевизоров по названию")
    @GetMapping("/sort/name")
    public List<TvOutputDTO> getAllSortedByName(@RequestParam(defaultValue = "ASC") String sortType){
        return tvService.sortByName(sortType);
    }

    @Operation(summary = "Сортировка телевизоров по цене")
    @GetMapping("/sort/price")
    public List<TvOutputDTO> getAllSortedByPrice(@RequestParam(defaultValue = "ASC") String sortType){
        return tvService.sortByPrice(sortType);
    }
}
