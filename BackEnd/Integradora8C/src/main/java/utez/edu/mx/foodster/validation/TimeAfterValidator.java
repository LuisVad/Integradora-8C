package utez.edu.mx.foodster.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import java.sql.Timestamp;

public class TimeAfterValidator implements ConstraintValidator<TimeAfter, Object> {
    private String startFieldName;
    private String endFieldName;

    @Override
    public void initialize(TimeAfter constraintAnnotation) {
        this.startFieldName = constraintAnnotation.start();
        this.endFieldName = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Timestamp startTime = (Timestamp) new BeanWrapperImpl(value).getPropertyValue(startFieldName);
        Timestamp endTime = (Timestamp) new BeanWrapperImpl(value).getPropertyValue(endFieldName);
        return startTime == null || endTime == null || endTime.after(startTime);
    }
}