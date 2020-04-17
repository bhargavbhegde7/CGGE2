package de.cg.cgge.ctrl;

import de.cg.cgge.game.GameInstance;

public class CGGE2 {

    private static String version = "pre-1.0-b7";
    private static int release = 0;

    public static boolean package_uiplus = false;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("CGGE2 Game Engine");
            System.out.println("Current Version: " + version);
        }

        if (args.length == 1) {
            if (args[0].equals("test")) {
                System.out.println("Test Launched");
                new GameInstance();
            }

            if (args[0].equals("packages")) {
                System.out.println("UIPlus: " + package_uiplus);
            }
        }
    }

    public static String getVersion() {
        return version;
    }

    public static int getRelease() {
        return release;
    }
}