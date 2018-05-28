/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: EntityNotFoundMapper
 * Author:   zhoulei
 * Date:     2018/5/24 下午3:19
 * Description: 业务异常--实体找不到异常处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 〈一句话功能简述〉<br> 
 * 〈业务异常--实体找不到异常处理类〉
 *
 * @author zhoulei
 * @create 2018/5/24
 * @since 1.0.0
 */
@RestControllerAdvice
public class EntityNotFoundMapper {

    @ExceptionHandler(EntotyNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "用户不存在！！")
    public void handleNotFound(){
    }
}
