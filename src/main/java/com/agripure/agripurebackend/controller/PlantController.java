package com.agripure.agripurebackend.controller;

import com.agripure.agripurebackend.entities.Plant;
import com.agripure.agripurebackend.service.IPlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    private final IPlantService plantService;

    public PlantController(IPlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> findAll(){
        try{
            List<Plant> plants = plantService.getAll();
            return new ResponseEntity<>(plants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
