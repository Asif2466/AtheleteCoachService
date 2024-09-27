package com.ust.AtheleteCoachService.controller;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.CoachDTO;
import com.ust.AtheleteCoachService.model.Achievements;
import com.ust.AtheleteCoachService.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/athlete/coaches")
public class CoachController {

    private CoachService coachService;

    @PostMapping("/create")
    public ResponseEntity<CoachDTO> createCoach(@RequestBody CoachDTO dto){
        return new ResponseEntity<>(coachService.createCoach(dto), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<CoachDTO> editCoach(@RequestBody CoachDTO dto){
        return ResponseEntity.ok(coachService.editCoach(dto));
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoach(){
        return ResponseEntity.ok(coachService.findAllCoaches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> findCoach(@PathVariable String id){
        return ResponseEntity.ok(coachService.findCoach(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CoachDTO>> getCoachByName(@RequestParam("name") String name){
        return ResponseEntity.ok(coachService.searchByName(name));
    }

    @PostMapping("/achievements/{coach_id}")
    public ResponseEntity<String> setAchievement(@RequestBody Achievements achievements, @PathVariable String coach_id){
        return ResponseEntity.ok(coachService.setAchievements(achievements,coach_id));
    }

    @GetMapping("/requests/{coach_id}")
    public ResponseEntity<List<AssistanceRequestDTO>> getAssistanceRequest(@PathVariable String coach_id){
        return ResponseEntity.ok(coachService.getAssistanceRequests(coach_id));
    }

    @PostMapping("/request/approve/{req_id}")
    public ResponseEntity<String> approveRequest(@PathVariable String req_id){
        return ResponseEntity.ok(coachService.approveRequest(req_id));
    }

    @PostMapping("/request/decline/req_id")
    public ResponseEntity<String> declineRequest(@PathVariable String req_id){
        return ResponseEntity.ok(coachService.declineRequest(req_id));
    }
}
