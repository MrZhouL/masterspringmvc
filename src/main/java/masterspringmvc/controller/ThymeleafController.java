/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ThymeleafController
 * Author:   zhoulei
 * Date:     2018/5/17 下午9:56
 * Description: 模版学习导航控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.controller;

import masterspringmvc.gracedemo.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈模版学习导航控制器〉
 *
 * @author zhoulei
 * @create 2018/5/17
 * @since 1.0.0
 */
@Controller
public class ThymeleafController {

    @GetMapping("/thymeleafOne")
    public String index(UserBean userBean){
        return userBean!= null ? "learnthymeleaf/homeSignedIn" : "learnthymeleaf/homeNotSignedIn";
    }

    @GetMapping("/themeByFooter")
    public String themeByFooter(){
        return "learnthymeleaf/thymeleafthmembyfooter";
    }

    @GetMapping("/thymeleafthmemmbycommon")
    public String themeByCommonResources(){
        return "learnthymeleaf/thymeleafthmemmbycommon";
    }
}
