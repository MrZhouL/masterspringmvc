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

import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.util.Locale;


/**
 * 〈一句话功能简述〉<br>
 * 〈统一的控制器异常处理切面类〉
 *
 * @author zhoulei
 * @create 2018/5/13
 * @since 1.0.0
 */
@ControllerAdvice
public class ControllerExceptionHandlerAdvice{

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandlerAdvice.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBean<?> handlerControllerMethod(MethodArgumentNotValidException exception){

        /*if (exception instanceof CheckException){
            resultBean.setMsg(exception.getMessage());
            resultBean.setCode(ResultBean.FAIL);
        }else if(exception instanceof UnLogininException){
            resultBean.setMsg("UnLogin");
            resultBean.setCode(ResultBean.FAIL);
        }else {
            //未知异常可以发送邮件
            resultBean.setMsg(exception.getMessage());
            resultBean.setCode(resultBean.FAIL);
        }*/
        BindingResult bindingResult = exception.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();

        return processFieldError(fieldError);
    }

    @ExceptionHandler({JsonParseException.class})
    @ResponseBody
    public ResultBean<?> handlerJsonParseException(JsonParseException exception){
        ResultBean resultBean = new ResultBean();
        Locale locale = LocaleContextHolder.getLocale();

        resultBean.setCode(ResultBean.FAIL);
        String erroeMeg = messageSource.getMessage("error.json.format",null,locale);
        resultBean.setMsg(erroeMeg);
        log.info("自定义异常信息装配: -- [{}]",erroeMeg);
        return resultBean;
    }


    /**
     * 字段错误信息封装
     * @param fieldError
     * @param errorCode
     * @return
     */
    private ResultBean<?> processFieldError(FieldError fieldError, String... errorCode) {
        ResultBean<?> resultBean = null;
        if (fieldError != null){
            Locale locale = LocaleContextHolder.getLocale();
            //通过MessageSource来获取配置文件中的验证信息
            String message = messageSource.getMessage(fieldError.getDefaultMessage(), null, locale);

            resultBean = new ResultBean<>();
            resultBean.setMsg(message);
            resultBean.setCode(ResultBean.FAIL);
        }
        log.info("自定义异常信息装配: -- [{}]",resultBean.toString());
        return resultBean;
    }

    /**
     * 全局处理MultipartException
     * @param exception
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    public ModelAndView handleMultipartExceptioin(MultipartException exception){
        log.info("进入MultipartException异常处理方法 : 异常消息如下-- [{}]",exception.getMessage());
        return processMultipartError(exception);
    }

    private ModelAndView processMultipartError(MultipartException exception) {
        ModelAndView modelAndView = null;
        if (exception != null){
            Locale locale = LocaleContextHolder.getLocale();
            modelAndView = new ModelAndView("uploadPage");
            String errorMessage = messageSource.getMessage("upload.file.too.big",null,locale);
            modelAndView.addObject("error",errorMessage);

            log.info("自定义异常信息装配: -- [{}]",errorMessage);
        }

        return modelAndView;
    }

}
