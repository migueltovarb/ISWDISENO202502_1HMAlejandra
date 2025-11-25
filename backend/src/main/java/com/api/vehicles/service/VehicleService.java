package com.api.vehicles.service;

import com.api.vehicles.model.Vehicle;
import com.api.vehicles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    // Crear un nuevo vehículo
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setFechaRegistro(LocalDateTime.now());
        return vehicleRepository.save(vehicle);
    }
    
    // Obtener todos los vehículos
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    
    // Obtener vehículo por ID
    public Optional<Vehicle> getVehicleById(String id) {
        return vehicleRepository.findById(id);
    }
    
    // Actualizar vehículo
    public Optional<Vehicle> updateVehicle(String id, Vehicle vehicleDetails) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setMarca(vehicleDetails.getMarca());
            vehicle.setModelo(vehicleDetails.getModelo());
            vehicle.setAnio(vehicleDetails.getAnio());
            vehicle.setColor(vehicleDetails.getColor());
            vehicle.setPlaca(vehicleDetails.getPlaca());
            vehicle.setTipo(vehicleDetails.getTipo());
            vehicle.setPrecio(vehicleDetails.getPrecio());
            return vehicleRepository.save(vehicle);
        });
    }
    
    // Eliminar vehículo
    public boolean deleteVehicle(String id) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicleRepository.delete(vehicle);
            return true;
        }).orElse(false);
    }
    
    // Buscar por marca
    public List<Vehicle> findByMarca(String marca) {
        return vehicleRepository.findByMarca(marca);
    }
    
    // Buscar por modelo
    public List<Vehicle> findByModelo(String modelo) {
        return vehicleRepository.findByModelo(modelo);
    }
    
    // Buscar por año
    public List<Vehicle> findByAnio(Integer anio) {
        return vehicleRepository.findByAnio(anio);
    }
    
    // Buscar por placa
    public Optional<Vehicle> findByPlaca(String placa) {
        return vehicleRepository.findByPlaca(placa);
    }
    
    // Buscar por tipo
    public List<Vehicle> findByTipo(String tipo) {
        return vehicleRepository.findByTipo(tipo);
    }
}
