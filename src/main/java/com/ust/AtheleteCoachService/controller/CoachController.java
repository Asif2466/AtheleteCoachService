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
@RequestMapping("api/c1/coaches")
public class CoachController {

    private CoachService coachService;

    @PostMapping("/create")
    public ResponseEntity<CoachDTO> createCoach(CoachDTO dto){
        return new ResponseEntity<>(coachService.createCoach(dto), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<CoachDTO> editCoach(CoachDTO dto){
        return ResponseEntity.ok(coachService.editCoach(dto));
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoach(){
        return ResponseEntity.ok(coachService.findAllCoaches());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CoachDTO>> getCoachByName(@RequestParam String name){
        return ResponseEntity.ok(coachService.searchByName(name));
    }

    @GetMapping("/achievements/{coach_id}")
    public ResponseEntity<String> setAchievement(@RequestBody Achievements achievements, @PathVariable int coach_id){
        return ResponseEntity.ok(coachService.setAchievements(achievements,coach_id));
    }

    @GetMapping("/requests/{coach_id}")
    public ResponseEntity<List<AssistanceRequestDTO>> getAssistanceRequest(@PathVariable int coach_id){
        return ResponseEntity.ok(coachService.getAssistanceRequests(coach_id));
    }

    @PostMapping("/request/approve/{req_id}")
    public ResponseEntity<String> approveRequest(@PathVariable Long req_id){
        return ResponseEntity.ok(coachService.approveRequest(req_id));
    }

    @PostMapping("request/decline/req_id")
    public ResponseEntity<String> declineRequest(@PathVariable Long req_id){
        return ResponseEntity.ok(coachService.declineRequest(req_id));
    }
}
