package ru.isands.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.task.dto.outputDto.TvOutputDTO;
import ru.isands.task.mapper.TvMapper;
import ru.isands.task.models.Device;
import ru.isands.task.models.Tv;
import ru.isands.task.repositories.DeviceRepository;
import ru.isands.task.repositories.TvRepository;
import ru.isands.task.services.searchAndFilters.TvSearchAndFilter;
import ru.isands.task.util.exceptions.EntityNotValidException;
import ru.isands.task.util.exceptions.InvalidSortTypeException;
import ru.isands.task.util.exceptions.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TvService {
    private final TvRepository tvRepository;
    private final DeviceRepository deviceRepository;
    private final TvSearchAndFilter tvSearchAndFilter;
    private final String DEVICE_TYPE = "Телевизор";

    @Autowired
    public TvService(TvRepository tvRepository, DeviceRepository deviceRepository, TvSearchAndFilter tvSearchAndFilter) {
        this.tvRepository = tvRepository;
        this.deviceRepository = deviceRepository;
        this.tvSearchAndFilter = tvSearchAndFilter;
    }

    public List<TvOutputDTO> findAllTvs() {
        return tvRepository.findAllByTypeOfDevice(DEVICE_TYPE).stream().map(tv -> TvMapper.toOutputDto(tv)).collect(Collectors.toList());
    }

    @Transactional
    public void save(Integer deviceId, Tv tv) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new NotFoundException("Техника с таким ID не найдена"));
        if (!device.getName().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Несовместимая модель и тип техники");
        }
        tv.setDevice(device);
        tv.setTypeOfDevice(DEVICE_TYPE);
        tvRepository.save(tv);
    }

    @Transactional
    public void delete(Integer id) {
        if (tvRepository.findById(id).isEmpty()) {
            throw new EntityNotValidException(DEVICE_TYPE + " с таким ID отсутствует");
        }
        if (!tvRepository.findById(id).get().getTypeOfDevice().equals(DEVICE_TYPE)) {
            throw new EntityNotValidException("Эта техника не " + DEVICE_TYPE);
        }
        tvRepository.deleteById(id);
    }


    public List<TvOutputDTO> getWithSearch(
            String name,
            String color,
            Double minPrice,
            Double maxPrice,
            String category,
            String technology
    ) {
        List<Tv> tvs = tvSearchAndFilter.search(name, color, minPrice, maxPrice, category, technology);

        return tvs.stream()
                .map(tv -> TvMapper.toOutputDto(tv))
                .collect(Collectors.toList());
    }

    public List<TvOutputDTO> sortByName(String sortType) {
        try {
            return tvRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "name"))
                    .stream()
                    .map(tv -> TvMapper.toOutputDto(tv))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }

    public List<TvOutputDTO> sortByPrice(String sortType) {
        try {
            return tvRepository.findAllByTypeOfDevice(DEVICE_TYPE, Sort.by(Sort.Direction.fromString(sortType), "price"))
                    .stream()
                    .map(tv -> TvMapper.toOutputDto(tv))
                    .collect(Collectors.toList());
        }
        catch (IllegalArgumentException e){
            throw new InvalidSortTypeException("Должен быть ASC или DESC");
        }
    }
}
