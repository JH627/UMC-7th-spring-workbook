package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.MissionStatus;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import umc.study.validation.annotation.RunningMission;

@Component
@RequiredArgsConstructor
public class RunningMissionValidator implements ConstraintValidator<RunningMission, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(RunningMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isValid = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(
                1L, missionId, MissionStatus.CHALLENGING);

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_CHALLENGING.toString()).addConstraintViolation();
        }

        return !isValid;
    }
}
