package pers.asa.demo.spring.boot.base.inherit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/7/13 19:16
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/7/13 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
@RequestMapping("/rest/scs")
public class ScsInheritApiImpl extends DefaultInheritApiImpl {
}

