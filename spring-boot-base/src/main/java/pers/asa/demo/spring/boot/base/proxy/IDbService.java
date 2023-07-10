/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.proxy;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
public interface IDbService {
    /**
     * 删除和保存新的
     *
     * @param modelJson
     */
    void removeAndSaveNew(String modelJson);
}
