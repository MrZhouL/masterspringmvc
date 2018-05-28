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
import masterspringmvc.gracedemo.dao.UserRepository;
import masterspringmvc.gracedemo.exceptions.EntotyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    private UserRepository userRepository;

    @Autowired
    public RestProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResultBean allUser(){
       /* List users = new ArrayList();
        users.add(new UserBean(1,"zs"));
        users.add(new UserBean(2,"ls"));
        users.add(new UserBean(3,"ww"));*/
        return new ResultBean(userRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResultBean saveProfile(@Validated @RequestBody UserBean userBeand){
        UserBean userBean = userRepository.save(userBeand);
        return new ResultBean(userBean);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<UserBean> delectUser(@PathVariable Integer id){
        if (!userRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<UserBean> delete(@PathVariable Integer id) throws EntotyNotFoundException {
        if (!userRepository.existsById(id)){
            throw new EntotyNotFoundException("User id:"+ id + " cannot be found!!");
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserBean> findById(@PathVariable Integer id) throws EntotyNotFoundException {
        if (!userRepository.existsById(id)){
            throw new EntotyNotFoundException("User id:"+ id + " cannot be found!!");
        }

        Optional<UserBean> user = userRepository.findById(id);

        return new ResponseEntity<UserBean>(user.get(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Validated @RequestBody UserBean userBeand) throws EntotyNotFoundException {
        if (!userRepository.existsById(userBeand.getId())){
            throw new EntotyNotFoundException("User id:"+ userBeand.getId() + " cannot be found!!");
        }

        UserBean userBean = userRepository.save(userBeand);
        return new ResponseEntity(userBean,HttpStatus.OK);
    }
}
