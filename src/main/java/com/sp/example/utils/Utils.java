package com.sp.example.utils;

import java.util.logging.Logger;

import org.apache.commons.lang3.time.StopWatch;

public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class.getName());
    
    public static StopWatch getWatch() {
        StopWatch watch = new StopWatch();
        watch.start();
        return watch;
    }
    
    public static void stopWatchAndPrint(StopWatch watch) {
        watch.stop();
        logger.info("Procesing time in ms: " + watch.getTime());
    }

}
