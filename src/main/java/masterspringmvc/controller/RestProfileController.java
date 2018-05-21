/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RestProfileController
 * Author:   zhoulei
 * Date:     2018/5/15 下午6:26
 * Description: 测试rest格式的校验信息配置加载问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.controller;

import masterspringmvc.gracedemo.beans.UserBean;
import masterspringmvc.gracedemo.common.ResultBean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试rest格式的校验信息配置加载问题〉
 *
 * @author zhoulei
 * @create 2018/5/15
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/user")
public class RestProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public ResultBean allUser(){
        List users = new ArrayList();
        users.add(new UserBean(1,"zs"));
        users.add(new UserBean(2,"ls"));
        users.add(new UserBean(3,"ww"));
        return new ResultBean(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResultBean saveProfile(@Validated @RequestBody UserBean userBeand){

        return new ResultBean(userBeand);
    }
}
