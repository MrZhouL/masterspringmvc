/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GracedDao
 * Author:   zhoulei
 * Date:     2018/5/13 下午2:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.dao;

import masterspringmvc.gracedemo.beans.UserBean;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/13
 * @since 1.0.0
 */
@Repository
public class GracedDao {

    public long addUser(UserBean user) {
        return 1000L;
    }
}
