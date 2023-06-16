/**
 * @author: asx
 * @date: 2023/6/10
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.service;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

public class RateLimiterTest {
    @Test
    public void testSmoothBursty() {
        RateLimiter r = RateLimiter.create(5);
        while (true) {
            double acquire = r.acquire();
            System.out.println("get 1 tokens: " + acquire + "s");
        }
    }

    @Test
    public void testSmoothBursty2() {
        RateLimiter r = RateLimiter.create(2);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
        }
    }

}
