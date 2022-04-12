package com.api.parkingcontrol.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	// esta dizendo que em determinados momentos será acionado uma injecão de dependencia 
	final ParkingSpotRepository parkingSpotRepository;
	public ParkingSpotService (ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
	
	@Transactional //é um metodo destruitivo é preciso ter @Transactional para poder fazer rollback, pois envolve relacionamente com jpa
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);   
	}       
	
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}    
																		/////neste caso nossos metodos vão para classe reposiory pq
	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {////ela extende JPA, por isso devemos declarar lá na interface
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber); //// para utilizar seus beneficios
	}
	
	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block );
	}

	public Page<ParkingSpotModel> findAll(Pageable pageable) {
		return parkingSpotRepository.findAll(pageable);
	}

	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}
	
	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) { //é um metodo destruitivo é preciso ter @Transactional para poder fazer rollback, pois envolve relacionamente com jpa
		parkingSpotRepository.delete(parkingSpotModel);
	}
}
