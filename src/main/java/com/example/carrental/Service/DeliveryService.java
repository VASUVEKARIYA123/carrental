package com.example.carrental.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.carrental.Dao.AccessKeyRepository;
import com.example.carrental.Dao.CarRepository;
import com.example.carrental.Dao.OrderRepository;
import com.example.carrental.Dao.UserRepository;
import com.example.carrental.Entity.Car;
import com.example.carrental.Entity.PlacedOrder;
import com.example.carrental.Entity.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeliveryService {
	private Long ID=null;
	private CarRepository carRepository;
	private OrderRepository orderRepository;
	private AccessKeyRepository accessKeyRepository;
	private UserRepository userRepository;
	
	@Autowired
	public DeliveryService(@Qualifier("carRepository") CarRepository carRepository,@Qualifier("orderRepository") OrderRepository orderRepository,
			@Qualifier("accessKeyRepository") AccessKeyRepository accessKeyRepository,@Qualifier("userRepository") UserRepository userRepository) {
		super();
		this.carRepository = carRepository;
		this.orderRepository = orderRepository;
		this.accessKeyRepository = accessKeyRepository;
		this.userRepository = userRepository;
	}
	
	public Car pickUpTheCar(String username, Long carId) {
		Car car=null;
		try {
	        car = carRepository.findById(carId).orElseThrow(() -> new Exception("Car With This ID Does Not Exists!"));
	        User user = userRepository.findByuserName(username).orElseThrow(() -> new Exception("User not exist"));
	        if(user.getAccesskey() == null) {
	        	throw new Exception("You Do Not Have An Access Key!");
	        }
	        else if(!user.getAccesskey().getCarPackage().equals(car.getCarPackage().getPackageName())) {

                throw new Exception("You Cannot Pick Car From This Package!");
	        }
	        else if(!car.getIsAvailable()) {

                throw new Exception("This Car Is Not Available!");
	        } else {
	        	System.out.println(user.getAccesskey().getId());
	        	
	        	
	        	
                car.setIsAvailable(false);
                LocalDateTime start = LocalDateTime.now();
                LocalDateTime end = LocalDateTime.now().plusHours(user.getAccesskey().getHours());
                PlacedOrder order = new PlacedOrder(ID, user.getId(), car.getId(), start, start, end);
                orderRepository.save(order);
                Long id=user.getAccesskey().getId();
                user.setAccesskey(null);
                accessKeyRepository.deleteById(id);
                
                return car;
        }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
}
}
