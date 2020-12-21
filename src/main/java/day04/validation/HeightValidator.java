package day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HeightValidator implements ConstraintValidator<ValidHeight, String> {

    @Override
    public void initialize(ValidHeight constraintAnnotation) {
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintValidatorContext) {

        if(object == null) {
            return false;
        }

        if(object.length() < 4) {
            return false;
        }

        String unit = object.substring(object.length() - 2);
        int amount = Integer.valueOf(object.substring(0, object.length() - 2));

        if(unit.equals("cm")) {
           return amount >= 150 && amount <= 193;
        }

        if(unit.equals("in")) {
            return amount >= 59 && amount <= 76;
        }

        return false;
    }

}
