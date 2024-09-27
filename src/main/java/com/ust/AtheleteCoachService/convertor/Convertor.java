package com.ust.AtheleteCoachService.convertor;

import com.ust.AtheleteCoachService.dto.AssistanceRequestDTO;
import com.ust.AtheleteCoachService.dto.AthleteDTO;
import com.ust.AtheleteCoachService.dto.CoachDTO;
import com.ust.AtheleteCoachService.model.AssistanceRequest;
import com.ust.AtheleteCoachService.model.Athlete;
import com.ust.AtheleteCoachService.model.Coach;
import com.ust.AtheleteCoachService.model.RequestStatus;

import java.util.ArrayList;

public class Convertor {

    public static Athlete toAthlete(AthleteDTO dto){
        if(dto == null){
            return null;
        }
        else{
            return new Athlete(null, dto.firstName(),
                    dto.lastName(),
                    dto.DOB(),
                    dto.email(),
                    dto.gender(),
                    dto.height(),
                    null,
                    null
                    );
        }
    }

    public static Coach toCoach(CoachDTO dto){
        if(dto==null){
            return null;
        }
        else{
            return new Coach(null,
                    dto.firstName(),
                    dto.lastName(),
                    dto.DOB(),
                    dto.email(),
                    dto.gender(),
                    new ArrayList<>(),
                    new ArrayList<>()
                    );
        }
    }

    public static AssistanceRequest toAssistanceRequest(AssistanceRequestDTO dto, Athlete athlete, Coach coach){
        if(dto==null){
            return null;
        }
        else{
            return new AssistanceRequest(null,
                    athlete,
                    dto.merits(),
                    dto.goal(),
                    dto.remarks(),
                    RequestStatus.PENDING,
                    coach
                    );
        }
    }

}
