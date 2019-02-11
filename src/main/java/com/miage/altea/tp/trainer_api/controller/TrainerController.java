package com.miage.altea.tp.trainer_api.controller;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RequestMapping("/trainers")
@RestController
public class TrainerController {
    @Autowired
    private final TrainerService trainerService;


    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/")
    public Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{name}")
    public Trainer getTrainer(@PathVariable("name") String name){
        return trainerService.getTrainer(name);
    }

    @PostMapping("/")
    public Trainer createTrainer(@RequestBody Trainer trainer){
        return trainerService.createTrainer(trainer);
    }
}
