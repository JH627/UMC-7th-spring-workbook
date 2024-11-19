package umc.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

// 사용자 정의 어노테이션을 만들 때 붙임
@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
// 어노테이션 적용 범위 지정
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
// 어노테이션의 생명 주기 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
