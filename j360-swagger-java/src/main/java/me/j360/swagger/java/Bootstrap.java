package me.j360.swagger.java;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: min_xu
 * @date: 2018/8/15 下午3:19
 * 说明：
 */
public class Bootstrap {

    public static void main(String[] args) {
        LockSupport.park();
    }
}
