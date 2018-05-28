/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserRepositoryImpl
 * Author:   zhoulei
 * Date:     2018/5/24 下午3:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.dao;

import masterspringmvc.gracedemo.exceptions.EntotyNotFoundException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/24
 * @since 1.0.0
 */
public abstract class UserRepositoryImpl implements UserRepository{
    public void delect(Integer id) throws EntotyNotFoundException {
        if (!existsById(id)){
            throw new EntotyNotFoundException("User id:"+ id + " cannot be found!!");
        }
        deleteById(id);
    }
}
