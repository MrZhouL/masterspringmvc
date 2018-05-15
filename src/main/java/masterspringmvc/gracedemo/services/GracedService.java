/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GracedService
 * Author:   zhoulei
 * Date:     2018/5/12 下午11:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.services;

import masterspringmvc.gracedemo.beans.UserBean;
import masterspringmvc.gracedemo.dao.GracedDao;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/12
 * @since 1.0.0
 */
@Service
public class GracedService {

    private GracedDao gracedDao;

    public GracedService(GracedDao gracedDao) {
        this.gracedDao = gracedDao;
    }

    public long addUser(UserBean user) {

        return gracedDao.addUser(user);
    }
}
