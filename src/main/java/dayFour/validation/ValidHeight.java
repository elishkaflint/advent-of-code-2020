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

@Constraint(validatedBy = HeightValidator.class)
@Target({ METHOD, CONSTRUCTOR, FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface ValidHeight {

    String message() default "Height is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

