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
       athleteRepository.save(Convertor.toAthlete(dto));
       return dto;
    }

    @Override
    public AthleteDTO editAthlete(AthleteDTO dto) {
        athleteRepository.findByEmail(dto.email())
                .orElseThrow(
                        ()-> new AthleteNotFoundException("Athlete not found")
                );

        /*
        TODO => instead of findByEmail use user_id after implementing the authentication service
         */

        Athlete athlete = athleteRepository.findByEmail(dto.email()).get();
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

        athleteRepository.save(athlete);
        return dto;
    }

    @Override
    public AssistanceRequestDTO requestAssistance(AssistanceRequestDTO dto, int Athlete_id) {
        /*
        TODO => instead of findByEmail use user_id after implementing the authentication service
         */
        Optional<Athlete> athlete = athleteRepository.findById(Athlete_id   );
        if(athlete.isPresent()){
            Optional<Coach> coach = coachRepository.findById(dto.coach_id());
            if(coach.isPresent()) {
                boolean existingRequest = assistanceRequestRepository.existsByCoachAndAthlete(coach.get(), athlete.get());
                if (existingRequest) {
                    throw new DuplicateRequestException("Request has been already sent...");
                }
                AssistanceRequest assistanceRequest = Convertor.toAssistanceRequest(dto, athlete.get(), coach.get());
                assistanceRequestRepository.save(assistanceRequest);
                return dto;
            }
            else{
                throw new CoachNotFoundException("Coach not found");
            }
        }
        return null;
    }

}
