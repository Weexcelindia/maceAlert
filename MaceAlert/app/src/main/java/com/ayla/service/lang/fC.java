package com.ayla.service.lang;


/**
 * a fx that suppose to run once and only once
 */
public abstract class fC {
    private boolean runned = false;

    public abstract void run();

    public void runOnceOnly() {
        if (!runned) {
            runned = true;
            run();
        }
    }

    public static fC newInstance(final f fx) {
        return new fC() {

            @Override
            public void run() {
                fx.run();
            }
        };

    }
}
