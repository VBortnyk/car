package bvn.car.mapper;

import bvn.car.model.Car;
import bvn.car.model.dto.CarRequestDto;
import bvn.car.model.dto.CarResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car dtoToCar(CarRequestDto dto) {
        Car.CarBuilder builder = new Car.CarBuilder();
        return builder
                .setBrand(dto.getBrand())
                .setModel(dto.getModel())
                .setManufactureDate(dto.getManufactureDate())
                .setEngineType(dto.getEngineType())
                .setMaxSpeed(dto.getMaxSpeed())
                .setAccelerationTime(dto.getAccelerationTime())
                .setCapacity(dto.getCapacity())
                .setWheels(dto.getWheels())
                .setDoors(dto.getDoors())
                .build();
    }

    public CarResponseDto carToResponseDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setBrand(car.getBrand());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setManufactureDate(car.getManufactureDate());
        carResponseDto.setEngineType(car.getEngineType());
        carResponseDto.setMaxSpeed(car.getMaxSpeed());
        carResponseDto.setAccelerationTime(car.getAccelerationTime());
        carResponseDto.setCapacity(car.getCapacity());
        carResponseDto.setWheels(car.getWheels());
        carResponseDto.setDoors(car.getDoors());
        return carResponseDto;
    }
}
