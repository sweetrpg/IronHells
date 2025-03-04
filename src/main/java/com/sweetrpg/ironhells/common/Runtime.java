package com.sweetrpg.ironhells.common;

/**
 * Container class for runtime information.
 */
public class Runtime {

    public static Runtime INSTANCE = new Runtime();

    public enum OverlayState {
        SHOW,
        HIDE,
        SUPPRESS,
        DYNAMIC,
    }

    public Runtime() {
        init();
    }

    private void init() {
    }
}
