package com.ust.AtheleteCoachService.controller;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;
import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/athletes")
public class AthleteController {

    private AthleteService athleteService;

    @PostMapping("/create")
    public ResponseEntity<AthleteDTO> createAthlete(AthleteDTO dto){
        return new ResponseEntity<>(athleteService.createAthlete(dto), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<AthleteDTO> editAthlete(AthleteDTO dto){
        return ResponseEntity.ok(athleteService.editAthlete(dto));
    }

    @PostMapping("/request-assistance/{athlete_id}")
    public ResponseEntity<AssistanceRequestDTO> requestAssistance(AssistanceRequestDTO dto, @PathVariable int athlete_id){
        return new ResponseEntity<>(athleteService.requestAssistance(dto ,athlete_id),HttpStatus.CREATED);
    }

}
/*
TODO
  => create few more endpoints for open feign client services
 */