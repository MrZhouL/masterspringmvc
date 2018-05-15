/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ResultBean
 * Author:   zhoulei
 * Date:     2018/5/13 上午11:05
 * Description: 统一的Controller返回bean
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈所以的controller都返回该对象〉<br>
 * 〈统一的Controller返回bean〉
 *
 * @author zhoulei
 * @create 2018/5/13
 * @since 1.0.0
 */
@Data
public class ResultBean<T> implements Serializable {

    public static final int NO_LOGIN = -1;
    public static final int SUECCESS = 0;
    public static final int FAIL = 1;
    public static final int NO_PERMISSION = 2;

    private String msg = "SUCCESS";

    private int code = SUECCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean (T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable t){
        super();
        this.msg = t.getMessage();
        this.code = FAIL;
    }
}
