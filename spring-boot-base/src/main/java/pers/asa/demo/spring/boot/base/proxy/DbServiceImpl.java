/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Service
public class DbServiceImpl implements IDbService {
    @Autowired
    private IDbService idbService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeAndSaveNew(String modelJson) {

    }
}
