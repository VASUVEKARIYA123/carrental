package com.example.carrental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.carrental.Dao.CarPackageRepository;
import com.example.carrental.Dao.CarParametersRepository;
import com.example.carrental.Dao.CarRepository;
import com.example.carrental.Entity.Car;
import com.example.carrental.Entity.CarPackage;
import com.example.carrental.Entity.CarParameters;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarService {
	private CarRepository carRepository;
    private CarPackageRepository carPackageRepository;
    private CarParametersRepository carParametersRepository;
    
    @Autowired
    public CarService(@Qualifier("carRepository") CarRepository thecarrepo,@Qualifier("carPackageRepository") CarPackageRepository thecarpackrepo, @Qualifier("carParametersRepository") CarParametersRepository thecarpararepo) {
    	carRepository = thecarrepo;
    	carPackageRepository = thecarpackrepo;
    	carParametersRepository = thecarpararepo;
    }
    
    @Transactional
    public List<Car> getAllCar(){
    	return carRepository.findAll();
    }
    @Transactional
    public List<CarPackage> getCarPackages() {
        return carPackageRepository.findAll();
    }
    @Transactional
    public List<Car> getAvailableCars() {
        return carRepository.findAvailableCars();
    }
    @Transactional
    public Optional<Car> getCar(Long id) {
    	return carRepository.findById(id);
	}
    @Transactional
	public Car saveCar(Car c) {
    	return carRepository.save(c);
	}
    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    @Transactional
    public CarPackage saveCarPackage(CarPackage carPackage) {
        return carPackageRepository.save(carPackage);
    }
    @Transactional
    public void deleteCarPackage(Long id) {
        CarPackage carPackage = carPackageRepository.getById(id);
        List<Car> cars = carPackage.getCars();
        for (Car car : cars) {
                car.setCarPackage(null);
        }
        carPackageRepository.delete(carPackage);
    }

	public CarPackage getCarPackage(Long id) {
		return carPackageRepository.getById(id);
	}
    
    

}
