package com.mace.util;

import com.squareup.otto.Bus;

/**
 * Created by A on 6/25/14.
 */
    public final class BusProvider {
        private static final Bus BUS = new Bus();

        public static Bus getInstance() {
            return BUS;
        }

        private BusProvider() {
            // No instances.
        }
    }