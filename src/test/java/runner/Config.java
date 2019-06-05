package runner;

import java.util.HashMap;
import java.util.Map;


class Config {
    //多线程存在数据抢占的情况，取巧，用Map数据存储场景名字和线程
    static Map<Long, String> parms = new HashMap<>();
}
