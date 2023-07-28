/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
@Service
public class DbServiceImpl implements IDbService {
    @Autowired
    private IDbService idbService;
    /**
     锁
     */
    private final ReentrantLock lock = new ReentrantLock();


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeAndSaveNew(String modelJson) {
        lock.lock();
        try {
            System.out.println("xxx");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
