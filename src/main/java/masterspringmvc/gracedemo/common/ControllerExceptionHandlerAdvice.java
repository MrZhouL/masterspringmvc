/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ControllerExceptionHandlerAspect
 * Author:   zhoulei
 * Date:     2018/5/13 上午11:33
 * Description: 统一的控制器异常处理切面类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.common;

import masterspringmvc.gracedemo.exceptions.CheckException;
import masterspringmvc.gracedemo.exceptions.UnLogininException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * 〈一句话功能简述〉<br>
 * 〈统一的控制器异常处理切面类〉
 *
 * @author zhoulei
 * @create 2018/5/13
 * @since 1.0.0
 */
@ControllerAdvice
public class ControllerExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandlerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean<?> handlerControllerMethod(Exception exception){
        ResultBean<?> resultBean = new ResultBean<>();
        log.info("进入异常处理方法 : 异常消息如下-- [{}]",exception.getMessage());
        if (exception instanceof CheckException){
            resultBean.setMsg(exception.getMessage());
            resultBean.setCode(ResultBean.FAIL);
        }else if(exception instanceof UnLogininException){
            resultBean.setMsg("UnLogin");
            resultBean.setCode(ResultBean.FAIL);
        }else {
            //未知异常可以发送邮件
            resultBean.setMsg(exception.getMessage());
            resultBean.setCode(resultBean.FAIL);
        }
        return resultBean;
    }

}
