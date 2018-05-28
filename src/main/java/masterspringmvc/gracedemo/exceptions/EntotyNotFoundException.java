/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: EntotyNotFoundException
 * Author:   zhoulei
 * Date:     2018/5/24 下午3:13
 * Description: 业务异常--实体找不到异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.exceptions;

/**
 * 〈一句话功能简述〉<br> 
 * 〈业务异常--实体找不到异常〉
 *
 * @author zhoulei
 * @create 2018/5/24
 * @since 1.0.0
 */
public class EntotyNotFoundException extends Exception{

    public EntotyNotFoundException() {
    }

    public EntotyNotFoundException(String message) {
        super(message);
    }

    public EntotyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
