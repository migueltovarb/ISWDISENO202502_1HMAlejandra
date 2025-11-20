package com.api.vehicles.controller;

import com.api.vehicles.model.Vehicle;
import com.api.vehicles.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/")
    public ResponseEntity<String> root() {
        return new ResponseEntity<>("{\"message\": \"API de Vehículos funcionando correctamente\", \"version\": \"1.0.0\"}", HttpStatus.OK);
    }
    
    // Crear un nuevo vehículo
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle) {
        try {
            Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
            return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener todos los vehículos
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        try {
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Obtener vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") String id) {
        return vehicleService.getVehicleById(id)
                .map(vehicle -> new ResponseEntity<>(vehicle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // Actualizar vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") String id, @Valid @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle)
                .map(updatedVehicle -> new ResponseEntity<>(updatedVehicle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // Eliminar vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable("id") String id) {
        try {
            boolean deleted = vehicleService.deleteVehicle(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Buscar por marca
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Vehicle>> findByMarca(@PathVariable("marca") String marca) {
        try {
            List<Vehicle> vehicles = vehicleService.findByMarca(marca);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Buscar por modelo
    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<List<Vehicle>> findByModelo(@PathVariable("modelo") String modelo) {
        try {
            List<Vehicle> vehicles = vehicleService.findByModelo(modelo);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Buscar por año
    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<Vehicle>> findByAnio(@PathVariable("anio") Integer anio) {
        try {
            List<Vehicle> vehicles = vehicleService.findByAnio(anio);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Buscar por placa
    @GetMapping("/placa/{placa}")
    public ResponseEntity<Vehicle> findByPlaca(@PathVariable("placa") String placa) {
        return vehicleService.findByPlaca(placa)
                .map(vehicle -> new ResponseEntity<>(vehicle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // Buscar por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Vehicle>> findByTipo(@PathVariable("tipo") String tipo) {
        try {
            List<Vehicle> vehicles = vehicleService.findByTipo(tipo);
            if (vehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
