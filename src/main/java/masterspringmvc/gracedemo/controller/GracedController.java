/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GracedController
 * Author:   zhoulei
 * Date:     2018/5/12 下午11:17
 * Description: 基于编程规范创建的Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.controller;

import masterspringmvc.gracedemo.beans.UserBean;
import masterspringmvc.gracedemo.common.ResultBean;
import masterspringmvc.gracedemo.services.GracedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br> 
 * 〈基于编程规范创建的Controller〉
 *
 * @author zhoulei
 * @create 2018/5/12
 * @since 1.0.0
 */
@Controller
public class GracedController {
    @Autowired
    private GracedService gracedService;

    @RequestMapping("/allUser")
    private ResultBean allUser(){

        return new ResultBean();
    }

    @RequestMapping("/addUser")
    private ResultBean addUser(@Valid UserBean user){
        return new ResultBean(gracedService.addUser(user));
    }
}
