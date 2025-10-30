import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Locale;
/**
 * Main class for the School Simulation project.
 * Contains all menu, gameplay and animation methods.
 * @author Gökdeniz Demircioğlu
 * @author Taha Söğüt
 * @author Kerem İrfanoğlu
 * @author Ayşenur Gülfem Kömürcü
 */
public class Group10 {
    /**
     * The main entry point of the application.
     * <p>
     * Displays the main menu to the user with options for different education levels —
     * Primary School, Secondary School, High School, and University — as well as an Exit option.
     * The program continuously loops through the menu until the user chooses to exit.
     * </p>
     *
     * <p>
     * Each menu option redirects the user to the corresponding submenu by invoking its related method:
     * </p>
     *
     * <ul>
     *   <li>{@link #PrimarySchoolMenu()} – Opens the Primary School menu</li>
     *   <li>{@link #secondarySchool()} – Opens the Secondary School menu</li>
     *   <li>{@link #HighSchoolMenu()} – Opens the High School menu</li>
     *   <li>{@link #universityMenu()} – Opens the University menu</li>
     * </ul>
     *
     * @see #PrimarySchoolMenu()
     * @see #secondarySchool()
     * @see #HighSchoolMenu()
     * @see #universityMenu()
     * @see #clearScreen()
     * @param args command-line arguments
     */

