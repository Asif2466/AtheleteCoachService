package com.ust.AtheleteCoachService.service;

import com.ust.AtheleteCoachService.convertor.Convertor;
import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;
import com.ust.AtheleteCoachService.exception.AthleteNotFoundException;
import com.ust.AtheleteCoachService.exception.CoachNotFoundException;
import com.ust.AtheleteCoachService.exception.DuplicateAthleteException;
import com.ust.AtheleteCoachService.exception.DuplicateRequestException;
import com.ust.AtheleteCoachService.model.AssistanceRequest;
import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.model.Coach;
import com.ust.AtheleteCoachService.repository.AssistanceRequestRepository;
import com.ust.AtheleteCoachService.repository.AthleteRepository;
import com.ust.AtheleteCoachService.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AthleteServiceImpl implements AthleteService{

    private AthleteRepository athleteRepository;

    private CoachRepository coachRepository;

    private AssistanceRequestRepository assistanceRequestRepository;

    @Override
    public AthleteDTO createAthlete(AthleteDTO dto) {
       athleteRepository.findByEmail(dto.email())
               .ifPresent(
                       a ->{ throw new DuplicateAthleteException("Athlete Already exist");}
               );
       Athlete athlete = Convertor.toAthlete(dto);
        athlete.setAthleteId("ATH" + String.format("%05d", generateSequenceNumber()));
        //athlete.getCoach().setCoachId("Not Assigned");
        athleteRepository.save(athlete);
       return new AthleteDTO(
               athlete.getAthleteId(),
                    athlete.getFirstName(),
               athlete.getLastName(),
               athlete.getDOB(),
               athlete.getEmail(),
               athlete.getGender(),
               athlete.getHeight(),
               "Not Assigned"
               );
    }
    private int generateSequenceNumber() {
        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
        // Here, we'll just return a random number for illustration purposes
        return (int) (Math.random() * 100000); // Replace with real sequence logic
    }

    @Override
    public AthleteDTO editAthlete(AthleteDTO dto, String id) {
        Athlete athlete = athleteRepository.findByAthleteId(id)
                .orElseThrow(
                        ()-> new AthleteNotFoundException("Athlete not found")
                );

        /*
        TODO => instead of findByEmail use user_id after implementing the authentication service
         */


        if(!dto.firstName().equals(athlete.getFirstName())){
            athlete.setFirstName(dto.firstName());
        }
        if(!dto.lastName().equals(athlete.getLastName())){
            athlete.setLastName(dto.lastName());
        }
        if(!dto.email().equals(athlete.getEmail())){
            athlete.setEmail(dto.email());
        }
        if(!dto.DOB().equals(athlete.getDOB())){
            athlete.setDOB(dto.DOB());
        }
        if(!dto.height().equals(athlete.getHeight())){
            athlete.setHeight(dto.height());
        }
        if(!dto.gender().equals(athlete.getGender())){
            athlete.setGender(dto.gender());
        }

        Athlete updatedAthlete = athleteRepository.save(athlete);

        if(updatedAthlete.getCoach()==null){
            return new AthleteDTO(
                    updatedAthlete.getAthleteId(),
                    updatedAthlete.getFirstName(),
                    updatedAthlete.getLastName(),
                    updatedAthlete.getDOB(),
                    updatedAthlete.getEmail(),
                    updatedAthlete.getGender(),
                    updatedAthlete.getHeight(),
                    "Not Assigned"
            );
        }
        return new AthleteDTO(
                updatedAthlete.getAthleteId(),
                updatedAthlete.getFirstName(),
                updatedAthlete.getLastName(),
                updatedAthlete.getDOB(),
                updatedAthlete.getEmail(),
                updatedAthlete.getGender(),
                updatedAthlete.getHeight(),
                updatedAthlete.getCoach().getCoachId()
        );
    }

    @Override
    public AthleteDTO findAthlete(String id) {
        Optional<Athlete> athlete = athleteRepository.findByAthleteId(id);
        if(athlete.get().getCoach()==null){
            return new AthleteDTO(
                    athlete.get().getAthleteId(),
                    athlete.get().getFirstName(),
                    athlete.get().getLastName(),
                    athlete.get().getDOB(),
                    athlete.get().getEmail(),
                    athlete.get().getGender(),
                    athlete.get().getHeight(),
                    "Not Assigned"
            );
        }
        return new AthleteDTO(
                athlete.get().getAthleteId(),
                athlete.get().getFirstName(),
                athlete.get().getLastName(),
                athlete.get().getDOB(),
                athlete.get().getEmail(),
                athlete.get().getGender(),
                athlete.get().getHeight(),
                athlete.get().getCoach().getCoachId()
        );

    }

    @Override
    public List<AthleteDTO> findAllAthletes() {

        List<Athlete> athletes = athleteRepository.findAll();
        List<AthleteDTO> athleteDTOS = new ArrayList<>();
        for(Athlete athlete: athletes){
            if(athlete.getCoach()==null){
                athleteDTOS.add(new AthleteDTO(athlete.getAthleteId(), athlete.getFirstName(),
                                    athlete.getLastName(),athlete.getDOB(),athlete.getEmail(),athlete.getGender(),
                                   athlete.getHeight(),"Not Assigned"));
            }
            else{
                athleteDTOS.add(new AthleteDTO(athlete.getAthleteId(), athlete.getFirstName(),
                        athlete.getLastName(),athlete.getDOB(),athlete.getEmail(),athlete.getGender(),
                        athlete.getHeight(),athlete.getCoach().getCoachId()));
            }
        }
        return athleteDTOS;
//        return athletes.stream().map(athlete -> new AthleteDTO(athlete.getAthleteId(), athlete.getFirstName(),
//                                    athlete.getLastName(),athlete.getDOB(),athlete.getEmail(),athlete.getGender(),
//                                    athlete.getHeight(),athlete.getCoach().getCoachId()
//                )).toList();
    }

    @Override
    public AssistanceRequestDTO requestAssistance(AssistanceRequestDTO dto, String Athlete_id) {
        /*
        TODO => instead of findByEmail use user_id after implementing the authentication service
         */
        Optional<Athlete> athlete = athleteRepository.findByAthleteId(Athlete_id);
        if(athlete.isPresent()){
            Optional<Coach> coach = coachRepository.findByCoachId(dto.coach_id());
            if(coach.isPresent()) {
                boolean existingRequest = assistanceRequestRepository.existsByCoachAndAthlete(coach.get(), athlete.get());
                if (existingRequest) {
                    throw new DuplicateRequestException("Request has been already sent...");
                }
                AssistanceRequest assistanceRequest = Convertor.toAssistanceRequest(dto, athlete.get(), coach.get());
                assistanceRequest.setReqid("REQ" + String.format("%05d", ReqGenerateSequenceNumber()));
                assistanceRequestRepository.save(assistanceRequest);
                return new AssistanceRequestDTO(
                        assistanceRequest.getReqid(),
                        assistanceRequest.getCoach().getCoachId(),
                        assistanceRequest.getRemark(),
                        assistanceRequest.getMerits(),
                        assistanceRequest.getGoal(),
                        assistanceRequest.getAthlete().getAthleteId()
                );
            }
            else{
                throw new CoachNotFoundException("Coach not found");
            }
        }
        else{
            throw new AthleteNotFoundException("Athlete Not found");
        }
    }
    private int ReqGenerateSequenceNumber() {
        // You need to implement actual logic here (query DB for max ID or use a sequence generator)
        // Here, we'll just return a random number for illustration purposes
        return (int) (Math.random() * 100000); // Replace with real sequence logic
    }

}
