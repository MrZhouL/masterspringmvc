/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ControllerLogAspect
 * Author:   zhoulei
 * Date:     2018/5/14 下午3:02
 * Description: 打印controller里的日志
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈打印controller里的日志〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
//@ControllerAdvice
public class ControllerLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    /*@ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        logger.error(e.getMessage());  // 记录错误信息
        return null;
    }*/

    /*public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }*/

}
