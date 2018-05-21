/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: PastLocalDate
 * Author:   zhoulei
 * Date:     2018/5/14 下午2:16
 * Description: 自定义校验注解类---校验时间都是过去的
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.date;


import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义校验注解类---校验时间都是过去的〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastLocalDate.PastValidator.class)
@Documented
public @interface PastLocalDate {
    String message() default "{javax.validation.constraints.Past.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    class PastValidator implements ConstraintValidator<PastLocalDate, LocalDate> {
        public void initialize(PastLocalDate past) {
        }
        public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
            //关闭默认的消息方法
            context.disableDefaultConstraintViolation();
            return localDate == null || localDate.isBefore(LocalDate.now());
        }
    }
}
