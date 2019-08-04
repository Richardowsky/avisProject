package com.avis.service;

import com.avis.domain.CarDto;
import com.avis.model.Car;
import com.avis.model.History;
import com.avis.model.Seller;
import com.avis.repo.CarRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepo carRepo;
    private final HistoryService historyService;

    public CarService(CarRepo carRepo, HistoryService historyService) {
        this.carRepo = carRepo;
        this.historyService = historyService;
    }

    public boolean addCar(CarDto carDto, Seller seller) {
        Car car = new Car();
        String brand = carDto.getBrand();
        String model = carDto.getModel();
        int mileage = carDto.getMileage();
        int year = carDto.getYear();
        double price = carDto.getPrice();

        car.setBrand(brand);
        car.setModel(model);
        car.setMileage(mileage);
        car.setYear(year);
        car.setPrice(price);
        car.setSeller(seller);
        carRepo.save(car);
        return true;
    }

    public boolean updateCar(long carId, double price){
        Car car = carRepo.findById(carId);
        car.setPrice(price);
        carRepo.save(car);
        return  true;
    }

    public  boolean saleCar(long carId){
        Car car = carRepo.findById(carId);

        Seller seller = car.getSeller();
        seller.setSoldCars(seller.getSoldCars()+1);
        historyService.addHistory(car);
        carRepo.delete(car);
        return true;
    }


}
