/**
 * @author: asx
 * @date: 2023/6/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {

    private static final RateLimiter _5_rt = RateLimiter.create(5);



}
