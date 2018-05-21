/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProfileController
 * Author:   zhoulei
 * Date:     2018/5/14 上午11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.controller;

import masterspringmvc.beans.ProfileForm;
import masterspringmvc.date.LocalDateFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.InetAddress;
import java.util.Locale;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/14
 * @since 1.0.0
 */
@Controller
public class ProfileController {
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping("/pofile")
    public String displayProfile(ProfileForm profileForm){
        return "profilePage";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm,BindingResult bindingResult){
        System.out.println("save ok"+profileForm);
        logger.debug("add profile Form:"+profileForm.toString());
        if (bindingResult.hasErrors()){
            return "profilePage";
        }
        return "redirect:pofile";
    }

    /**
     * 为了前端显示输入日期的格式
     * @param locale
     * @return
     */
    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {

        String pattern = LocalDateFormatter.getPattern(locale);
        return pattern;
    }

    @RequestMapping(value = "/profile", params = {"addTaste"})
    public String addRow(ProfileForm profileForm) {
        profileForm.getTastes().add(null);
        return "profilePage";
    }
    @RequestMapping(value = "/profile", params = {"removeTaste"})
    public String removeRow(ProfileForm profileForm, HttpServletRequest req) {
        Integer rowId = Integer.valueOf(req.getParameter("removeTaste"));
        profileForm.getTastes().remove(rowId.intValue());
        return "profilePage";
    }

    @RequestMapping("/profilePageT")
    public String learnThymeleafToProfilePage(){
        return "learnthymeleaf/profilePageT";
    }

    @RequestMapping("/backgroundlayout")
    public String backgroundlayout(){
        return "learnthymeleaf/backgroundlayout";
    }
}
