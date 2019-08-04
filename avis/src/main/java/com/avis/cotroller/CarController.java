package com.avis.cotroller;

import com.avis.domain.CarDto;
import com.avis.model.Seller;
import com.avis.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/newCar", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean addCar(@RequestBody CarDto carDto, @AuthenticationPrincipal Seller seller) {
        return carService.addCar(carDto, seller);
    }

    @RequestMapping(value = "/updateCar", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean updateCar(@RequestParam long id, @RequestParam double price) {
        return carService.updateCar(id, price);
    }

    @RequestMapping(value = "/saleCar", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public boolean saleCar(@RequestParam long id) {
        return carService.saleCar(id);
    }
}
