/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HelloController
 * Author:   zhoulei
 * Date:     2018/5/11 下午3:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.controller;

import masterspringmvc.gracedemo.beans.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/11
 * @since 1.0.0
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    private String hello(Model model){
        model.addAttribute("message","Hello from the controller");
        return "resultPage";

    }


    @RequestMapping("/mytest")
    private String test(Model model){
        model.addAttribute("search","微博");

        List users = new ArrayList();
        UserBean user = new UserBean();
        user.setId(1);
        user.setName("zs");
        users.add(user);

        model.addAttribute("user",users);
        return "resultTest";
    }

    @RequestMapping("/searchPage")
    private String searchPage(){
        return "searchPage";
    }

    @RequestMapping("/searchPageTwo")
    private String searchPageTwo(){
        return "searchPageTwo";
    }

    @RequestMapping(value = "/postSearch",method = RequestMethod.POST)
    private String searchUser(HttpServletRequest request,
                              RedirectAttributes redirectAttributes){
        String search = request.getParameter("search");
        //检查错误
        if (search.toLowerCase().contains("sex")){
            redirectAttributes.addAttribute("error","违法字段，禁止搜索！！");
            return "redirect:searchPage";
        }
        redirectAttributes.addAttribute("search",search);
        return "redirect:mytest";
    }



}
