package com.ust.AtheleteCoachService.controller;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;
import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/athlete/athletes")
public class AthleteController {

    private AthleteService athleteService;

    @PostMapping("/create")
    public ResponseEntity<AthleteDTO> createAthlete(@RequestBody AthleteDTO dto){
        return new ResponseEntity<>(athleteService.createAthlete(dto), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<AthleteDTO> editAthlete(@RequestBody AthleteDTO dto, @PathVariable String id){
        return ResponseEntity.ok(athleteService.editAthlete(dto, id));
    }

    @PostMapping("/request-assistance/{athlete_id}")
    public ResponseEntity<AssistanceRequestDTO> requestAssistance(@RequestBody AssistanceRequestDTO dto, @PathVariable String athlete_id){
        return new ResponseEntity<>(athleteService.requestAssistance(dto ,athlete_id),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AthleteDTO> findAthlete( @PathVariable String id){
        return ResponseEntity.ok(athleteService.findAthlete(id));
    }

    @GetMapping
    public ResponseEntity<List<AthleteDTO>> findAllAthlete(){
        return ResponseEntity.ok(athleteService.findAllAthletes());
    }
}
/*
TODO
  => create few more endpoints for open feign client services /./ DONE
 */