package masterspringmvc.gracedemo.dao;

import masterspringmvc.gracedemo.beans.UserBean;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserBean,Integer> {
}