    public static void main(String[] args) {
        Scanner inputGame = new Scanner(System.in);
        boolean menuContinues = true;
        /*
        try {
            displayIntro();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */
        while (menuContinues) {
            clearScreen();
            displayWelcomeMessage();
            System.out.println(COLOR_YELLOW); // Yellow.
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║    Please choose an option and start !     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_LIGHT_CYAN);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║     [A] Primary School                     ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [B] Secondary School                   ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [C] High School                        ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [D] University                         ║");
            System.out.println("║════════════════════════════════════════════║");
            System.out.println("║     [E] Exit                               ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.print("Your choice: ");
            String menuChoice = inputGame.next().trim().toLowerCase();

            switch (menuChoice) {
                case "a":
                    clearScreen();
                    PrimarySchoolMenu();
                    break;


                case "b":
                    clearScreen();
                    secondarySchool();
                    break;

                case "c":
                    clearScreen();
                    HighSchoolMenu();
                    break;

                case "d":
                    clearScreen();
                    universityMenu();
                    break;

                case "e":
                    try {
                        specialThanks();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Exiting program... Goodbye!");
                    menuContinues = false;
                    break;

                default:
                    System.out.println(COLOR_RED);
                    System.out.println("Invalid input! Please press any key to try again.");
                    System.out.println(COLOR_RESET);
                    // Clean leftover '\n' from buffer
                    inputGame.nextLine();
                    // Wait for user to press Enter
                    inputGame.nextLine();
                    break;
            }
        }
    }

// === Scanner Instances ===

    /**
     * Scanner used for High School menu (Taha's section).
     */
    static Scanner sc = new Scanner(System.in);

    /**
     * Scanner used for general input in other sections (Gülfem's section).
     */
    static Scanner input = new Scanner(System.in);

    /**
     * Scanner used for university-related menus (Kerem's section).
     */
    static Scanner scanner = new Scanner(System.in);


// === ANSI Color Codes ===

    /** Resets text color and style. */
    public static final String COLOR_RESET = "\u001B[0m";

    /** Standard red text color. */
    public static final String COLOR_RED = "\u001B[31m";

    /** Standard green text color. */
    public static final String COLOR_GREEN = "\u001B[32m";

    /** Standard yellow text color. */
    public static final String COLOR_YELLOW = "\u001B[33m";

    /** Standard blue text color. */
    public static final String COLOR_BLUE = "\u001B[34m";

    /** Bright red text color. */
    public static final String COLOR_LIGHT_RED = "\u001B[91m";

    /** Bright green text color. */
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";

    /** Light yellow text color for emphasis. */
    public static final String COLOR_LIGHT_YELLOW = "\u001B[38;5;229m";

    /** Bright blue text color. */
    public static final String COLOR_LIGHT_BLUE = "\u001B[94m";

    /** Bright magenta text color. */
    public static final String COLOR_LIGHT_MAGENTA = "\u001B[95m";

    /** Bright cyan text color. */
    public static final String COLOR_LIGHT_CYAN = "\u001B[96m";

    /** Custom dark blue text color (RGB-based). */
    public static final String COLOR_DARK_BLUE = "\u001B[38;2;0;45;114m";

    /** Custom rose/pink text color (RGB-based). */
    public static final String COLOR_ROSE = "\u001B[38;2;255;0;128m";

    /** Custom lilac (light purple) text color. */
    public static final String COLOR_LILAC = "\u001B[38;2;200;162;200m";

    /** Very light lilac shade used for soft UI accents. */
    public static final String COLOR_LIGHT_LILAC = "\u001B[38;2;225;200;225m";

    /**
     * Displays the animated ASCII intro screen of the program.
     * <p>
     * Shows several ASCII banners with timed delays, clears the screen
     * between transitions, and ends with a “Press any key to continue” prompt.
     * </p>
     * @see #clearScreen()
     * @throws InterruptedException if the animation thread is interrupted
     */
    public static void displayIntro() throws InterruptedException {
        clearScreen();
        System.out.println(COLOR_LIGHT_CYAN);
        System.out.println(
                "                     █████████  ██████   ██████ ███████████  ██████████     ████████  █████ █████   ████████                         \n" +
                "                    ███▒▒▒▒▒███▒▒██████ ██████ ▒▒███▒▒▒▒▒███▒▒███▒▒▒▒▒█    ███▒▒▒▒███▒▒███ ▒▒███   ███▒▒▒▒███                        \n" +
                "                   ███     ▒▒▒  ▒███▒█████▒███  ▒███    ▒███ ▒███  █ ▒    ▒▒▒    ▒███ ▒███  ▒███ █▒▒▒    ▒███                        \n" +
                "                  ▒███          ▒███▒▒███ ▒███  ▒██████████  ▒██████         ██████▒  ▒███████████   ██████▒                         \n" +
                "                  ▒███          ▒███ ▒▒▒  ▒███  ▒███▒▒▒▒▒▒   ▒███▒▒█        ▒▒▒▒▒▒███ ▒▒▒▒▒▒▒███▒█  ▒▒▒▒▒▒███                        \n" +
                "                  ▒▒███     ███ ▒███      ▒███  ▒███         ▒███ ▒   █    ███   ▒███       ▒███▒  ███   ▒███                        \n" +
                "                   ▒▒█████████  █████     █████ █████        ██████████   ▒▒████████        █████ ▒▒████████                         \n" +
                "                    ▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒     ▒▒▒▒▒ ▒▒▒▒▒        ▒▒▒▒▒▒▒▒▒▒     ▒▒▒▒▒▒▒▒        ▒▒▒▒▒   ▒▒▒▒▒▒▒▒                          \n" +
                "                                                                                                                                     \n");
        Thread.sleep(2000);
        System.out.println(
                "    ███████       ███████    ███████████     █████                                                                                   \n" +
                "  ███▒▒▒▒▒███   ███▒▒▒▒▒███ ▒▒███▒▒▒▒▒███   ▒▒███                                                                                    \n" +
                " ███     ▒▒███ ███     ▒▒███ ▒███    ▒███    ▒███         ██████   ████████    ███████ █████ ████  ██████    ███████  ██████   █████ \n" +
                "▒███      ▒███▒███      ▒███ ▒██████████     ▒███        ▒▒▒▒▒███ ▒▒███▒▒███  ███▒▒███▒▒███ ▒███  ▒▒▒▒▒███  ███▒▒███ ███▒▒███ ███▒▒  \n" +
                "▒███      ▒███▒███      ▒███ ▒███▒▒▒▒▒▒      ▒███         ███████  ▒███ ▒███ ▒███ ▒███ ▒███ ▒███   ███████ ▒███ ▒███▒███████ ▒▒█████ \n" +
                "▒▒███     ███ ▒▒███     ███  ▒███            ▒███      █ ███▒▒███  ▒███ ▒███ ▒███ ▒███ ▒███ ▒███  ███▒▒███ ▒███ ▒███▒███▒▒▒   ▒▒▒▒███\n" +
                " ▒▒▒███████▒   ▒▒▒███████▒   █████           ███████████▒▒████████ ████ █████▒▒███████ ▒▒████████▒▒████████▒▒███████▒▒██████  ██████ \n" +
                "   ▒▒▒▒▒▒▒       ▒▒▒▒▒▒▒    ▒▒▒▒▒           ▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒ ▒▒▒▒ ▒▒▒▒▒  ▒▒▒▒▒███  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒███ ▒▒▒▒▒▒  ▒▒▒▒▒▒  \n" +
                "                                                                              ███ ▒███                      ███ ▒███                 \n" +
                "                                                                             ▒▒██████                      ▒▒██████                  \n" +
                "                                                                              ▒▒▒▒▒▒                        ▒▒▒▒▒▒                   \n");
        Thread.sleep(2000);
        clearScreen();
        System.out.println(
                "                      █████████                                                           ████     █████   \n" +
                "                     ███▒▒▒▒▒███                                                         ▒▒███   ███▒▒▒███ \n" +
                "                    ███     ▒▒▒  ████████   ██████  █████ ████ ████████                   ▒███  ███   ▒▒███\n" +
                "                   ▒███         ▒▒███▒▒███ ███▒▒███▒▒███ ▒███ ▒▒███▒▒███    ██████████    ▒███ ▒███    ▒███\n" +
                "                   ▒███    █████ ▒███ ▒▒▒ ▒███ ▒███ ▒███ ▒███  ▒███ ▒███   ▒▒▒▒▒▒▒▒▒▒     ▒███ ▒███    ▒███\n" +
                "                   ▒▒███  ▒▒███  ▒███     ▒███ ▒███ ▒███ ▒███  ▒███ ▒███                  ▒███ ▒▒███   ███ \n" +
                "                    ▒▒█████████  █████    ▒▒██████  ▒▒████████ ▒███████                   █████ ▒▒▒█████▒  \n" +
                "                     ▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒      ▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒  ▒███▒▒▒                   ▒▒▒▒▒    ▒▒▒▒▒▒   \n" +
                "                                                               ▒███                                        \n" +
                "                                                               █████                                       \n" +
                "                                                              ▒▒▒▒▒                                        \n\n");
        Thread.sleep(2000);
        System.out.println(
                "          ███████████                                                  █████                 █████    █████                  \n" +
                "         ▒▒███▒▒▒▒▒███                                                ▒▒███                 ▒▒███    ▒▒███                   \n" +
                "          ▒███    ▒███ ████████   ██████   █████   ██████  ████████   ███████    ██████   ███████     ▒███████  █████ ████ ██\n" +
                "          ▒██████████ ▒▒███▒▒███ ███▒▒███ ███▒▒   ███▒▒███▒▒███▒▒███ ▒▒▒███▒    ███▒▒███ ███▒▒███     ▒███▒▒███▒▒███ ▒███ ▒▒ \n" +
                "          ▒███▒▒▒▒▒▒   ▒███ ▒▒▒ ▒███████ ▒▒█████ ▒███████  ▒███ ▒███   ▒███    ▒███████ ▒███ ▒███     ▒███ ▒███ ▒███ ▒███    \n" +
                "          ▒███         ▒███     ▒███▒▒▒   ▒▒▒▒███▒███▒▒▒   ▒███ ▒███   ▒███ ███▒███▒▒▒  ▒███ ▒███     ▒███ ▒███ ▒███ ▒███    \n" +
                "          █████        █████    ▒▒██████  ██████ ▒▒██████  ████ █████  ▒▒█████ ▒▒██████ ▒▒████████    ████████  ▒▒███████  ██\n" +
                "         ▒▒▒▒▒        ▒▒▒▒▒      ▒▒▒▒▒▒  ▒▒▒▒▒▒   ▒▒▒▒▒▒  ▒▒▒▒ ▒▒▒▒▒    ▒▒▒▒▒   ▒▒▒▒▒▒   ▒▒▒▒▒▒▒▒    ▒▒▒▒▒▒▒▒    ▒▒▒▒▒███ ▒▒ \n" +
                "                                                                                                                 ███ ▒███    \n" +
                "                                                                                                                ▒▒██████     \n" +
                "                                                                                                                 ▒▒▒▒▒▒      ");
        Thread.sleep(2000);
        // Team members
        clearScreen();
        System.out.println(
                        "             ______      __       __           _          ____                 _           _             __     \n" +
                        "            / ____/___  / /______/ /__  ____  (_)___     / __ \\___  ____ ___  (_)_________(_)___  ____ _/ /_  __\n" +
                        "           / / __/ __ \\/ //_/ __  / _ \\/ __ \\/ /_  /    / / / / _ \\/ __ `__ \\/ / ___/ ___/ / __ \\/ __ `/ / / / /\n" +
                        "          / /_/ / /_/ / ,< / /_/ /  __/ / / / / / /_   / /_/ /  __/ / / / / / / /  / /__/ / /_/ / /_/ / / /_/ / \n" +
                        "          \\____/\\____/_/|_|\\__,_/\\___/_/ /_/_/ /___/  /_____/\\___/_/ /_/ /_/_/_/   \\___/_/\\____/\\__, /_/\\__,_/  \n" +
                        "                                                                                               /____/           ");
        Thread.sleep(2000);
        clearScreen();
        System.out.println(
                        "            ______      __             _____                   __ \n" +
                        "           /_  __/___ _/ /_  ____ _   / ___/____  ____ ___  __/ /_\n" +
                        "            / / / __ `/ __ \\/ __ `/   \\__ \\/ __ \\/ __ `/ / / / __/\n" +
                        "           / / / /_/ / / / / /_/ /   ___/ / /_/ / /_/ / /_/ / /_  \n" +
                        "          /_/  \\__,_/_/ /_/\\__,_/   /____/\\____/\\__, /\\__,_/\\__/  \n" +
                        "                                               /____/             ");
        Thread.sleep(2000);

        clearScreen();
        System.out.println(
                        "              ___                                       ______      ______                  __ __                                     \n" +
                        "             /   | __  __________  ____  __  _______   / ____/_  __/ / __/__  ____ ___     / //_/___  ____ ___  __  ______________  __\n" +
                        "            / /| |/ / / / ___/ _ \\/ __ \\/ / / / ___/  / / __/ / / / / /_/ _ \\/ __ `__ \\   / ,< / __ \\/ __ `__ \\/ / / / ___/ ___/ / / /\n" +
                        "           / ___ / /_/ (__  )  __/ / / / /_/ / /     / /_/ / /_/ / / __/  __/ / / / / /  / /| / /_/ / / / / / / /_/ / /  / /__/ /_/ / \n" +
                        "          /_/  |_\\__, /____/\\___/_/ /_/\\__,_/_/      \\____/\\__,_/_/_/  \\___/_/ /_/ /_/  /_/ |_\\____/_/ /_/ /_/\\__,_/_/   \\___/\\__,_/  \n" +
                        "                /____/                                                                                                                ");
        Thread.sleep(2000);

        clearScreen();
        System.out.println(
                        "              __ __                            ____     ____                        __     \n" +
                        "             / //_/__  ________  ____ ___     /  _/____/ __/___ _____  ____  ____ _/ /_  __\n" +
                        "            / ,< / _ \\/ ___/ _ \\/ __ `__ \\    / // ___/ /_/ __ `/ __ \\/ __ \\/ __ `/ / / / /\n" +
                        "           / /| /  __/ /  /  __/ / / / / /  _/ // /  / __/ /_/ / / / / /_/ / /_/ / / /_/ / \n" +
                        "          /_/ |_\\___/_/   \\___/_/ /_/ /_/  /___/_/  /_/  \\__,_/_/ /_/\\____/\\__, /_/\\__,_/  \n" +
                        "                                                                          /____/           ");
        Thread.sleep(2000);
        clearScreen();
        System.out.println(
                        "    ____                                    __               __                            __  _                        \n" +
                        "   / __ \\________  __________   ___  ____  / /____  _____   / /_____     _________  ____  / /_(_)___  __  _____         \n" +
                        "  / /_/ / ___/ _ \\/ ___/ ___/  / _ \\/ __ \\/ __/ _ \\/ ___/  / __/ __ \\   / ___/ __ \\/ __ \\/ __/ / __ \\/ / / / _ \\        \n" +
                        " / ____/ /  /  __(__  |__  )  /  __/ / / / /_/  __/ /     / /_/ /_/ /  / /__/ /_/ / / / / /_/ / / / / /_/ /  __/  _ _ _ \n" +
                        "/_/   /_/   \\___/____/____/   \\___/_/ /_/\\__/\\___/_/      \\__/\\____/   \\___/\\____/_/ /_/\\__/_/_/ /_/\\__,_/\\___/  (_|_|_)\n" +
                        "                                                                                                                        ");
        input.nextLine();
        System.out.println(COLOR_RESET);
    }
    /**
     * Displays a special animated ASCII-art screen to thank
     * the professor and the assistant.
     * <p>
     * This method uses {@link #clearScreen()} to refresh the console
     * and {@link Thread#sleep(long)} to create small timed delays
     * between ASCII-art transitions for a smooth animation effect.
     * </p>
     * @throws InterruptedException if the animation thread is interrupted.
     */
    public static void specialThanks() throws InterruptedException {
        clearScreen();
        System.out.println(COLOR_RED +
                        " _____                 _       _   _____ _                 _          _____         \n" +
                        "/  ___|               (_)     | | |_   _| |               | |        |_   _|      _ \n" +
                        "\\ `--. _ __   ___  ___ _  __ _| |   | | | |__   __ _ _ __ | | _____    | | ___   (_)\n" +
                        " `--. \\ '_ \\ / _ \\/ __| |/ _` | |   | | | '_ \\ / _` | '_ \\| |/ / __|   | |/ _ \\     \n" +
                        "/\\__/ / |_) |  __/ (__| | (_| | |   | | | | | | (_| | | | |   <\\__ \\   | | (_) |  _ \n" +
                        "\\____/| .__/ \\___|\\___|_|\\__,_|_|   \\_/ |_| |_|\\__,_|_| |_|_|\\_\\___/   \\_/\\___/  (_)\n" +
                        "      | |                                                                           \n" +
                        "      |_|                                                                           \n");
        System.out.println(COLOR_YELLOW +
                "  ___          _      ______           __  ______        _____ _ _    _                 ___       \n" +
                " / _ \\        | |     | ___ \\         / _| |  _  \\      |_   _| | |  | |               / _ \\      \n" +
                "/ /_\\ \\___ ___| |_    | |_/ / __ ___ | |_  | | | |_ __    | | | | | _| |_ __ _ _ __   / /_\\ \\_ __ \n" +
                "|  _  / __/ __| __|   |  __/ '__/ _ \\|  _| | | | | '__|   | | | | |/ / __/ _` | '_ \\  |  _  | '__|\n" +
                "| | | \\__ \\__ \\ |_ _  | |  | | | (_) | |_  | |/ /| |_    _| |_| |   <| || (_| | | | | | | | | |   \n" +
                "\\_| |_/___/___/\\__(_) \\_|  |_|  \\___/|_(_) |___/ |_(_)   \\___/|_|_|\\_\\\\__\\__,_|_| |_| \\_| |_/_|   \n" +
                "                                                                                                  \n" + COLOR_RESET);
        Thread.sleep(3000);
        clearScreen();
        System.out.println(
                        "                 _       \n" +
                        "                | |      \n" +
                        "  __ _ _ __   __| |      \n" +
                        " / _` | '_ \\ / _` |      \n" +
                        "| (_| | | | | (_| |_ _ _ \n" +
                        " \\__,_|_| |_|\\__,_(_|_|_)\n" +
                        "                         \n" +
                        "                         ");
        Thread.sleep(1500);
        clearScreen();
        System.out.println(COLOR_LIGHT_CYAN +
                "______    _   _ _       _____ _   _ _            \n" +
                "|  ___|  | | (_) |     |  __ (_) (_) |           \n" +
                "| |_ __ _| |_ _| |__   | |  \\/ ___ | | __ _  ___ \n" +
                "|  _/ _` | __| | '_ \\  | | __ / _ \\| |/ _` |/ _ \\\n" +
                "| || (_| | |_| | | | | | |_\\ \\ (_) | | (_| |  __/\n" +
                "\\_| \\__,_|\\__|_|_| |_|  \\____/\\___/|_|\\__, |\\___|\n" +
                "                                       __/ |     \n" +
                "                                      |___/      \n" + COLOR_RESET);
        Thread.sleep(3000);
    }
    /**
     * Displays the animated welcome banner on the console.
     * <p>
     * Prints a large ASCII art title in rose color at the start of the program
     * to greet the user. This method uses ANSI color codes for styling
     * and resets the console color afterwards.
     * </p>
     */
    public static void displayWelcomeMessage() {
        System.out.println(COLOR_ROSE + " _    _      _                             _           _____      _                 _    _____ _                 _       _             \n" +
                "| |  | |    | |                           | |         /  ___|    | |               | |  /  ___(_)               | |     | |            \n" +
                "| |  | | ___| | ___ ___  _ __ ___   ___   | |_ ___    \\ `--.  ___| |__   ___   ___ | |  \\ `--. _ _ __ ___  _   _| | __ _| |_ ___  _ __ \n" +
                "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\  | __/ _ \\    `--. \\/ __| '_ \\ / _ \\ / _ \\| |   `--. \\ | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\n" +
                "\\  /\\  /  __/ | (_| (_) | | | | | |  __/  | || (_) |  /\\__/ / (__| | | | (_) | (_) | |  /\\__/ / | | | | | | |_| | | (_| | || (_) | |   \n" +
                " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|   \\__\\___/   \\____/ \\___|_| |_|\\___/ \\___/|_|  \\____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n"+
                COLOR_RESET);
    }
    /**
     * Displays the University menu and manages the game setup process.
     * <p>
     * This method allows the user to configure the game by selecting:
     * - The table size
     * - The game mode (singleplayer or multiplayer)
     * Once the selections are made, the appropriate game mode is started.
     * </p>
     * <p>
     * The method performs the following steps:
     * 1. Prints the University menu title.
     * 2. Lets the user choose the table size via {@link #chooseTableSize(Scanner)}.
     * 3. Initializes the game board with asterisks using {@link #fillTableWithAsterisk(char[][])}.
     * 4. Prompts the user to select the game mode with {@link #chooseGameMode(Scanner)}.
     * 5. Starts either {@link #playSingleplayer(char[][], Scanner)} or {@link #playMultiplayer(char[][], Scanner)} based on the user's choice.
     * </p>
     *
     * @see #chooseTableSize(Scanner)
     * @see #fillTableWithAsterisk(char[][])
     * @see #chooseGameMode(Scanner)
     * @see #playSingleplayer(char[][], Scanner)
     * @see #playMultiplayer(char[][], Scanner)
     */
    public static void universityMenu(){
        Scanner input = new Scanner(System.in);
        String choiceOfGameMode;
        System.out.println(COLOR_LIGHT_CYAN);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         === D: University Menu ===         ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);

        char[][] table = chooseTableSize(input);
        if (table == null) {
            return;
        }
        fillTableWithAsterisk(table);
        clearScreen();
        choiceOfGameMode = chooseGameMode(input);

        switch (choiceOfGameMode){
            case "s":
                playSingleplayer(table, input);
                break;
            case "m":
                playMultiplayer(table, input);
                break;
        }
    }
    /**
     * Lets the user choose a table size for the game.
     * <p>
     * Shows four options (5x4, 6x5, 7x6, or return to main menu) and validates the input.
     * If an invalid option is entered, an error message is shown until a valid one is selected.
     * </p>
     *
     * @param input Scanner object to read user input
     * @return a 2D char array for the selected table size, or null if user returns to main menu
     * @see #clearScreen()
     */
    public static char[][] chooseTableSize(Scanner input) {
        String choiceOfTableSize;
        char[][] table = new char[0][0];

        do {
            System.out.print(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║  Please select your choice of table size:  ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     1-) 5x4                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     2-) 6x5                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     3-) 7x6                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     4-) Return to main menu.     ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Your choice: ");
            choiceOfTableSize = input.nextLine().trim();
            // Boş veya birden fazla sayı girilirse hata
            if (!choiceOfTableSize.matches("[1-4]")) {
                clearScreen();
                System.out.println(COLOR_RED);
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║Invalid input! Please enter 1, 2, 3, or 4.  ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println(COLOR_RESET);
            }
        } while (!choiceOfTableSize.matches("[1-4]"));

        switch (choiceOfTableSize) {
            case "1":
                table = new char[4][5];
                break;
            case "2":
                table = new char[5][6];
                break;
            case "3":
                table = new char[6][7];
                break;
            case "4":
                System.out.println("Returning to main menu...");
                return null;
        }

        return table;
    }
    /**
     * Asks the user to select the game mode.
     * <p>
     * Prompts for singleplayer (<code>s</code>) or multiplayer (<code>m</code>) and
     * keeps asking until a valid input is entered.
     * </p>
     *
     * @param input Scanner object to read user input
     * @return "s" for singleplayer or "m" for multiplayer
     * @see #clearScreen()
     */
    public static String chooseGameMode(Scanner input) {
        String choiceOfGameMode;

        do {
            System.out.println(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║    Single Player or Multiplayer (s/m)?     ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);

            choiceOfGameMode = input.nextLine().trim().toLowerCase();

            if (!choiceOfGameMode.matches("[sm]")) {
                clearScreen();
                System.out.println(COLOR_RED);
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║Invalid input! Please enter 's' or 'm'.     ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println(COLOR_RESET);
            }

        } while (!choiceOfGameMode.matches("[sm]"));

        return choiceOfGameMode;
    }
    /**
     * Runs the singleplayer game mode against the computer.
     * <p>
     * The player (as '1') takes turns dropping discs into columns,
     * while the computer (as '2') makes random valid moves.
     * The game continues until a player wins, the table is full, or the user quits.
     * </p>
     *
     * @param table the 2D char array representing the current game board
     * @param input Scanner object to read user input
     *
     * @see #dropDiscAnimated(char[][], byte, char)
     * @see #isColumnValid(char[][], byte)
     * @see #determineWinner(char[][], char)
     * @see #isTableFull(char[][])
     * @see #postGameMenu(Scanner)
     * @see #universityMenu()
     */
    public static void playSingleplayer(char[][] table, Scanner input){
        char currentPlayer = '1';
        boolean gameContinues = true;
        Random random = new Random();

        while(gameContinues){
            clearScreen();
            printTable(table);

            if(currentPlayer == '1'){
                System.out.println("Player number " + currentPlayer + ", please make your move.");
                System.out.println("Please enter a valid column number between 1 - " + table[0].length + ": ");
                System.out.println("Enter '0' if you want to quit the game.");

                byte choiceOfColumn = -1;
                boolean validInput = false;

                while (!validInput) {
                    String userInput = input.nextLine().trim();

                    // empty control
                    if (userInput.isEmpty()) {
                        clearScreen();
                        printTable(table);
                        System.out.println(COLOR_RED + "Input cannot be empty. Please enter a number." + COLOR_RESET);
                        System.out.println("Enter '0' if you want to quit the game.");
                        continue;
                    }

                    // only accept numbers between 0-9
                    if (!userInput.matches("[0-9]")) {
                        clearScreen();
                        printTable(table);
                        System.out.println(COLOR_RED + "Invalid input! Please enter a single-digit number between 1 and " + table[0].length + "." + COLOR_RESET);
                        System.out.println("Enter '0' if you want to quit the game.");
                        continue;
                    }

                    // convert it to byte
                    choiceOfColumn = Byte.parseByte(userInput);

                    // if it wants to quit
                    if (choiceOfColumn == 0) {
                        clearScreen();
                        System.out.println("Player " + currentPlayer + " has quit the game.");
                        universityMenu();
                        return;
                    }
                    if (!isColumnValid(table, choiceOfColumn)) {
                        clearScreen();
                        printTable(table);
                        System.out.println(COLOR_RED + "The column you entered is not valid. Please enter a number between 1 and " + table[0].length + "." + COLOR_RESET);
                        System.out.println("Enter '0' if you want to quit the game.");
                    } else {
                        validInput = true;
                    }
                }

                try {
                    dropDiscAnimated(table, choiceOfColumn, currentPlayer);
                } catch (InterruptedException e) {
                    System.out.println("Animation interrupted unexpectedly. Returning to University Menu");
                    universityMenu();
                }
            }
            else{
                byte computersMove;
                // Computer's thinking
                System.out.print(COLOR_LIGHT_YELLOW + "\nComputer is thinking" + COLOR_RESET);
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(800); // 1 sec. waiting
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                do {
                    computersMove = (byte) (random.nextInt(table[0].length) + 1);
                } while (!isColumnValid(table, computersMove));
                System.out.println("Computer chooses column " + computersMove + ".");
                try {
                    dropDiscAnimated(table, computersMove, currentPlayer);
                } catch (InterruptedException e) {
                    System.out.println("Animation interrupted unexpectedly. Returning to University Menu");
                    universityMenu();
                }
            }


            if(determineWinner(table, currentPlayer)){
                clearScreen();
                printTable(table);
                if(currentPlayer == '1'){
                    System.out.println(COLOR_LIGHT_GREEN + "Congratulations! You won the game!" +  COLOR_RESET);
                }
                else{
                    System.out.println(COLOR_RED + "The computer wins!" + COLOR_RESET);
                }
                gameContinues = false;
            }
            else if (isTableFull(table)){
                printTable(table);
                System.out.println("It's a draw!");
                gameContinues = false;
            }
            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }
        String nextAction = postGameMenu(input);
        switch(nextAction){
            case"r":
                fillTableWithAsterisk(table);
                playSingleplayer(table, input);
                return;
            case"m":
                clearScreen();
                universityMenu();
                return;
            case "q":
                System.out.println("Returning to Main Menu...");
                return;
        }
    }
    /**
     * Runs the multiplayer game mode for two human players.
     * <p>
     * Players 1 and 2 take turns dropping discs into columns until one wins,
     * the table becomes full, or a player quits.
     * Input is validated to ensure only valid column numbers are accepted.
     * </p>
     *
     * @param table the 2D char array representing the current game board
     * @param input Scanner object to read user input
     *
     * @see #dropDiscAnimated(char[][], byte, char)
     * @see #isColumnValid(char[][], byte)
     * @see #determineWinner(char[][], char)
     * @see #isTableFull(char[][])
     * @see #postGameMenu(Scanner)
     * @see #universityMenu()
     */
    public static void playMultiplayer(char[][] table, Scanner input) {
        char currentPlayer = '1';
        boolean gameContinues = true;

        while (gameContinues) {
            clearScreen();
            printTable(table);
            System.out.println("Player number " + currentPlayer + ", please make your move.");
            System.out.println("Please enter a valid column number between 1 - " + table[0].length + ": ");
            System.out.println("Enter '0' if you want to quit the game.");

            byte choiceOfColumn = -1;
            boolean validInput = false;

            while (!validInput) {
                String userInput = input.nextLine().trim();

                if (userInput.isEmpty()) {
                    clearScreen();
                    printTable(table);
                    System.out.println(COLOR_RED + "Input cannot be empty. Please enter a number." + COLOR_RESET);
                    System.out.println("Enter '0' if you want to quit the game.");
                    continue;
                }

                if (!userInput.matches("[0-9]")) {
                    clearScreen();
                    printTable(table);
                    System.out.println(COLOR_RED + "Invalid input! Please enter a single-digit number between 1 and " + table[0].length + "." + COLOR_RESET);
                    System.out.println("Enter '0' if you want to quit the game.");
                    continue;
                }

                choiceOfColumn = Byte.parseByte(userInput);

                if (choiceOfColumn == 0) {
                    clearScreen();
                    System.out.println("Player " + currentPlayer + " has quit the game.");
                    universityMenu();
                    return;
                }
                if (!isColumnValid(table, choiceOfColumn)) {
                    clearScreen();
                    printTable(table);
                    System.out.println(COLOR_RED + "The column you entered is not valid. Please enter a number between 1 and " + table[0].length + "." + COLOR_RESET);
                    System.out.println("Enter '0' if you want to quit the game.");
                } else {
                    validInput = true;
                }
            }

            try {
                dropDiscAnimated(table, choiceOfColumn, currentPlayer);
            } catch (InterruptedException e) {
                System.out.println(COLOR_RED + "Animation interrupted unexpectedly. Returning to University Menu" + COLOR_RESET);
                universityMenu();
            }

            if (determineWinner(table, currentPlayer)) {
                clearScreen();
                printTable(table);
                System.out.println(COLOR_LIGHT_GREEN + "Player " + currentPlayer + " has won the game." + COLOR_RESET);
                gameContinues = false;
            } else if (isTableFull(table)) {
                clearScreen();
                printTable(table);
                System.out.println("It's a draw!");
                gameContinues = false;
            }

            currentPlayer = (currentPlayer == '1') ? '2' : '1';
        }

        String nextAction = postGameMenu(input);
        switch (nextAction) {
            case "r":
                input.nextLine(); // buffer cleaning
                fillTableWithAsterisk(table);
                playMultiplayer(table, input);
                return;
            case "m":
                input.nextLine(); // buffer cleaning
                clearScreen();
                universityMenu();
                return;
            case "q":
                input.nextLine(); // buffer cleaning
                System.out.println("Returning to Main Menu...");
                return;
        }
    }
    /**
     * Shows what the player wants to do after the game.
     * It asks if they want to:
     * - Restart the same game (r)
     * - Go back to the University Menu (m)
     * - Quit to the main menu (q)
     * Keeps asking until a valid option is chosen.
     *
     * @param input tool that reads what the player types
     * @return "r", "m" or "q" depending on the player's choice
     */
    public static String postGameMenu(Scanner input){
        String selection;

        do{
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("R-) Restart the game with the same settings.");
            System.out.println("M-) Return to University Menu.");
            System.out.println("Q-) Quit and return to main menu.");
            System.out.println("Please enter your choice: ");
            selection = input.next().trim().toLowerCase();

            if(!selection.equals("r") && !selection.equals("m") &&  !selection.equals("q")){
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input. Please try again." + COLOR_RESET);
            }

        }while(!selection.equals("r") && !selection.equals("m") &&  !selection.equals("q"));

        return selection;
    }
    /**
     * Clears the console screen by printing several empty lines.
     * Makes the display look fresh before showing new content.
     */
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    /**
     * Checks if the selected column is valid for placing a disc.
     * Returns false if the number is out of range or the column is already full.
     *
     * @param table the game board
     * @param colNum the chosen column number
     * @return true if the column is valid, false otherwise
     */
    public static boolean isColumnValid(char[][] table, byte colNum){
        if(colNum <= 0 || colNum > table[0].length)
            return false;

        if(table[0][colNum-1] != '*')
            return false;

        return true;
    }
    /**
     * Checks if the game board is completely full.
     * Returns true if there are no empty ('*') cells left.
     *
     * @param table the game board
     * @return true if the table is full, false otherwise
     */
    public static boolean isTableFull(char[][] table){
        for (char[] chars : table) {
            for (char ch : chars) {
                if(ch == '*')
                    return false;
            }
        }
        return true;
    }


    /**
     * Checks if the given player has won the game.
     * Looks for four matching symbols in a row horizontally,
     * vertically, or diagonally.
     *
     * @param table the game board
     * @param player the current player ('1' or '2')
     * @return true if that player has four in a row, false otherwise
     */
    public static boolean determineWinner(char[][] table, char player) {
        // Horizontal check
        for (int rowIndex = 0; rowIndex < table.length; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex][colIndex + 1] == player &&
                        table[rowIndex][colIndex + 2] == player &&
                        table[rowIndex][colIndex + 3] == player)
                    return true;
            }
        }
        // Vertical check
        for (int rowIndex = 0; rowIndex < table.length - 3; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex + 1][colIndex] == player &&
                        table[rowIndex + 2][colIndex] == player &&
                        table[rowIndex + 3][colIndex] == player)
                    return true;
            }
        }
        // Upward diagonal check
        for (int rowIndex = 3; rowIndex < table.length; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex - 1][colIndex + 1] == player &&
                        table[rowIndex - 2][colIndex + 2] == player &&
                        table[rowIndex - 3][colIndex + 3] == player) {
                    return true;
                }
            }
        }
        // Downward diagonal check
        for (int rowIndex = 0; rowIndex < table.length - 3; rowIndex++) {
            for (int colIndex = 0; colIndex < table[0].length - 3; colIndex++) {
                if (table[rowIndex][colIndex] == player &&
                        table[rowIndex + 1][colIndex + 1] == player &&
                        table[rowIndex + 2][colIndex + 2] == player &&
                        table[rowIndex + 3][colIndex + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Fills the entire game board with asterisks ('*')
     * to reset it for a new round.
     *
     * @param table the game board
     */
    public static void fillTableWithAsterisk(char[][] table){
        for (char[] chars : table) {
            Arrays.fill(chars, '*');
        }
    }

    /**
     * Prints the current game board to the screen with borders and colors.
     * Player 1's discs appear red, Player 2's discs appear yellow.
     *
     * @param table the game board
     */
    public static void printTable(char[][] table) {
        int rows = table.length;
        int cols = table[0].length;

        // Top border
        System.out.print("╔");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══╦");
        }
        System.out.println("═══╗");

        // Draw each row
        for (int r = 0; r < rows; r++) {
            System.out.print("║");
            for (int c = 0; c < cols; c++) {
                char cell = table[r][c];

                // Color setup
                if (cell == '1') {
                    System.out.print(" \u001B[31m" + cell + "\u001B[0m ║"); // Red for Player 1
                } else if (cell == '2') {
                    System.out.print(" \u001B[33m" + cell + "\u001B[0m ║"); // Yellow for Player 2
                } else {
                    System.out.print(" " + cell + " ║"); // Normal for empty
                }
            }
            System.out.println();

            // Middle separators between rows
            if (r != rows - 1) {
                System.out.print("╠");
                for (int c = 0; c < cols - 1; c++) {
                    System.out.print("═══╬");
                }
                System.out.println("═══╣");
            }
        }

        // Bottom border
        System.out.print("╚");
        for (int c = 0; c < cols - 1; c++) {
            System.out.print("═══╩");
        }
        System.out.println("═══╝");

        // Column numbers
        System.out.print("  ");
        for (int c = 1; c <= cols; c++) {
            System.out.print(" " + c + "  ");
        }
        System.out.println();
    }
    /**
     * Animates the disc dropping into the chosen column.
     * The disc falls step by step until it reaches the correct spot.
     *
     * @param table the game board
     * @param colNum the selected column number
     * @param player the current player ('1' or '2')
     * @throws InterruptedException if the animation is interrupted
     */
    public static void dropDiscAnimated(char[][] table, byte colNum, char player) throws InterruptedException {
        int colIndex = (int)colNum - 1;

        // find the correct position that the disk is goingto land
        int targetRow = -1;
        for(int rowIndex = table.length-1; rowIndex >= 0; rowIndex--){
            if(table[rowIndex][colIndex] == '*'){
                targetRow = rowIndex;
                break;
            }
        }

        // animation of row falling
        for (int rowIndex = 0; rowIndex <= targetRow; rowIndex++) {
            table[rowIndex][colIndex] = player;    // put the disk into this row
            clearScreen();                  // clear the screen
            printTable(table);              // print the table again
            Thread.sleep(300);              // 300 miliseconds of waiting
            if (rowIndex != targetRow) {           // clear the current row before the disk reaches the next rox
                table[rowIndex][colIndex] = '*';
            }
        }
    }

    ////GÜLFEM
  
    /**
     * Displays the Primary School sub-menu and allows the user to choose between
     * available options (Age and Zodiac, Reverse Words, or returning to the main menu).
     * The menu loops until the user selects '3' to go back.
     * 
     * <p>This method performs the following actions:</p>
     * <ul>
     *   <li>Clears the console screen before displaying the menu.</li>
     *   <li>Presents options: [1] Age and Zodiac, [2] Reverse Words, and [3] Back to Main Menu.</li>
     *   <li>Reads the user's choice from the console.</li>
     *   <li>Calls {@link #ageAndZodiacDetection()} for option 1.</li>
     *   <li>Calls {@link #reverseTheWords()} for option 2.</li>
     *   <li>Sets the loop control variable {@code subMenu} to {@code false} for option 3, exiting the menu.</li>
     *   <li>Handles invalid input by displaying an error message and prompting the user to continue.</li>
     *   <li>Waits for the Enter key press after completing operations or invalid input before re-displaying the menu.</li>
     * </ul>
     * 
     * @see #ageAndZodiacDetection()
     * @see #reverseTheWords()
     * @see #clearScreen()
     */

    public static void PrimarySchoolMenu() {
                    boolean subMenu = true;
                    while (subMenu) {
                        clearScreen();  //Alt menü başında ekranı temizle
                        System.out.println(COLOR_LIGHT_CYAN);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║        === Primary School Menu ===         ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println(COLOR_LIGHT_BLUE);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║Please select your choice:                  ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println(COLOR_RESET);
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[1] Age and Zodiac                          ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[2] Reverse Words                           ║");
                        System.out.println("╚════════════════════════════════════════════╝");
                        System.out.println("╔════════════════════════════════════════════╗");
                        System.out.println("║[3] Back to Main Menu                       ║");
                        System.out.println("╚════════════════════════════════════════════╝");

                        System.out.print("Enter choice: "); // Bu satır çerçeve dışında kalmalı
                        String Choice = input.nextLine().trim();

                        switch (Choice) {
                            case "1":
                                clearScreen(); // Age and Zodiac başlamadan önce ekranı temizle
                                ageAndZodiacDetection();
                                System.out.println("\nPress Enter to return to Primary School Menu...");
                                input.nextLine();
                                break;
                            case "2":
                                clearScreen(); // Reverse Words başlamadan önce ekranı temizle
                                reverseTheWords();
                                System.out.println("\nPress Enter to return to Primary School Menu...");
                                input.nextLine();
                                break;
                            case "3":
                                subMenu = false;
                                break;    
                            default:
                                System.out.println(COLOR_RED);
                                System.out.println("Invalid choice! Try again.");
                                System.out.println(COLOR_RESET);
                                System.out.println("Press Enter to continue...");
                                input.nextLine();
                                break;
                        }
                    }
                        }
    // Option A: Zodiac and Sign

    /**
    * Takes an integer input from the user and repeatedly prompts in a loop 
    * until a valid integer is entered.
    *   
    * @param inputString The prompt message to display to the user.
    * @return The valid integer entered by the user.
    * @see #clearScreen()
    */

    public static int receiveInputDate(String inputString) {
        while (true) {
            System.out.println(inputString);
            // Makes sure that the input is INT
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                clearScreen();
                System.out.println(COLOR_RED);
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║Invalid input! Please enter an integer.     ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println(COLOR_RESET);
                input.next();

            }
        }
    }
    /**
     * Calculates and displays the user's age and zodiac sign based on their birth date
     * and the current date entered by the user.
     * <p>
     * Validates both dates using {@link #isValidDate(int, int, int)} and determines
     * the zodiac sign with {@link #calculateZodiac(int, int)}.
     * </p>
     *
     * @see #receiveInputDate(String)
     * @see #isValidDate(int, int, int)
     * @see #calculateZodiac(int, int)
     * @see #clearScreen()
     */

    public static void ageAndZodiacDetection() {
        System.out.println(COLOR_ROSE);
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║ Age and Zodiac Sign Detection ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println(COLOR_RESET);

        //First, I took the user's date of birth.

        int birthDay = receiveInputDate("Enter your birth 'day' (1-31):");
        input.nextLine();
        int birthMonth = receiveInputDate("Enter your birth 'month' (1-12):");
        input.nextLine();
        int birthYear = receiveInputDate("Enter your birth 'year':");
        input.nextLine();



        //In this section, I checked whether the birthday dates they entered were valid.
        if (!isValidDate(birthDay, birthMonth, birthYear)) {
            clearScreen();
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid birth date.                         ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }
        clearScreen();
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔══════════════╗");
        System.out.println("║Your birthday:║ " + birthDay + "/" + birthMonth + "/" + birthYear + "    ");
        System.out.println("╚══════════════╝");
        System.out.println(COLOR_RESET);
        //Next, I took the current date.
        int currentDay = receiveInputDate("Enter the current 'day' (1-31):");
        input.nextLine();
        int currentMonth = receiveInputDate("Enter the current 'month' (1-12):");
        input.nextLine();
        int currentYear = receiveInputDate("Enter the current 'year':");
        input.nextLine();
        //In this section, I also checked whether the 'currentDay, currentMonth, and currentYear' parts they entered were valid.
        if (!isValidDate(currentDay, currentMonth, currentYear)) {
            clearScreen();
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid current date.                       ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }

        clearScreen();
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔══════════════╗");
        System.out.println("║Your birthday:║ " + birthDay + "/" + birthMonth + "/" + birthYear + "    ");
        System.out.println("╚══════════════╝");
        System.out.println("╔══════════════╗");
        System.out.println("║Current date: ║ "  + currentDay + "/" + currentMonth + "/" + currentYear + "      ");
        System.out.println("╚══════════════╝");
        System.out.println(COLOR_RESET);

        // ---------- AGE CALCULATION

        //I didn't account for the possibility of negative results when I initially wrote the age calculation section.
        //To prevent negative values, I made corrections and updated the code/logic to the structure below.
        int age = currentYear - birthYear;

        //Decrement the age if the user's birthday has not yet passed in the given year, as they haven't completed their current age.
        if (currentMonth < birthMonth ||
                (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        // A negative age means the user's entered birth date is in the future.
        // Display an error/informative message indicating that the user is not yet born as of the current date.

        if (age < 0) {
            System.out.println(COLOR_RED);
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║Invalid birth and current date. Birth date  ║");
            System.out.println("║is in the future.                           ║");
            System.out.println("╚════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            return;
        }
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════╗");
        System.out.println("║Your age is: ║  " + age + "     ");
        System.out.println("╚═════════════╝");

        // ----------- AGE AND ZODIAC SIGN CALCULATION
        
        String zodiac = calculateZodiac(birthDay, birthMonth);

        System.out.println("╔═════════════════════╗");
        System.out.println("║Your Zodiac Sign is: ║  " + zodiac + "       ");
        System.out.println("╚═════════════════════╝");
        System.out.println(COLOR_RESET);

    }

        /**
        * Checks whether the given day, month, and year values constitute a valid calendar date.
        * Takes into account the number of days in the month and the leap year (February 29) rule.
        * @param day The day to check (1-31).
        * @param month The month to check (1-12).
        * @param year The year to check.
        * @return {@code true} if the date is valid, otherwise {@code false}.
        */

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        //Check if the day is valid for the given month.
        if (day < 1) {
            return false;
        }

        if (month == 1 && day > 31) {
            return false;
        }
        if (month == 2){
            if(day > 29)
                return false;
            if(day == 29 && year % 4 != 0)
                return false;
        }
        if (month == 3 && day > 31) {
            return false;
        }
        if (month == 4 && day > 30) {
            return false;
        }
        if (month == 5 && day > 31) {
            return false;
        }
        if (month == 6 && day > 30) {
            return false;
        }
        if (month == 7 && day > 31) {
            return false;
        }
        if (month == 8 && day > 31) {
            return false;
        }
        if (month == 9 && day > 30) {
            return false;
        }
        if (month == 10 && day > 31) {
            return false;
        }
        if (month == 11 && day > 30) {
            return false;
        }
        if (month == 12 && day > 31) {
            return false;
        }
        if (month == 2 && day ==29) {
            if (year % 4 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
    * Calculates and returns the astrological sign based on the given birth day and month.
    * 
    * @param day The birth day (1-31).
    * @param month The birth month (1-12).
    * @return The name of the determined zodiac sign, or "Invalid" if the 
    *         month/day combination does not match any zodiac range.
    */

    public static String calculateZodiac(int day, int month) {
        String zodiac = "";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) zodiac = "Aquarius";
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) zodiac = "Pisces";
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) zodiac = "Aries";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) zodiac = "Taurus";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) zodiac = "Gemini";
        else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) zodiac = "Cancer";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) zodiac = "Leo";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) zodiac = "Virgo";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) zodiac = "Libra";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) zodiac = "Scorpio";
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) zodiac = "Sagittarius";
        else if ((month == 12 && day >=22) || (month ==1 && day <=19)) zodiac = "Capricorn";
        else zodiac = "Invalid";
        return zodiac;
    }

    // OPTINON A: REVERSE THE WORDS

    /**
    * This method reverses the letters of each word in a given sentence,
    * This method reverses the letters of each word in a given sentence,
    * Takes a sentence from the user and prints the result by reversing "only the letters"
    * of each word in that sentence. Words are separated by spaces and various punctuation
    * marks. Only words containing 2 or more letters are reversed.
    */

    /**
    * Processes a user-provided sentence and reverses the letters of each word
    * that contains two or more letters, preserving the original positions of
    * non-letter characters within the word and all delimiters.
    * 
    * This method:
    * 
    * Prompts the user to enter a sentence.
    * Iterates through the sentence character by character, identifying words separated by spaces or various punctuation marks.
    * For each identified word, it counts the number of letters.
    * If a word contains **2 or more letters**, it calls the (presumed helper) method {@code reverseOnlyLetters(String)} to reverse only the letter characters within that word, keeping other characters (like apostrophes or hyphens) in place.
    * Appends the potentially reversed word and its subsequent delimiter/separator to the {@code result} string.
    * Handles the last word in the sentence if it is not followed by a delimiter.
    * Prints the final resulting sentence to the console.
    * 
    * @see #reverseOnlyLetters(String) (Presumed helper method used for the actual letter reversal)
    * @see #clearScreen()
    */
    
    public static void reverseTheWords() {
        System.out.println(COLOR_ROSE);
        System.out.println("╔═══════════════════╗");
        System.out.println("║ Reverse the Words ║");
        System.out.println("╚═══════════════════╝");
        System.out.println(COLOR_RESET);

        //I will take the sentence from the user.
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        //The variable that will hold the result.
        String result = "";

        //Temporary storage for a word.
        String word = "";

        //Process the sentence character by character.

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i); //Current character being processed.
            if (c == ' ' || c == ',' || c == '.' || c == '!' || c == '?' || c == ';' || c == ':' || c == '"' || c == '\'' || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '-' || c == '_'
                    || c == '*' || c == '+' || c == '=' || c == '/' || c == '\\' || c == '|' || c == '<' || c == '>' || c == '~' || c == '`' || c == '@') {

                int letterCount = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (Character.isLetter(word.charAt(j))) letterCount++;
                }

                if (letterCount >= 2) word = reverseOnlyLetters(word);

                result += word + c;
                word = "";
            } else {
                word += c;
            }
        }

        if (word.length() > 0) {
            int letterCount = 0;
            for (int j = 0; j < word.length(); j++) {
                if (Character.isLetter(word.charAt(j))) letterCount++;
            }

            if (letterCount >= 2) word = reverseOnlyLetters(word);
            result += word;
        }

        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("\n╔════════════════════╗");
        System.out.println("║ Reversed sentence: ║");
        System.out.println("╚════════════════════╝");
        System.out.println(COLOR_RESET);
        System.out.println(result);

    }

    /**
    * Recursively reverses a given word completely.
    * This method reverses all characters (letters, numbers, symbols) in the word.
    * @param word The word to be reversed.
    * @return The completely reversed word.
    * @see #reverseWord(String)
    */

    public static String reverseWord(String word) {
        if (word.length() <= 1) return word;
        return word.charAt(word.length() - 1) + reverseWord(word.substring(0, word.length() - 1));
    }

    /**
    * Reverses the order of "only the letters" within a given word.
    * Non-letter characters (numbers, symbols) maintain their positions.
    *
    * @param word The word whose letters are to be reversed.
    * @return The word with its letters reversed and non-letter characters preserved in their original positions.
    */

    public static String reverseOnlyLetters(String word) {
    char[] chars = word.toCharArray();
    int left = 0;
    int right = chars.length - 1;

    //Algorithm to reverse only letters, skipping non-alphabetic characters (Iteration Structure).
    while (left < right) {
        // If the left pointer is not a letter, skip it/advance
        if (!Character.isLetter(chars[left])) {
            left++;
            continue; // The continue statement skips the remaining code in the loop.
        }
        // If the right pointer is not a letter, skip it/advance
        if (!Character.isLetter(chars[right])) {
            right--;
            continue; // The continue statement skips the remaining code in the loop.
        }

        // If both are letters, swap them.
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        left++;
        right--;
    }
    return new String(chars);
}

        //================KEREM IRFANOGLU================
    //====================Secondary School====================

    /**
     * Main menu of "Secondary School".
     * <p>
     * This method displays the submenu options for the Secondary School level.
     * </p>
     *
     * <ul>
     *   <li>{@link #primeNumbers()} - Opens the Prime Number comparison module.</li>
     *   <li>{@link #evaluation()} - Opens the Step-by-Step Expression Evaluation module.</li>
     *   <li>Returns to the main menu.</li>
     * </ul>
     */

    public static void secondarySchool(){

        clearScreen();
        
        while (true) {
            System.out.println(COLOR_LIGHT_CYAN);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║        === Secondary School Menu ===           ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║          Please select your choice:            ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [1] Prime Number                             ║");
            System.out.println("║════════════════════════════════════════════════║");
            System.out.println("║   [2] Step-by-step Evaluation of Expression    ║");
            System.out.println("║════════════════════════════════════════════════║");
            System.out.println("║   [3] Return to Main Menu                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Enter your choice (1-3): "); 
            String input = scanner.nextLine();

            //If the input is integer or not?
            if (!isInt(input)) {
                clearScreen();
                System.out.println();
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! ");
                System.out.print(COLOR_RESET);
                continue;
            }
            //If the input is between 1-3?
            if(!isValidMenu(input)){
                clearScreen();
                System.out.println();
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }
            //string to integer
            int choice = Integer.parseInt(input);

            //Sending to choosen choice
            switch (choice) {
                case 1 -> primeNumbers();
                case 2 -> evaluation();
                case 3 -> System.out.println("Returning to main menu...");
            }
            break;
        }
    }
    /**
     * Checks if the given string is a valid integer.
     * <p>Used by {@link #secondarySchool()} to validate menu input.</p>
     *
     * @param input The string to check.
     * @return {@code true} if the string can be parsed as an integer, {@code false} otherwise.
     */
    private static boolean isInt(String input) {
        try {
            //use Integer.parseInt(input);
            Integer.valueOf(input);
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     * Checks if the input string is a valid menu choice (i.e., "1", "2", or "3").
     * <p>Used by {@link #secondarySchool()} to validate menu input.</p>
     *
     * @param input The string to check.
     * @return {@code true} if the input is 1, 2, or 3, {@code false} otherwise.
     */
    private static boolean isValidMenu(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= 1 && number <= 3;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
    /**
     * Prompts the user with a message and waits for a "1" (repeat) or "2" (return) input.
     * <p>
     * It will keep prompting until a valid choice is made. This method is used by the
     * {@link #primeNumbers()} and {@link #evaluation()} modules to ask the user
     * if they want to try again.
     * </p>
     *
     * @param message The prompt message to display to the user.
     * @return {@code true} if the user selects "1", {@code false} if the user selects "2".
     */
    static boolean repeat(String message){
        String answer;
        while(true) {
            System.out.print(message);
            answer = scanner.nextLine().trim().toUpperCase();
            switch (answer) {
                case "1" -> {
                    return true;
                }
                case "2" -> {
                    return false;
                }
                default -> {
                    clearScreen(); 
                    System.out.println();System.out.println(COLOR_RED);
                    System.out.println("Please enter '1' or '2'!");
                    System.out.println(COLOR_RESET);
                }
            }
        }
    }
    /**
     * Finds prime numbers up to a given number 'n' using the Sieve of Eratosthenes algorithm.
     * <p>Prints the first three primes, the last two primes, and the execution time in nanoseconds.</p>
     *
     * @param intNum The upper limit (n) to find primes up to. Must be >= 12.
     * @see #primeNumbers()
     */
    public static void sieveOfEratosthenes(int intNum) {
        
        System.out.println();
        System.out.print(COLOR_LIGHT_YELLOW);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║          Sieve of Eratosthenes          ║");
        System.out.println("╚═════════════════════════════════════════╝");

        boolean[] isPrime = new boolean[intNum+1];

        //Assuming all integers are prime (true)
        for (int i = 2; i <= intNum; i++) {
            isPrime[i] = true;
        }

        //start time
        long startTime = System.nanoTime();

        //If i is not prime, make it false
        for (int i = 2; i * i <= intNum; i++) {
            if (isPrime[i]) {
                
                for (int j = i * i; j <= intNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        //end time
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;
        //scanning the array last to first to find the last two primes.
        for(int i = intNum; i>=2; i--){
            if(isPrime[i]){
                //assigning to "last" if the integer is prime.
                if(last == -1){
                    last = i;   //
                }
                //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                else if(secondLast == -1){
                    secondLast = i;
                    break;
                }
            }
        }
        //printing the Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + String.format(Locale.GERMANY, "%,d", executionTime) + " ns");
        System.out.print(COLOR_RESET);
    }
    /**
     * Finds prime numbers up to a given number 'n' using the Sieve of Sundaram algorithm.
     * <p>Prints the first three primes, the last two primes, and the execution time in nanoseconds.</p>
     *
     * @param intNum The upper limit (n) to find primes up to. Must be >= 12.
     * @see #primeNumbers()
     */
    public static void sieveOfSundaram(int intNum){
        
        System.out.println();
        System.out.print(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║            Sieve of Sundaram            ║");
        System.out.println("╚═════════════════════════════════════════╝");

        int nNew = (intNum - 1)/2;
        boolean[] marked = new boolean[nNew +1];

        //start time
        long startTime = System.nanoTime();

        //switching not primes to true, then primes will remain false.
        for (int i = 1; i <= nNew; i++){
            for (int j = i; (long) i+j+2*(long)i*j <= nNew; j++){
                marked[i+j+2*i*j] = true;
            }
        }

        //end time
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;

        //scanning the array last to first to find the last two primes.
        for (int i = nNew; i >= 2; i--){
            if(!marked[i]){
                //turning i into prime numbers.
                int prime = 2*i + 1;
                //assigning to "last" if the integer is prime.
                if(prime <= intNum){
                    if(last == -1){
                        last = prime;
                    }
                    //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                    else if(secondLast == -1){
                        secondLast = prime;
                        break;
                    }
                }
            }
        }
        //printing the Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + String.format(Locale.GERMANY, "%,d", executionTime) + " ns");
        System.out.print(COLOR_RESET);
    }
    /**
     * Finds prime numbers up to a given number 'n' using the Sieve of Atkin algorithm.
     * <p>Prints the first three primes, the last two primes, and the execution time in nanoseconds.</p>
     *
     * @param intNum The upper limit (n) to find primes up to. Must be >= 12.
     * @see #primeNumbers()
     */
    public static void sieveOfAtkin(int intNum){

        System.out.println();
        System.out.print(COLOR_LIGHT_BLUE);
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║             Sieve of Atkin             ║");
        System.out.println("╚════════════════════════════════════════╝");

        boolean[] prime = new boolean[intNum + 1];
        //start time
        long startTime = System.nanoTime();

        //we get the squareroot of the input
        int sqrt = (int) Math.sqrt(intNum);

        for(int i = 1; i <= sqrt; i++){
            for(int j=1; j<= sqrt; j++){
                int n = 4*i*i + j*j;
                if (n <= intNum && (n%12 == 1 || n%12 == 5)){
                    prime[n] = !prime[n];
                }
                n = 3*i*i + j*j;
                if (n <= intNum && n%12 == 7){
                    prime[n] = !prime[n];
                }
                n = 3*i*i - j*j;
                if (i>j && n <= intNum && n%12 == 11){
                    prime[n] = !prime[n];
                }
            }
        }

        for(int i = 5; i<=sqrt; i++){
            if(prime[i]){
                int k = i*i;
                for(int j=k; j<= intNum; j+=k){
                    prime[j]= false;
                }
            }
        }
        //end time
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime);

        //Because of we want an integer more than or equal to 12, the first three primes are always 2, 3 and 5.
        System.out.println("First three primes: 2 3 5");

        int last = -1;
        int secondLast = -1;

        for(int i=intNum; i >= 2; i--){
            if(prime[i]){
                //assigning to "last" if the integer is prime.
                if(last == -1){
                    last = i;
                }
                //assigning second last after last is assigned. Because last will no longer be -1, next prime will be assigned to "secondLast".
                else if(secondLast == -1){
                    secondLast = i;
                    break;
                }
            }
        }
        //printing Last two primes.
        System.out.print("Last two primes: " + secondLast + " " + last);

        //execution time print
        System.out.println("\nExecution time: " + String.format(Locale.GERMANY, "%,d", executionTime) + " ns");
        System.out.print(COLOR_RESET);
    }
    /**
     * Manages the "Prime Numbers" submenu.
     * <p>
     * It prompts the user to enter an integer n (>= 12).
     * It then executes and compares the performance of the
     * {@link #sieveOfEratosthenes(int)}, {@link #sieveOfSundaram(int)},
     * and {@link #sieveOfAtkin(int)} algorithms for finding primes up to n.
     * </p>
     *
     * @see #secondarySchool()
     * @see #repeat(String)
     */
    public static void primeNumbers() {
        int intNum;
        clearScreen();

        while (true) {

            System.out.println(COLOR_ROSE);
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║          === Prime Numbers ===          ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);

            System.out.print("Please enter an integer (n >= 12): ");
            String num = scanner.nextLine().trim();
    
            if (!isInt(num)) {
                clearScreen();
                System.out.println("");
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }
    
            intNum = Integer.parseInt(num);

            if (intNum < 12) {
                clearScreen();
                System.out.println("");
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! "); 
                System.out.print(COLOR_RESET);
                continue;
            }

            if (intNum > 536_848_000) {
                clearScreen();
                System.out.println("");
                System.out.print(COLOR_RED);
                System.out.println("You entered a very large number!"); 
                System.out.print(COLOR_RESET);
                continue;
            } 
            break;
        }

        clearScreen();
        System.out.println("Results for integer: " + intNum);

        sieveOfEratosthenes(intNum);
        sieveOfSundaram(intNum);
        sieveOfAtkin(intNum);
        System.out.println();

        if(repeat("[1] Try again.\n[2] Return to secondary school menu.\nYour choice: ")){
            primeNumbers();
        }
        else{
            secondarySchool();
        }
    }
    
    //====================Step by Step Evaluation====================
    /**
     * Manages the "Step by Step Evaluation" submenu.
     * <p>
     * This module prompts the user for a mathematical expression. The expression is first
     * standardized by {@link #normalize(String)}, validated by {@link #isValidExpression(String)},
     * and then parsed into tokens by {@link #tokenize(String)}.
     * </p>
     * <p>
     * Finally, the {@link #evaluateStepByStep(List)} method solves the expression
     * and prints each step.
     * </p>
     *
     * @see #evaluateStepByStep(List)
     * @see #tokenize(String)
     * @see #isValidExpression(String)
     * @see #normalize(String)
     * @see #secondarySchool()
     */
    public static void evaluation() {
        clearScreen();

        while(true){
            System.out.println(COLOR_ROSE);
            System.out.println("╔═════════════════════════════════════════╗");
            System.out.println("║     === Step by Step Evaluation ===     ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);

            System.out.print("Enter a mathematical expression: ");
            String input = scanner.nextLine();

            clearScreen();

            String expr = normalize(input);
            
            if(!isValidExpression(expr)){
                System.out.print(COLOR_RED);
                System.out.println("Invalid input! " + COLOR_RESET); 
                continue;
            }

            List<String> tokens = tokenize(expr);
            System.out.println(renderForOutput(tokens));

            try {
                evaluateStepByStep(tokens);
                break;
            } 
            catch (ArithmeticException error) {
            System.out.println("Division by zero. Please enter a valid mathematical expression!");
            }
        }

        System.out.println("════════════════════════════════════");
        if(repeat("[1] Try again.\n[2] Return to secondary school menu.\nYour choice: ")){
            evaluation();
        }
        else{
            secondarySchool();
        }
    } 
    /**
     * Normalizes a raw mathematical expression string.
     * <p>
     * It removes all whitespace and replaces user-friendly symbols
     * (e.g., 'x', ':', '−') with their standard programmatic equivalents
     * (e.g., '*', '/', '-').
     * </p>
     * <p>
     * This is the first step before calling {@link #isValidExpression(String)}
     * or {@link #tokenize(String)}.
     * </p>
     *
     * @param s The raw expression string from the user.
     * @return A normalized expression string.
     */
    static String normalize(String s) {
        s = s.replace("×", "*");
        s = s.replace("x", "*");
        s = s.replace("X", "*");
        s = s.replace(":", "/");
        s = s.replace("−", "-");
        s = s.replace(" ", "");
    return s;
    }
    /**
     * Checks if a normalized mathematical expression is syntactically valid.
     * <p>
     * This validation includes:
     * </p>
     *
     * <ul>
     *   <li>Balanced parentheses.</li>
     *   <li>Valid operator placement (e.g., "5*+3" is invalid).</li>
     *   <li>Ensuring the expression does not start or end with invalid operators.</li>
     * </ul>
     *
     * <p>
     * This should be used after {@link #normalize(String)}.
     * </p>
     *
     * @param s The normalized expression string.
     * @return {@code true} if the expression is valid, {@code false} otherwise.
     */

    static boolean isValidExpression(String s) {
        if(s == null || s.isEmpty()) return false;

        //for paranthesis balance
        int balance = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //if char is not acceptable, return false.
            if(!(Character.isDigit(c) || c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')){
                return false;
            }

            if (c =='('){
                balance++;
            }
            else if(c == ')'){
                balance--;
                if(balance < 0) return false;
            } 
        }
        //if parantheses are not balanced, return false.
        if (balance !=0) return false;

        final int START=0, NUM=1, OP=2, OPEN=3, CLOSE=4;
        //creating a prev to check if the next char is acceptable.
        int prev = START;

        for (int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) i++;
                prev=NUM;
            }
            else if(c == '('){
                //NUM or CLOSE cannot be before OPEN
                if (prev == NUM || prev == CLOSE) return false;
                prev=OPEN;
            }
            else if(c == ')'){
                //Only NUM or CLOSE can be before CLOSE
                if (!(prev == NUM || prev == CLOSE)) return false;
                if (i+1 < s.length()) {
                    char next = s.charAt(i+1);
                    if(Character.isDigit(next) || next == '(') return false;
                }
                prev=CLOSE;
            }
            else if(c == '+' || c == '*' || c == '/'){
                //Only NUM or CLOSE can be before OP
                if (!(prev == NUM || prev == CLOSE)) return false;
                prev=OP;
            }
            else if(c == '-'){
                //"-" can be after three places: at START, OPEN or OP(negative sign).
                boolean negative = (prev == START || prev == OPEN || prev == OP);
                if(negative){
                    //next char must be a digit or else it is not a negative sign.
                    if(i+1 >= s.length() || !Character.isDigit(s.charAt(i+1))) return false;

                    //if defined negative number has more than 1 digit, it includes the remaining digits.
                    int j = i+1;
                    while(j+1 < s.length() && Character.isDigit(s.charAt(j+1)))j++;
                    i = j;
                    prev = NUM;
                }
                else{
                    // Operator "-" just can be after NUM or CLOSE
                    if(!(prev==NUM || prev==CLOSE)) return false;
                    prev = OP;
                }
            }
        }
        //Expression must end either with a NUM or CLOSE
        return (prev == NUM || prev == CLOSE);
    }
    /**
     * Tokenizes a normalized expression string into a list of its components.
     * <p>
     * It correctly identifies numbers (including multi-digit and negative numbers),
     * operators, and parentheses. It uses {@link #isOpOrOpen(String)} to
     * differentiate between a subtraction operator and a negative sign.
     * </p>
     * <p>
     * Example: "-5*(10+2)" becomes ["-5", "*", "(", "10", "+", "2", ")"]
     * </p>
     *
     * @param s The normalized expression string, presumably from {@link #normalize(String)}.
     * @return A {@link List} of String tokens.
     * @see #normalize(String)
     * @see #isOpOrOpen(String)
     */
    static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int start = i;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                tokens.add(s.substring(start, i + 1));
                i++;
            } 
            else if (c == '(' || c == ')' || c == '*' || c == '/' || c == '+') {
                tokens.add(String.valueOf(c));
                i++;
            } 
            else if (c == '-') {
                //checks if the '-' is at the start
                boolean atStart = tokens.isEmpty();
                //checks if '-' comes after an operator.
                boolean afterOpOrOpen = !tokens.isEmpty() && isOpOrOpen(tokens.get(tokens.size() - 1));
                //checks if there is a digit after '-'
                boolean hasNextDigit = (i + 1 < s.length()) && Character.isDigit(s.charAt(i + 1));

                if ((atStart || afterOpOrOpen) && hasNextDigit) {
                    int start = i;
                    i++;
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                    tokens.add(s.substring(start, i + 1));
                    i++;
                } else {
                    tokens.add("-");
                    i++;
                }
            } 
            else {
                i++;
            }
        }
        return tokens;
    }
    /**
     * A helper method for the {@link #tokenize(String)} process.
     * <p>
     * It checks if the previous token was an operator or an open parenthesis.
     * This is used to determine if a '-' character is a negative sign (e.g., "5 * -3")
     * or a subtraction operator (e.g., "5 - 3").
     * </p>
     *
     * @param lastToken The token immediately preceding the current '-' character.
     * @return {@code true} if the last token is an operator or '(', {@code false} otherwise.
     */
    static boolean isOpOrOpen(String lastToken) {
        if (lastToken == null || lastToken.isEmpty()) return false;
        return lastToken.equals("+") || lastToken.equals("-")
            || lastToken.equals("*") || lastToken.equals("/")
            || lastToken.equals("(");
    }

    /**
     * The main recursive method for evaluating the expression step-by-step.
     * <p>
     * It follows the order of operations (PEMDAS/BODMAS) by:
     * </p>
     *
     * <ol>
     *   <li>Finding the innermost parentheses using {@link #findInnermostOpenParen(List)}.</li>
     *   <li>Reducing the expression inside using {@link #reduceOnce(List, int, int)}.</li>
     *   <li>Removing redundant parentheses (e.g., "(50)") using {@link #removeParen(List, int, int)}.</li>
     *   <li>Printing each step of the reduction.</li>
     * </ol>
     *
     * <p>
     * This method calls itself recursively until the expression is reduced to a single number.
     * </p>
     *
     * @param tokens The list of tokens representing the expression.
     *               This list is modified in-place with each reduction.
     * @throws ArithmeticException if a division by zero is attempted
     *                             by {@link #reduceOnce(List, int, int)}.
     * @see #reduceOnce(List, int, int)
     * @see #findInnermostOpenParen(List)
     * @see #removeParen(List, int, int)
     */


    static void evaluateStepByStep(List<String> tokens) {

        // The expression is reduced to a single number
        if (tokens.size() == 1 && isNumberToken(tokens.get(0))) return;

        // find the innermost paranthesis
        int open = findInnermostOpenParen(tokens);
        int close = (open != -1) ? findMatchingCloseParen(tokens, open) : -1;
        int start = (open == -1) ? 0 : open + 1;
        int endEx = (open == -1) ? tokens.size() : close;

        boolean reduced = reduceOnce(tokens, start, endEx); 

        if (open != -1) {
            // after reduceOnce, because of index may have shifted, finding close again
            int close2 = findMatchingCloseParen(tokens, open);
            boolean removed = removeParen(tokens, open, close2);
            reduced = reduced || removed;
        }

        //if there are no reduction, remove the paranthesis
        if (!reduced && open != -1) {
            reduced = removeParen(tokens, open, close);
        }

        // if any action happened, print the result and call it again.
        if (reduced) {
            System.out.println("= " + renderForOutput(tokens)); 
            
            //call the method again to continue reducing the expression.
            evaluateStepByStep(tokens); 
        }
        // if reduced==false, that means there are no reduction left, so print out the result.
    }

    /**
     * Performs a single reduction operation within a specified range of the token list.
     * <p>
     * It scans first for high-precedence operators (* or /).
     * If none are found, it scans again for low-precedence operators (+ or -).
     * It performs the first operation it finds and updates the token list.
     * </p>
     *
     * @param tokens The token list. This list is modified in-place.
     * @param start The starting index (inclusive) of the range to scan.
     * @param endEx The ending index (exclusive) of the range to scan.
     * @return {@code true} if a reduction was performed, {@code false} if no operation
     * was found to reduce.
     * @throws ArithmeticException if a division by zero is attempted.
     */

    static boolean reduceOnce(List<String> tokens, int start, int endEx) {
        // look for '*' or '/'
        for (int i = start; i < endEx; i++) {
            //increase i from first token until last one.
            String tk = tokens.get(i);
            if (tk.equals("*") || tk.equals("/")) {
                //we assing a op to i. That means i-1 and i+1 must be a number
                if (i - 1 < start || i + 1 >= endEx) return false;
                //we assign i-1 to left side of the op. And i+1 to right side of the op.
                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                if (!(isNumberToken(lhs) && isNumberToken(rhs))) return false;

                long a = parseLongSafe(lhs);
                long b = parseLongSafe(rhs);
                long res; //result
                if (tk.equals("*")) {
                    res = a * b;
                } else {
                    if (b == 0)throw new ArithmeticException("division by zero");
                    res = a / b;
                }

                // replace i-1, i, i+1 with the result
                tokens.subList(i - 1, i + 2).clear();
                tokens.add(i - 1, Long.toString(res));
                return true;
            }
        }

            // look for '+' or '-'(operator '-', not negativa sign)
        for (int i = start; i < endEx; i++) {
            String tk = tokens.get(i);
            if (tk.equals("+") || tk.equals("-")) {
                //we assing a op to i. That means i-1 and i+1 must be a number
                if (i - 1 < start || i + 1 >= endEx) return false;
                //we assign i-1 to left side of the op. And i+1 to right side of the op.
                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                if (!(isNumberToken(lhs) && isNumberToken(rhs))) return false;

                long a = parseLongSafe(lhs);
                long b = parseLongSafe(rhs);
                long res = tk.equals("+") ? (a + b) : (a - b); //result

                // replace i-1, i, i+1 with the result
                tokens.subList(i - 1, i + 2).clear();
                tokens.add(i - 1, Long.toString(res));
                return true;
            }
        }

            return false;
    }
    /**
     * Finds the index of the innermost (rightmost) open parenthesis '('.
     * <p>This serves as the starting point for evaluation in {@link #evaluateStepByStep(List)}.</p>
     *
     * @param tokens The list of tokens.
     * @return The index of the last '(', or -1 if no parentheses are found.
     */
    static int findInnermostOpenParen(List<String> tokens) {
        //checking right to left to find the innermost paranthesis
        for (int i = tokens.size() - 1; i >= 0; i--) {
            if (tokens.get(i).equals("(")) {
                return i; //innermost paranthesis has found
            }
        }
        return -1; //if there are no parantheses
    }
    /**
     * Finds the matching close parenthesis ')' for a given open parenthesis '('.
     * <p>Used by {@link #evaluateStepByStep(List)} to identify the bounds of a sub-expression.</p>
     *
     * @param tokens  The list of tokens.
     * @param openIdx The index of the '(', found by {@link #findInnermostOpenParen(List)}.
     * @return The index of the matching ')' token, or -1 if not found.
     */
    static int findMatchingCloseParen(List<String> tokens, int openIdx) {
        int bal = 0;
        for (int i = openIdx; i < tokens.size(); i++) {
            if (tokens.get(i).equals("(")) bal++;
            else if (tokens.get(i).equals(")")) {
                bal--;
                if (bal == 0) return i;
            }
        }
        return -1;
    }
    /**
     * Removes parentheses from the token list if they contain only a single number.
     * <p>Example: Replaces ["(", "50", ")"] with ["50"].</p>
     * <p>This is a cleanup step used by {@link #evaluateStepByStep(List)}.</p>
     *
     * @param tokens The token list. This list is modified in-place.
     * @param open   The index of the open parenthesis '('.
     * @param close  The index of the close parenthesis ')'.
     * @return {@code true} if the parentheses were removed, {@code false} otherwise.
     */
    static boolean removeParen(List<String> tokens, int open, int close) {
        if (close - open == 2 && isNumberToken(tokens.get(open + 1))) {
            String val = tokens.get(open + 1);
            tokens.subList(open, close + 1).clear();
            tokens.add(open, val);
            return true;
        }
        return false;
    }
    /**
     * Converts a list of tokens back into a user-friendly, readable string for output.
     * <p>Replaces programmatic operators ('*', '/') with display symbols ('x', ':').</p>
     *
     * @param tokens The list of tokens to render.
     * @return A formatted, single-line string representation of the expression.
     */
    static String renderForOutput(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        for (String tk : tokens) {
            switch (tk) {
                case "*" -> sb.append('x');
                case "/" -> sb.append(':');
                default -> sb.append(tk);
            }
        }
        return sb.toString();
    }
    /**
     * Checks if a given token string represents a valid number (positive or negative).
     * <p>
     * Used by {@link #evaluateStepByStep(List)} and {@link #removeParen(List, int, int)}
     * before parsing a token.
     * </p>
     *
     * @param tk The token string to check.
     * @return {@code true} if the token is a number, {@code false} otherwise.
     */
    static boolean isNumberToken(String tk) {
        if (tk == null || tk.isEmpty()) return false;
        int i = 0;
        if (tk.charAt(0) == '-') {
            if (tk.length() == 1) return false; //it can't just '-' to be a number.
            i = 1; //if it is a negative number, skips the sign
        }
        for (; i < tk.length(); i++) {
            char c = tk.charAt(i);
            if (c < '0' || c > '9') return false; //if it is not a number, false.
        }
        return true;
    }
    
    /**
     * Safely parses a string token (which is assumed to be a valid number) into a {@code long}.
     *
     * @param tk The number token string.
     * @return The {@code long} value of the token.
     * @see #isNumberToken(String)
     * @see #reduceOnce(List, int, int)
     */
    static long parseLongSafe(String tk) {
        //transform the string token to long
        return Long.parseLong(tk);
    }

    // -------------  Taha's methods ----------------

    /**
     * This class handles the High School menu operations of the education application.
     * <p>
     * It allows users to:
     * </p>
     *
     * <ul>
     *   <li>Compute statistical information about an array.</li>
     *   <li>Compute distances between two arrays.</li>
     *   <li>Return to the main menu.</li>
     * </ul>
     *
     * @see #HighSchoolMenu()
     * @see #statisticalInformation(int)
     * @see #distanceBetweenTwoArrays(int)
     */


    public static void HighSchoolMenu() {
        while (true) {
            clearScreen();
            // Menu
            System.out.println(COLOR_LIGHT_CYAN);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║            === High School Menu ===            ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_LIGHT_BLUE);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║           Please select your choice:           ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println(COLOR_RESET);
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [1] Statistical information about an Array   ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [2] Distance between two Arrays              ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   [3] Return to Main Menu                      ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Please choose your operation (1-3): ");

            int choice = readIntInRange(1, 3);
            switch (choice) {
                case 1:
                    clearScreen();
                    statisticalInformation(choice);
                    break;
                case 2:
                    clearScreen();
                    distanceBetweenTwoArrays(choice);
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    return;
                default:
                    // unreachable due to readIntInRange
                    break;
            }
        }        
    }

    /**
     * Prompts the user to input an array of doubles, calculates
     * median, arithmetic mean, geometric mean, and harmonic mean,
     * then prints the results.
     * <p>
     * Handles input validation for array length and element ranges.
     * </p>
     *
     * @param choice The menu selection used for contextual navigation.
     * @see #computeMedian(double[])
     * @see #computeArithmeticMean(double[])
     * @see #computeGeometricMean(double[])
     * @see #computeHarmonicMeanRecursive(double[])
     */

    // Menu selection 1
     private static void statisticalInformation(int choice) {
         System.out.println(COLOR_ROSE);
         System.out.println("╔════════════════════════════════════════════════╗");
         System.out.println("║     Statistical information about an Array     ║");
         System.out.println("╚════════════════════════════════════════════════╝");
         System.out.println(COLOR_RESET);
        int n;
        while (true) {
            System.out.print("Enter the length of your array(1-20): ");
            n = readPositiveInt(choice);
            if (n <= 0) {
                System.out.println("COLOR_RED + \"Length must be a positive integer. Please try again: \" + COLOR_RESET");
            }
            else if(n > 20) {
                clearScreen();
                System.out.println(COLOR_RED + "Length cannot exceed 20. Please enter a value between 1 and 20: " + COLOR_RESET);
            }
            else {
                break;
            }
        }
        // Populating the array
        double[] arr = new double[n];
        System.out.println("Enter the members of your array(Between -1_000_000.0 and +1_000_000.0;):");
        for (int i = 0; i < n; i++) {
            arr[i] = readDoubleWithPrompt("Member " + (i + 1) + ": ");
        }

        Arrays.sort(arr); // Sorting for the median

        // Calculations
        double median = computeMedian(arr);
        double arithmeticMean = computeArithmeticMean(arr);
        Double geometricMean = computeGeometricMean(arr); 
        Double harmonicMean = computeHarmonicMeanRecursive(arr); 
        // Printing the calculations
         clearScreen();
         System.out.println(COLOR_LIGHT_GREEN);
         System.out.println("╔═════════════════╗");
         System.out.println("║     Results     ║");
         System.out.println("╚═════════════════╝");
        System.out.printf("Sorted array: %s%n", Arrays.toString(arr));
        System.out.printf("Median: %s%n", formatDoubleOrMsg(median, ""));
        System.out.printf("Arithmetic Mean: %s%n", formatDoubleOrMsg(arithmeticMean, ""));
        if (geometricMean == null) {
            System.out.println("Geometric Mean: Undefined (One of the members in this array is <= 0)");
        } 
        else {
            System.out.printf("Geometric Mean: %s%n", formatDoubleOrMsg(geometricMean, ""));
        }
        if (harmonicMean == null) {
            System.out.println("Harmonic Mean: Undefined (One of the members in this array is <= 0)");
        } 
        else {
            System.out.printf("Harmonic Mean: %s%n", formatDoubleOrMsg(harmonicMean, ""));
        }
        System.out.println(COLOR_RESET);
        promptEnterToContinue();
    }

    /**
     * Prompts the user to input two integer arrays, calculates
     * Manhattan distance, Euclidean distance, and cosine similarity,
     * then prints the results.
     * <p>
     * Handles input validation for array length and element ranges.
     * </p>
     *
     * @param choice The menu selection used for contextual navigation.
     * @see #computeManhattan(int[], int[])
     * @see #computeEuclidean(int[], int[])
     * @see #computeCosineSimilarity(int[], int[])
     */

    // Menu selection 2
    private static void distanceBetweenTwoArrays(int choice) {
        System.out.println(COLOR_ROSE);
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║           Distance between two arrays          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(COLOR_RESET);
        int dim;
        while (true) {
            System.out.print("Enter the length of your array: ");
            dim = readPositiveInt(choice);
            if (dim <= 0) {
                System.out.println("COLOR_RED + \"Length must be positive integer. Please try again.\" + COLOR_RESET");
            }
            else if(dim > 20) {
                clearScreen();
                System.out.println(COLOR_RED + "Length cannot exceed 20. Please enter a value between 1 and 20: " + COLOR_RESET);
            }
            else {
                break;
            }
        }

        System.out.println("Enter members of the first array (Must be 0-9 integer):");
        int[] a = new int[dim];
        for (int i = 0; i < dim; i++) {
            a[i] = readIntInRangeWithPrompt(0, 9, "a[" + i + "]: ");
        }

        System.out.println("Enter members of the second array (Must be 0-9 integer):");
        int[] b = new int[dim];
        for (int i = 0; i < dim; i++) {
            b[i] = readIntInRangeWithPrompt(0, 9, "b[" + i + "]: ");
        }
        // Calculations
        double manhattan = computeManhattan(a, b);
        double euclidean = computeEuclidean(a, b);
        Double cosine = computeCosineSimilarity(a, b);
        // Printing the Results
        clearScreen();
        System.out.println(COLOR_LIGHT_GREEN);
        System.out.println("╔═════════════════╗");
        System.out.println("║     Results     ║");
        System.out.println("╚═════════════════╝");
        System.out.printf("First Array: %s%n", Arrays.toString(a));
        System.out.printf("Second Array: %s%n", Arrays.toString(b));
        System.out.printf("Manhattan Distance: %s%n", formatDoubleOrMsg(manhattan, ""));
        System.out.printf("Euclidean Distance: %s%n", formatDoubleOrMsg(euclidean, ""));
        if (cosine == null) {
            System.out.println("Cosine Similarity: Undefined (The array has a norm of 0).");
        } 
        else {
            System.out.printf("Cosine Similarity: %s%n", formatDoubleOrMsg(cosine, ""));
        }
        System.out.println(COLOR_RESET);
        promptEnterToContinue();
    }

    /**
     * Computes the median of a sorted array.
     *
     * @param sortedArr The sorted array of doubles.
     * @return The median value.
     * @see #statisticalInformation(int)
     */

    // Calculation Methods
    private static double computeMedian(double[] sortedArr) {
        int n = sortedArr.length;
        if (n % 2 == 1) {
            return sortedArr[n / 2];
        } 
        else {
            // even: average of two middle elements
            return (sortedArr[n / 2 - 1] + sortedArr[n / 2]) / 2.0;
        }
    }

    /**
     * Computes the arithmetic mean of an array.
     *
     * @param arr The array of doubles.
     * @return The arithmetic mean value.
     * @see #statisticalInformation(int)
     */

    private static double computeArithmeticMean(double[] arr) {
        double sum = 0.0;
        for (double v : arr) sum += v;
        return sum / arr.length;
    }

    /**
     * Computes the geometric mean of an array.
     * Returns null if any element is &lt;= 0.
     *
     * @param arr The array of doubles.
     * @return The geometric mean, or null if undefined.
     * @see #statisticalInformation(int)
     */

    private static Double computeGeometricMean(double[] arr) {
        for (double v : arr) {
            if (v <= 0.0){
                return null;
            }
        }
        double logSum = 0.0;
        for (double v : arr) {
            logSum += Math.log(v);
        }
        return Math.exp(logSum / arr.length);
    }

    /**
     * Computes the harmonic mean of an array recursively.
     * Returns null if any element is zero.
     *
     * @param arr The array of doubles.
     * @return The harmonic mean, or null if undefined.
     * @see #sumReciprocalRecursive(double[], int)
     * @see #statisticalInformation(int)
     */

    private static Double computeHarmonicMeanRecursive(double[] arr) {
        for (double v : arr) {
            if (v == 0.0){
                return null;
            }
        }
        double reciprocalSum = sumReciprocalRecursive(arr, 0);
        return arr.length / reciprocalSum;
    }

    /**
     * Recursively computes the sum of reciprocals of array elements.
     *
     * @param arr The array of doubles
     * @param idx The current index for recursion
     * @return Sum of reciprocals from idx to end of the array
     */

    // Recursive Methods
    private static double sumReciprocalRecursive(double[] arr, int idx) {
        if (idx >= arr.length){
            return 0.0;
        }
        return (1.0 / arr[idx]) + sumReciprocalRecursive(arr, idx + 1);
    }

    /**
     * Computes the Manhattan distance between two arrays.
     *
     * @param a First array of integers
     * @param b Second array of integers
     * @return The Manhattan distance
     */

    private static double computeManhattan(int[] a, int[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        return sum;
    }

    /**
     * Computes the Euclidean distance between two arrays.
     *
     * @param a First array of integers
     * @param b Second array of integers
     * @return The Euclidean distance
     */

    private static double computeEuclidean(int[] a, int[] b) {
        double sumsq = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i] - b[i];
            sumsq += d * d;
        }
        return Math.sqrt(sumsq);
    }

    /**
     * Computes the cosine similarity between two arrays.
     * Returns null if either array has a zero norm.
     *
     * @param a First array of integers
     * @param b Second array of integers
     * @return Cosine similarity or null if undefined
     */
    
    private static Double computeCosineSimilarity(int[] a, int[] b) {
        double dot = 0.0;
        double na = 0.0;
        double nb = 0.0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            na += a[i] * a[i];
            nb += b[i] * b[i];
        }
        double normA = Math.sqrt(na);
        double normB = Math.sqrt(nb);
        if (normA == 0.0 || normB == 0.0){
            return null;
        }
        return dot / (normA * normB);
    }

    /**
     * Reads an integer from user input within a given range.
     *
     * @param min Minimum acceptable value.
     * @param max Maximum acceptable value.
     * @return The validated integer input.
     */

    // Input and output validation
    private static int readIntInRange(int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val < min || val > max) {
                    clearScreen();
                    System.out.println(COLOR_LIGHT_CYAN);
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║            === High School Menu ===            ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println(COLOR_LIGHT_BLUE);
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║           Please select your choice:           ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println(COLOR_RESET);
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║   [1] Statistical information about an Array   ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║   [2] Distance between two Arrays              ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.println("╔════════════════════════════════════════════════╗");
                    System.out.println("║   [3] Return to Main Menu                      ║");
                    System.out.println("╚════════════════════════════════════════════════╝");
                    System.out.printf(COLOR_RED + "Input out of range. Please enter an integer between %d and %d: " + COLOR_RESET, min, max);
                    continue;
                }
                return val;
            } 
            catch (NumberFormatException ex) {
                clearScreen();
                System.out.println(COLOR_LIGHT_CYAN);
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║            === High School Menu ===            ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.println(COLOR_LIGHT_BLUE);
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║           Please select your choice:           ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.println(COLOR_RESET);
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║   [1] Statistical information about an Array   ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║   [2] Distance between two Arrays              ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║   [3] Return to Main Menu                      ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.print(COLOR_RED + "Invalid input, please try again: " + COLOR_RESET);
            }
        }
    }

    /**
     * Reads an integer from user input within a given range,
     * with a custom prompt.
     *
     * @param min Minimum acceptable value.
     * @param max Maximum acceptable value.
     * @param prompt Message displayed to the user.
     * @return The validated integer input.
     */

    private static int readIntInRangeWithPrompt(int min, int max, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                int val = Integer.parseInt(line);
                if (val < min || val > max) {
                    clearScreen();
                    System.out.printf(COLOR_RED + "Invalid input. Please enter an integer between %d and %d.%n" + COLOR_RESET, min, max);
                    continue;
                }
                return val;
            } 
            catch (NumberFormatException ex) {
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input please try again: " + COLOR_RESET);
            }
        }
    }

    /**
     * Reads a positive integer from user input with validation.
     * Handles empty, negative, and overflow inputs.
     *
     * @param choice The menu selection for contextual navigation.
     * @return The validated positive integer input.
     */

    private static int readPositiveInt(int choice) {
        while (true) {
            try {
                String line = sc.nextLine().trim();

                if (line.isEmpty()) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Invalid input, please enter a positive integer. " + COLOR_RESET);
                    if (choice == 1) statisticalInformation(choice);
                    else if (choice == 2) distanceBetweenTwoArrays(choice);
                    continue;
                }
                if (line.charAt(0) == '-') {
                    clearScreen();
                    System.out.println(COLOR_RED + "Enter a positive integer. " + COLOR_RESET);
                    if (choice == 1) statisticalInformation(choice);
                    else if (choice == 2) distanceBetweenTwoArrays(choice);
                    continue;
                }
                if (line.charAt(0) == '+') {
                    line = line.substring(1);
                    if (line.isEmpty()) {
                        clearScreen();
                        System.out.println(COLOR_RED + "Invalid input, please enter a positive integer. " + COLOR_RESET);
                        if (choice == 1) statisticalInformation(choice);
                        else if (choice == 2) distanceBetweenTwoArrays(choice);
                        continue;
                    }
                }
                if (!line.matches("\\d+")) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Invalid input, please enter a positive integer. " + COLOR_RESET);
                    if (choice == 1) statisticalInformation(choice);
                    else if (choice == 2) distanceBetweenTwoArrays(choice);
                    continue;
                }
                java.math.BigInteger bi = new java.math.BigInteger(line);
                java.math.BigInteger intMax = java.math.BigInteger.valueOf(Integer.MAX_VALUE);
                if (bi.compareTo(intMax) > 0) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Input is too large (Overflow). Please enter an number between 1 and 20." + COLOR_RESET);
                    if (choice == 1) statisticalInformation(choice);
                    else if (choice == 2) distanceBetweenTwoArrays(choice);
                    continue;
                }

                int v = bi.intValue();
                if (v <= 0) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Enter a positive integer. " + COLOR_RESET);
                    if (choice == 1) statisticalInformation(choice);
                    else if (choice == 2) distanceBetweenTwoArrays(choice);
                    continue;
                }

                return v;

            }
            catch (NumberFormatException ex) {
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input, please enter a positive integer. " + COLOR_RESET);
                if (choice == 1) statisticalInformation(choice);
                else if (choice == 2) distanceBetweenTwoArrays(choice);
            }
        }
    }

    /**
     * Prompts the user to enter a double value within the range -1,000,000 to +1,000,000
     * and validates the input.
     * <p>
     * This method repeatedly asks the user for input until a valid double is entered.
     * It handles the following cases:
     * <ul>
     *     <li>Replaces commas with dots to support locales where comma is used as decimal separator.</li>
     *     <li>Rejects inputs that are not valid doubles (NumberFormatException).</li>
     *     <li>Rejects values outside the range -1,000,000 to +1,000,000.</li>
     *     <li>Rejects NaN values.</li>
     * </ul>
     * If the user enters an invalid value, the console is cleared, an error message is displayed,
     * and the user is prompted again.
     *
     * @param prompt The message displayed to the user before reading input.
     * @return A validated double value entered by the user within the range -1,000,000 to +1,000,000.
     */

    private static double readDoubleWithPrompt(String prompt) {
        final double MAX_VALUE = 1_000_000.0;
        final double MIN_VALUE = -1_000_000.0;

        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim().replace(',', '.');
                java.math.BigDecimal bd = new java.math.BigDecimal(line);

                // Belirlenen sınırlar içinde mi kontrol et
                if (bd.compareTo(java.math.BigDecimal.valueOf(MAX_VALUE)) > 0 ||
                    bd.compareTo(java.math.BigDecimal.valueOf(MIN_VALUE)) < 0) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Input out of range. Please enter a number between " 
                                    + MIN_VALUE + " and " + MAX_VALUE + "." + COLOR_RESET);
                    continue;
                }

                double value = bd.doubleValue();

                if (Double.isNaN(value)) {
                    clearScreen();
                    System.out.println(COLOR_RED + "Invalid input (Not a Number). Please enter a valid double." + COLOR_RESET);
                    continue;
                }

                return value;
            } 
            catch (NumberFormatException ex) {
                clearScreen();
                System.out.println(COLOR_RED + "Invalid input, please enter a valid double: " + COLOR_RESET);
            }
        }
    }
    /**
     * Formats a double value to a string with 6 decimal places.
     *
     * @param d The double value to format.
     * @param unused Placeholder parameter (not used).
     * @return The formatted string.
     */

    private static String formatDoubleOrMsg(double d, String unused) {
        return String.format("%.6f", d);
    }

    /**
     * Pauses execution until the user presses Enter.
     */

    private static void promptEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        sc.nextLine(); }
}