package com.agripure.agripurebackend.controller;

import com.agripure.agripurebackend.entities.Event;
import com.agripure.agripurebackend.service.IEventService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final IEventService eventService;

    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> findAllByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> req) {
        try {
            if (req.isPresent()) {
                LocalDate date = req.get();
                System.out.println(date);
                List<Event> events = eventService.findAllByDate(date);
                return new ResponseEntity<>(events, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> insertEvent(@Valid @RequestBody Event event){
        try{
            Event eventNew = eventService.save(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(eventNew);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> deleteEvent (@PathVariable("id") Long id){
        try{
            Optional<Event> eventDelete = eventService.getById(id);
            if(!eventDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            eventService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}