/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProfileForm
 * Author:   zhoulei
 * Date:     2018/5/14 上午11:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.beans;

import lombok.Data;
import masterspringmvc.date.CnFormatterDate;
import masterspringmvc.date.PastLocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
@Data
public class ProfileForm {
    @Size(min = 2,max = 10)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    @PastLocalDate
    @DateTimeFormat
 //   @CnFormatterDate
    private LocalDate birthDate;

    @NotEmpty
    private List<String> tastes = new ArrayList<>();
}
