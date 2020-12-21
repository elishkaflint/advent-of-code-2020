package day04;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {

    @Test
    public void testValidation() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Passport passport = new Passport();
        passport.setField("pid","087499704");
        passport.setField("hgt","74in");
        passport.setField("ecl","grn");
        passport.setField("iyr","2012");
        passport.setField("eyr","2030");
        passport.setField("byr","1980");
        passport.setField("hcl","#623a2f");

        Set<ConstraintViolation<Passport>> violations = validator.validate(passport);

        assertEquals(0, violations.size());
    }
}
