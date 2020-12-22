package day04;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static utils.Utils.getGroupedLines;

public class PassportProcessing {

    private final List<String> passportList;

    public PassportProcessing(String filename) {
        this.passportList = getGroupedLines(filename);
    }

    public int partOne() {

        List<String> fields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        int invalid = 0;

        for(String passport : passportList) {
            for(String field : fields) {
                if (!passport.contains(field)) {
                    invalid++;
                    break;
                }
            }
        }

        return passportList.size() - invalid;

    }

    public int partTwo() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int valid = 0;

        for(String passportString : passportList) {
            Passport passport = new Passport();
            String[] fields = passportString.split(" ");
            for (String field : fields) {
                String[] keyValues = field.split(":");
                // this is not ideal
                passport.setField(keyValues[0], keyValues[1]);
            }

            Set<ConstraintViolation<Passport>> violations = validator.validate(passport);

            if(violations.isEmpty()) {
                valid++;
            }
        }

        return valid;

    }

}
