package com.company.configuration.data;

public enum MenuOptions {
    ADD("ADD"),
    LIST("LIST"),
    EXIT("EXIT");

    public String cmd;

    MenuOptions(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }

    public static MenuOptions fromString(String text) {
        for (MenuOptions b : MenuOptions.values()) {
            if (b.cmd.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
