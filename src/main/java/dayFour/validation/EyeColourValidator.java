package dayFour.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EyeColourValidator implements ConstraintValidator<ValidEyeColour, String> {

    private List<String> acceptedValues;

    @Override
    public void initialize(ValidEyeColour annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintValidatorContext) {

        if(object == null) {
            return false;
        }

        return acceptedValues.contains(object);
    }

}
