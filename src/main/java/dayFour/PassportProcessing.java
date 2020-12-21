package dayFour;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static input.InputReader.getStringListWithEmptyLines;

public class PassportProcessing {

    private final List<String> passportList;

    public PassportProcessing(String filename) {
        this.passportList = getStringListWithEmptyLines(filename);
    }

    public int partOne() {

        List<String> fields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        int invalidPassportCount = 0;

        for(String passport : passportList) {
            for(String field : fields) {
                if (!passport.contains(field)) {
                    System.out.println("Missing: "+field+" | "+passport);
                    invalidPassportCount++;
                    break;
                }
            }
        }

        return passportList.size() - invalidPassportCount;

    }

    public int partTwo() {

//        eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        int validPassportCount = 0;

        for(String passportString : passportList) {
            Passport passport = new Passport();
            String[] fields = passportString.split(" ");
            for (String field : fields) {
                String[] keyValues = field.split(":");
                //todo there will be an easier way to do this
                passport.setField(keyValues[0], keyValues[1]);
            }

            Set<ConstraintViolation<Passport>> violations = validator.validate(passport);

            if(violations.isEmpty()) {
                System.out.println("Valid passport: "+passport.toString());
                validPassportCount++;
            } else {
            }
        }

        return validPassportCount;

    }

}
