/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserBean
 * Author:   zhoulei
 * Date:     2018/5/13 下午1:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterspringmvc.gracedemo.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zhoulei
 * @create 2018/5/13
 * @since 1.0.0
 */
@Data
@Entity
public class UserBean {

    @NotNull(message = "error.userBean.id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "error.userBean.name")
    private String name;

    public UserBean() {
    }

    public UserBean(Integer id, @NotBlank(message = "error.userBean.name") String name) {
        this.id = id;
        this.name = name;
    }
}
