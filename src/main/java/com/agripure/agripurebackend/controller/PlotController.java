package com.agripure.agripurebackend.controller;

import com.agripure.agripurebackend.entities.Plot;
import com.agripure.agripurebackend.service.IPlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/plots")
public class PlotController {
    private IPlotService plotService;

    public PlotController(IPlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plot>>findAllPlots() {
        try {
            List<Plot> plots = plotService.getAll();
            if (plots.size() > 0)
                return new ResponseEntity<>(plots ,HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plot>findPlotById(@PathVariable("id") Long id) {
        try {
            Optional<Plot> plot = plotService.getById(id);
            if (!plot.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(plot.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plot> insertPlot(@Valid @RequestBody Plot plot){
        try{
            Plot plotNew = plotService.save(plot);
            return ResponseEntity.status(HttpStatus.CREATED).body(plotNew);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plot> deletePlot (@PathVariable("id") Long id){
        try{
            Optional<Plot> plotDelete = plotService.getById(id);
            if(!plotDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            plotService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
