package com.example.carrental.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_parameters")
public class CarParameters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "fyel_type", nullable = false)
	private String fuelType;
	
	@Column(name = "gear_box_type", nullable = false)
	private String gearBoxType;
	
	@Column(name = "number_of_doors", nullable = false)
	private Integer numberOfDoors;
	
	@Column(name = "number_of_seats", nullable = false)
	private Integer numberOfSeats;
	
	@Column(name = "airConditioner", nullable = false)
	private Boolean AirConditioner;
	
	@Column(name = "power_door_locks", nullable = false)
	private Boolean PowerDoorLocks;
	
	@Column(name = "antilock_bracking_system", nullable = false)
	private Boolean AntiLockBrackingSystem;
	
	@Column(name = "bracking_assist", nullable = false)
	private Boolean BrackAssist;
	
	@Column(name = "power_steering", nullable = false)
	private Boolean PowerSteering;
	
	@Column(name = "driver_airbag", nullable = false)
	private Boolean DriverAirbag;
	
	@Column(name = "passenger_airbag", nullable = false)
	private Boolean PassengerAirbag;
	
	@Column(name = "power_windows", nullable = false)
	private Boolean PowerWindows;
	
	@Column(name = "crashsensor", nullable = false)
	private Boolean CrashSensor;
	
	@OneToOne(mappedBy = "carParameters")
	private Car car;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getGearBoxType() {
		return gearBoxType;
	}

	public void setGearBoxType(String gearBoxType) {
		this.gearBoxType = gearBoxType;
	}

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Boolean getAirConditioner() {
		return AirConditioner;
	}

	public void setAirConditioner(Boolean airConditioner) {
		AirConditioner = airConditioner;
	}

	public Boolean getPowerDoorLocks() {
		return PowerDoorLocks;
	}

	public void setPowerDoorLocks(Boolean powerDoorLocks) {
		PowerDoorLocks = powerDoorLocks;
	}

	public Boolean getAntiLockBrackingSystem() {
		return AntiLockBrackingSystem;
	}

	public void setAntiLockBrackingSystem(Boolean antiLockBrackingSystem) {
		AntiLockBrackingSystem = antiLockBrackingSystem;
	}

	public Boolean getBrackAssist() {
		return BrackAssist;
	}

	public void setBrackAssist(Boolean brackAssist) {
		BrackAssist = brackAssist;
	}

	public Boolean getPowerSteering() {
		return PowerSteering;
	}

	public void setPowerSteering(Boolean powerSteering) {
		PowerSteering = powerSteering;
	}

	public Boolean getDriverAirbag() {
		return DriverAirbag;
	}

	public void setDriverAirbag(Boolean driverAirbag) {
		DriverAirbag = driverAirbag;
	}

	public Boolean getPassengerAirbag() {
		return PassengerAirbag;
	}

	public void setPassengerAirbag(Boolean passengerAirbag) {
		PassengerAirbag = passengerAirbag;
	}

	public Boolean getPowerWindows() {
		return PowerWindows;
	}

	public void setPowerWindows(Boolean powerWindows) {
		PowerWindows = powerWindows;
	}

	public Boolean getCrashSensor() {
		return CrashSensor;
	}

	public void setCrashSensor(Boolean crashSensor) {
		CrashSensor = crashSensor;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarParameters(Long id, String fuelType, String gearBoxType, Integer numberOfDoors,
			Integer numberOfSeats, Boolean airConditioner, Boolean powerDoorLocks, Boolean antiLockBrackingSystem,
			Boolean brackAssist, Boolean powerSteering, Boolean driverAirbag, Boolean passengerAirbag,
			Boolean powerWindows, Boolean crashSensor, Car car) {
		super();
		this.id = id;
		this.fuelType = fuelType;
		this.gearBoxType = gearBoxType;
		this.numberOfDoors = numberOfDoors;
		this.numberOfSeats = numberOfSeats;
		AirConditioner = airConditioner;
		PowerDoorLocks = powerDoorLocks;
		AntiLockBrackingSystem = antiLockBrackingSystem;
		BrackAssist = brackAssist;
		PowerSteering = powerSteering;
		DriverAirbag = driverAirbag;
		PassengerAirbag = passengerAirbag;
		PowerWindows = powerWindows;
		CrashSensor = crashSensor;
		this.car = car;
	}

	public CarParameters() {
		super();
	}

	
	
	
}

