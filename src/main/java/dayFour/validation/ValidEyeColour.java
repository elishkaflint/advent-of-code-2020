package dayFour.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = EyeColourValidator.class)
@Target({ METHOD, CONSTRUCTOR, FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface ValidEyeColour {

    Class<? extends Enum<?>> enumClass();

    String message() default "Eye colour must be one of {enumClass}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

