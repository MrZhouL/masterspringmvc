package masterspringmvc.date;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * 定义注解，匹配yyyy-MM-dd格式的时间字符串
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CnFormatterDate.CnFormatterDateValidator.class)
@Documented
public @interface CnFormatterDate {
    String message() default "{javax.validation.constraints.Past.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class CnFormatterDateValidator implements ConstraintValidator<CnFormatterDate, LocalDate> {
        public void initialize(CnFormatterDate past) {}

        public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
            String regex = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
            Pattern p = Pattern.compile(regex);
            return localDate == null || p.matcher(localDate.toString()).matches();
        }
    }
}
