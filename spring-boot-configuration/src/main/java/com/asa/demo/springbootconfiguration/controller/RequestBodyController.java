package com.asa.demo.springbootconfiguration.controller;

import com.asa.demo.springbootconfiguration.bean.ReceiveBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 12:07 2020/3/6.
 */
@RestController
@RequestMapping("/demo")
public class RequestBodyController {
    /**
     * case 1.1
     * result: true/pass
     *
     * @param names names
     */
    @PostMapping("/form-data-request-param")
    public Map<String, Object> formDataRequestParam(@RequestParam(value = "names", required = false) List<String> names) {
        Map<String, Object> map = new HashMap<>();
        map.put("names", names);
        return map;
    }

    /**
     * case 1.2
     * result: false/reject
     * <p>
     * "timestamp": "2020-03-06T04:19:31.609+0000",
     * "status": 415,
     * "error": "Unsupported Media Type",
     *
     * @param params names
     */
    @PostMapping("/form-data-request-body")
    public Map<String, Object> formDataRequestBody(@RequestBody ReceiveBody params) {
        Map<String, Object> map = new HashMap<>();
        map.put("names", params.getNames());
        return map;
    }

    /**
     * case 2.1
     * result: true/pass
     *
     * @param names names
     */
    @PostMapping("/x-www-form-urlencoded-request-param")
    public Map<String, Object> xWwwFormUrlencodedRequestParam(@RequestParam(value = "names", required = false) List<String> names) {
        Map<String, Object> map = new HashMap<>();
        map.put("names", names);
        return map;
    }

    /**
     * case 2.2
     * result: false/not pass
     * "timestamp": "2020-03-06T04:04:10.670+0000",
     * "status": 415,
     * "error": "Unsupported Media Type",
     * "message": "Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported",
     *
     * @param params names
     */
    @PostMapping("/x-www-form-urlEncoded-request-body")
    public Map<String, Object> xWwwFormUrlencodedRequestBody(@RequestBody ReceiveBody params) {
        Map<String, Object> map = new HashMap<>(0);
        map.put("names", params.getNames());
        return map;
    }

    /**
     * case 3.1 raw.json.requestParam
     * result: false/reject
     * <p>
     * can not receive params/parse body
     *
     * @param names names
     */
    @PostMapping("/raw-json-request-param")
    public Map<String, Object> rawJsonRequestParam(@RequestParam(value = "names", required = false) List<String> names) {
        Map<String, Object> map = new HashMap<>(0);
        map.put("names", names);
        return map;
    }

    /**
     * case 3.2 raw.json.requestBody
     * result: true
     *
     * @param params names
     */
    @PostMapping("/raw-json-request-body")
    public Map<String, Object> rawJsonRequestBody(@RequestBody ReceiveBody params) {
        Map<String, Object> map = new HashMap<>();
        map.put("names", params.getNames());
        return map;
    }

    // TODO: 2020/3/6 test binary or file receive method.
}