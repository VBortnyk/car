package bvn.car.controllers;

import bvn.car.mapper.CarMapper;
import bvn.car.model.Car;
import bvn.car.model.dto.CarRequestDto;
import bvn.car.model.dto.CarResponseDto;
import bvn.car.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping("/add")
    public void add(@RequestBody CarRequestDto dto) {
        carService.create(carMapper.dtoToCar(dto));
    }

    @GetMapping("/by-id")
    public CarResponseDto getCarById(@RequestParam(name = "id") Long carId) {
        Car car = carService.getById(carId);
        return carMapper.carToResponseDto(car);
    }

    @GetMapping("/all")
    public List<CarResponseDto> getAll() {
        List<Car> cars = carService.getAll();
        return cars.stream()
                .map(carMapper::carToResponseDto)
                .collect(Collectors.toList());
    }
}
