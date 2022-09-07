package pers.asa.demo.spring.multi.database.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.asa.demo.spring.multi.database.model.account.UserModel;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/29 12:11
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/29 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
