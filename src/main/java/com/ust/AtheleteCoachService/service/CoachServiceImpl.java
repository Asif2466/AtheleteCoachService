package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.convertor.Convertor;
import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.CoachDTO;
import com.ust.AtheleteCoachService.exception.CoachNotFoundException;
import com.ust.AtheleteCoachService.exception.DuplicateCoachException;
import com.ust.AtheleteCoachService.exception.RequestNotFoundException;
import com.ust.AtheleteCoachService.model.*;
import com.ust.AtheleteCoachService.repository.AchievementRepository;
import com.ust.AtheleteCoachService.repository.AssistanceRequestRepository;
import com.ust.AtheleteCoachService.repository.AthleteRepository;
import com.ust.AtheleteCoachService.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoachServiceImpl implements CoachService{

    private AthleteRepository athleteRepository;

    private CoachRepository coachRepository;

    private AchievementRepository achievementRepository;

    private AssistanceRequestRepository assistanceRequestRepository;

    @Override
    public CoachDTO createCoach(CoachDTO dto) {
        coachRepository.findByEmail(dto.email())
                .ifPresent(
                        a -> { throw new DuplicateCoachException("Coach already exists");}
                );
        Coach coach = coachRepository.save(Convertor.toCoach(dto));
        return dto;
    }

    @Override
    public CoachDTO editCoach(CoachDTO dto) {
        coachRepository.findByEmail(dto.email())
                .ifPresent(
                        a -> { throw new CoachNotFoundException("Coach not found");}
                );
    /*
        TODO => instead of findByEmail use user_id after implementing the authentication service
         */
        Coach coach = coachRepository.findByEmail(dto.email()).get();
        if(!dto.firstName().equals(coach.getFirstName())){
            coach.setFirstName(dto.firstName());
        }
        if(!dto.lastName().equals(coach.getLastName())){
            coach.setLastName(dto.lastName());
        }
        if(!dto.gender().equals(coach.getGender())){
            coach.setGender(dto.gender());
        }
        if(!dto.DOB().equals(coach.getDOB())){
            coach.setDOB(dto.DOB());
        }
        if(!dto.email().equals(coach.getEmail())){
            coach.setEmail(dto.email());
        }
        coachRepository.save(coach);
        return dto;
    }

    @Override
    public List<CoachDTO> findAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream().map(coach -> new CoachDTO(coach.getFirstName(),
                coach.getLastName(), coach.getDOB(), coach.getEmail(), coach.getGender()
                )).toList();
    }

    @Override
    public List<CoachDTO> searchByName(String name) {
        List<Coach> coaches = coachRepository.findAllByFirstNameContainingIgnoreCase(name);
        return coaches.stream().map(coach -> new CoachDTO(coach.getFirstName(),
                coach.getLastName(), coach.getDOB(), coach.getEmail(), coach.getGender()
        )).toList();
    }

    @Override
    public String setAchievements(Achievements achievements, int id) {
        coachRepository.findById(id).orElseThrow(
                () -> new CoachNotFoundException("Coach Not Found")
        );
    /*
        TODO => instead of id use user_id after implementing the authentication service
         */
        Coach coach = coachRepository.findById(id).get();
        //coach.getAchievements().add(achievementRepository.save(achievements));
        coachRepository.save(coach);
        return "Achievement successfully added";
    }

    @Override
    public List<AssistanceRequestDTO> getAssistanceRequests(int coach_id) {
        Coach coach = coachRepository.findById(coach_id).orElseThrow(
                ()->  new CoachNotFoundException("coach Not found")
        );
        List<AssistanceRequest> requests = assistanceRequestRepository.findAllByCoachAndStatus(coach, RequestStatus.PENDING);
        return requests.stream().map(req -> new AssistanceRequestDTO(req.getCoach().getCoachId(),
                                                            req.getRemark(),
                                                            req.getMerits(),
                                                            req.getGoal()
                )).toList();
    }

    @Override
    public String approveRequest(long req_id) {
        AssistanceRequest request = assistanceRequestRepository.findById(req_id).orElseThrow(
                ()-> new RequestNotFoundException("Request Not found")
        );
        request.setStatus(RequestStatus.APPROVED);
        assistanceRequestRepository.save(request);
        Coach coach = request.getCoach();
        Athlete athlete = request.getAthlete();

       // coach.getAthletes().add(athlete);
        athlete.setCoach(coach);

        athleteRepository.save(athlete);
        coachRepository.save(coach);
        return "Request Has been APPROVED";
    }

    @Override
    public String declineRequest(long req_id) {
        AssistanceRequest request = assistanceRequestRepository.findById(req_id).orElseThrow(
                ()-> new RequestNotFoundException("Request Not found")
        );
        request.setStatus(RequestStatus.REJECTED);
        assistanceRequestRepository.save(request);
        return "Request has been REJECTED";
    }
}
