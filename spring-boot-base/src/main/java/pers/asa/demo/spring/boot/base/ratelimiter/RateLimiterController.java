/**
 * @author: asx
 * @date: 2023/6/5
 * @descrition:
 */
package pers.asa.demo.spring.boot.base.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController()
@RequestMapping("/api/rate-limit")
public class RateLimiterController {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(5.0);
    private static final RateLimiter RATE_LIMITER_2 = RateLimiter.create(5.0);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss: SSS");


    @GetMapping("/hello/{permitNumber}")
    public String helloLimiter(@PathVariable("permitNumber") Integer permitNumber) {
        // 不允许小于等于0
        if (permitNumber <= 0) permitNumber = 1;
        boolean isAllow = RATE_LIMITER.tryAcquire(permitNumber);
        if (isAllow) {
            return sdf.format(new Date());
        } else {
            throw new RuntimeException("request too much");
        }
    }

    @GetMapping("/hello-aquire")
    public String helloAquire() {
        double time = RATE_LIMITER_2.acquire(1);
        return String.valueOf(time);
    }
}
