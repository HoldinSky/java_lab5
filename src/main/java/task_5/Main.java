package task_5;

import java.time.LocalDateTime;
import java.util.Scanner;

// Побудувати програму для роботи з класом для зберігання даних про повідомлення в форумі (автор, тема, текст, час,
// дата створення та редагування). Програма повинна забезпечувати функції введення, редагування, виведення значень.


/**
 * Клас запуску застосунку.
 * <p>
 * Містить меню, обробник введення в консоль та надає можливості, що вимагаються завданням.
 * </p>
 */
public class Main {

    private MenuOption menuOption = MenuOption.None;
    private final Scanner scanner = new Scanner(System.in);
    private final IForumPostEditor postEditor;


    private Main(IForumPostEditor editor) {
        this.postEditor = editor;
    }

    private void menu() {
        do {
            printMenu();

            try {
                var option = scanner.nextInt();
                menuOption = MenuOption.fromInteger(option);
                scanner.skip("\n");

                processMenuOption();
            } catch (Throwable e) {
                System.err.println(e.getMessage());
            }

        } while (menuOption != MenuOption.Exit);
    }

    private void printMenu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Publish post");
        System.out.println("2. Update existing post");
        System.out.println("3. List posts");
        System.out.println("4. Exit");
        System.out.print(">> ");
        System.out.flush();
    }

    private void processMenuOption() {
        switch (menuOption) {
            case Post -> processPublicPost();
            case Update -> processUpdatePost();
            case ListAll -> processListPosts();
            case None -> System.err.println("Bad menu option has been chose " + menuOption);
            case Exit -> {
            }
        }
    }

    private void processPublicPost() {
        System.out.println("PUBLISHING NEW POST");
        System.out.print("What is your name? >> ");
        System.out.flush();
        var name = scanner.nextLine();

        System.out.print("What is the topic? >> ");
        System.out.flush();
        var topic = scanner.nextLine();

        System.out.print("Input content >> ");
        System.out.flush();
        var text = scanner.nextLine();

        postEditor.createPost(name, topic, text, LocalDateTime.now());
    }

    private void processUpdatePost() {
        System.out.println("UPDATING POST");
        System.out.print("Enter the id of post to be updated >> ");
        System.out.flush();
        var postId = scanner.nextLong();
        scanner.skip("\n");

        System.out.print("Enter new text for the post >> ");
        System.out.flush();
        var newText = scanner.nextLine();

        try {
            postEditor.updatePost(postId, newText);
        } catch (IllegalArgumentException exc) {
            System.out.println("Error: " + exc.getLocalizedMessage());
        }
    }

    private void processListPosts() {
        System.out.println("ALL POSTS LIST");
        postEditor.getAllPosts().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Main app = new Main(new ForumPostEditor(false));

        app.menu();
    }
}
