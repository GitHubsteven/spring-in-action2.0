/**
 * @author: asx
 * @date: 2023/8/3
 * @descrition:
 */
package com.asa.demo.spring.data.migration.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * @author: asx
 * @date: 2023/8/3
 * @descrition:
 */
public class DemoClient {
    public static List<String> LISTEN_TABLES = Arrays.asList("student");
    public static int EVENT_CNT = 0;

    public static void main(String[] args) {
        BinaryLogClient client = new BinaryLogClient("127.0.0.1", 3306, "root", "root");
        // 反序列化配置
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG
//                EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
        );
        // 设置反序列化配置
        client.setEventDeserializer(eventDeserializer);
        // 设置自己的client作为服务器的id
        client.setServerId(3);
        // 可选，设置start fileName+position，后续的话会都会开始执行的，包括后续的binlog file
//        client.setBinlogFilename("master-bin.000079");
//        client.setBinlogPosition(4);

        client.registerEventListener(event -> {
            EventData data = event.getData();
            String tableName;
            EVENT_CNT++;
            System.out.println(EVENT_CNT);
            if (data instanceof TableMapEventData) {
                System.out.println("Table:");
                TableMapEventData tableMapEventData = (TableMapEventData) data;
                System.out.println(tableMapEventData.getTableId() + ": [" + tableMapEventData.getDatabase() + "." + tableMapEventData.getTable() + "]");
                tableName = tableMapEventData.getTable();
                // 如果是不处理的表，那么返回
                if (!Objects.equals(tableName, "student"))
                    return;
            }
            if (data instanceof UpdateRowsEventData) {
//                System.out.println("Update:");
//                System.out.println(data);
                // 获取对应的操作对象的json化数据
                UpdateRowsEventData udata = (UpdateRowsEventData) data;
                List<Map.Entry<Serializable[], Serializable[]>> rows = udata.getRows();
                for (Map.Entry<Serializable[], Serializable[]> row : rows) {
                    List<Serializable> entries = Arrays.asList(row.getValue());
                    JSONObject dataObject = getDataObject(entries);
                    // 打印对象信息
                    System.out.println(dataObject);
                }
            } else if (data instanceof WriteRowsEventData) {
                WriteRowsEventData wData = new WriteRowsEventData();
                wData.getIncludedColumns();
                wData.getRows();

                System.out.println("Insert:");
                System.out.println(data);
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete:");
                System.out.println(data);
            }
        });
        try {
            client.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 根据message获取对象
     */
    private static JSONObject getDataObject(List<Serializable> message) {
        JSONObject resultObject = new JSONObject();
        String format = "{\"id\":\"0\",\"name\":\"1\",\"age\":\"2\",\"code\":\"3\"}";
        JSONObject json = JSON.parseObject(format);
        for (String key : json.keySet()) {
            resultObject.put(key, message.get(json.getInteger(key)));
        }
        return resultObject;
    }

}
