/**
 * @author: asx
 * @date: 2023/7/6
 * @descrition:
 */
package pers.asx.com.transation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: asx
 * @date: 2023/7/6
 * @descrition:
 */
@Service
public class TransactionDemoService {

    private final TransactionTemplate transactionTemplate;

    public TransactionDemoService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void processTransaction(){
        Integer result = (Integer)transactionTemplate.execute((TransactionCallback<Object>) status -> {
            try {
                System.out.println("remove");
                System.out.println("new");
                throw new RuntimeException("test");
            } catch (RuntimeException e) {
                if (status.isRollbackOnly()) {
                    return -1;
                }
            }
            return 1;
        });

    }

    @Transactional(rollbackFor = Exception.class)
    public void operate(){

    }


}
