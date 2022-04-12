package com.api.parkingcontrol.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.parkingcontrol.models.ParkingSpotModel;


@Repository // anotado por organização, pois JPA já indica que fará transações com base de dados esta interface
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{
	
	//extendemos para o JPA porque ele tem varios recusos/metodos prontos para a gente utilizar
	// para transações com o banco de dados, buscar um produto, deletar, atualizar, listar
	
	public boolean existsByLicensePlateCar(String licensePlateCar);
	public boolean existsByParkingSpotNumber(String parkingSpotNumber);
	public boolean existsByApartmentAndBlock(String apartment, String block);
}
