package com.example.carrental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.carrental.Dao.AccessKeyRepository;
import com.example.carrental.Dao.CarPackageRepository;
import com.example.carrental.Dao.OrderRepository;
import com.example.carrental.Dao.UserRepository;
import com.example.carrental.Entity.AccessKey;
import com.example.carrental.Entity.CarPackage;
import com.example.carrental.Entity.PlacedOrder;
import com.example.carrental.Entity.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	private Long ID=null;
	private CarPackageRepository carPackageRepository;
	private OrderRepository orderRepository;
	private AccessKeyRepository accessKeyRepository;
	private UserRepository userRepository;
	
	@Autowired
	public OrderService(@Qualifier("carPackageRepository") CarPackageRepository carPackageRepository,@Qualifier("orderRepository") OrderRepository orderRepository,
			@Qualifier("accessKeyRepository") AccessKeyRepository accessKeyRepository,@Qualifier("userRepository") UserRepository userRepository) {
		super();
		this.carPackageRepository = carPackageRepository;
		this.orderRepository = orderRepository;
		this.accessKeyRepository = accessKeyRepository;
		this.userRepository = userRepository;
	}
	
	public List<PlacedOrder> getOrders(String username) {
		List<PlacedOrder> ol = null;
			try {
			
				User user = userRepository.findByuserName(username).orElseThrow(() -> new Exception("User not exist"));
				Long uid = user.getId();
				System.out.println(uid);
				
				ol= orderRepository.findByuserId(uid);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		return ol;
		
	}
	
	public AccessKey submitOrder(String username, String carPackage, Integer hours) {
		AccessKey accessKey = null;
		try {
			
			User user = userRepository.findByuserName(username).orElseThrow(() -> new Exception("User not exist"));
	        
	        if(user.getCreditCard() == null) {

	            throw new Exception("You Do Not Have Credit Card!");
	            
	        }
	        if(user.getAccesskey() != null) {

                throw new Exception("You Have Already Placed An Order!");
	        }
	        Long money = user.getCreditCard().getAccountBalance();
    		CarPackage carPackageSearch = carPackageRepository.findByPackageName(carPackage).orElseThrow(() -> new Exception("This Package Does Not Exists!"));
    		Integer price = carPackageSearch.getPricePerHour();
    		
    		if (money < (long) price * hours) {
    			throw new Exception("You Do Not Have Enough Money!");
    		}else {
				user.getCreditCard().setAccountBalance(money - (long) price * hours);
                accessKey = new AccessKey(ID, carPackage, hours, null);
                accessKeyRepository.save(accessKey);
                user.setAccesskey(accessKey);
                accessKey.setUser(user);
            }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
        
        
		return accessKey;
}
	
}
