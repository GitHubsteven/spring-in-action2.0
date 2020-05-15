package pers.demo.asa.freemarker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @date: Created at 13:47 2019/11/22.
 */
@Setter
@Getter
public class Table {
    private String name;
    private List<TField> fields;
}