/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ValidateTool
 * Author:   zhoulei
 * Date:     2018/5/15 上午2:20
 * Description: 校验自定义异常，并抛出！！
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.utils;

import masterspringmvc.gracedemo.exceptions.CheckException;
import org.springframework.validation.BindingResult;

/**
 * 〈一句话功能简述〉<br> 
 * 〈校验自定义异常，并抛出！！〉
 *
 * @author zhoulei
 * @create 2018/5/15
 * @since 1.0.0
 */
public class ValidateTool {
    /**
     * 校验字段
     * @param bindingResult
     */
    public static void validateField(BindingResult bindingResult){
        throw new CheckException(ErrorMessage.getFieldErrorMessage(bindingResult));
    }

}
