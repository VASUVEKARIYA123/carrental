package com.example.carrental.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrental.Entity.Car;
import com.example.carrental.Entity.CarPackage;
import com.example.carrental.Service.CarService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class carController {
	private CarService carService;
	
	@Autowired
	public carController(CarService thecarService) {
		carService = thecarService;
	}
	
	@GetMapping("/cars")
	public List<Car> getAllCars() {
        return carService.getAllCar();
	}
	@GetMapping("/cars/available")
    public List<Car> getAvailableCars() {
            return carService.getAvailableCars();
    }
	@GetMapping("/cars/{id}")
    public Optional<Car> getCar(@PathVariable Long id) {
            return carService.getCar(id);
    }
	@PostMapping("/cars")
    public Car saveCar(@RequestBody Car car) {
		car.setId((long) 0);
        return carService.saveCar(car);
    }
	@PutMapping("/cars")
    public Car updateCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }
	@DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
            carService.deleteCar(id);
    }
	
	
	@GetMapping("/cars/packages")
	public List<CarPackage> getAllPackages() {
        return carService.getCarPackages();
	}
	@GetMapping("/cars/packages/{id}")
	public CarPackage getPackage(@PathVariable Long id) {
        return carService.getCarPackage(id);
	}
    @PostMapping("/cars/packages")
    public CarPackage saveCarPackage(@RequestBody CarPackage carPackage) {
            return carService.saveCarPackage(carPackage);
    }
    @PutMapping("/cars/packages")
    public CarPackage updateCarPackage(@RequestBody CarPackage carPackage) {
            return carService.saveCarPackage(carPackage);
    }
    @DeleteMapping("/cars/packages/{id}")
    public void deleteCarPackage(@PathVariable Long id) {
            carService.deleteCarPackage(id);
    }
}
