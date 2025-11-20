package com.api.vehicles.repository;

import com.api.vehicles.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    
    // Buscar por marca
    List<Vehicle> findByMarca(String marca);
    
    // Buscar por modelo
    List<Vehicle> findByModelo(String modelo);
    
    // Buscar por año
    List<Vehicle> findByAnio(Integer anio);
    
    // Buscar por placa
    Optional<Vehicle> findByPlaca(String placa);
    
    // Buscar por tipo
    List<Vehicle> findByTipo(String tipo);
    
    // Buscar por marca y modelo
    List<Vehicle> findByMarcaAndModelo(String marca, String modelo);
    
    // Buscar vehículos con precio mayor a
    List<Vehicle> findByPrecioGreaterThan(Double precio);
    
    // Buscar vehículos con precio menor a
    List<Vehicle> findByPrecioLessThan(Double precio);
}
