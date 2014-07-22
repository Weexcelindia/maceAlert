package com.ayla.service.lang;

/**
 * Created by IntelliJ IDEA.
 * User: Billy
 * Date: 2010/7/3
 * Time: 下午 03:54:00
 */
public interface f {
    public void run();

    public static f dump = new f() {
        public void run() {

        }
    };
    public static f dumpFx = dump;


}

