package task_5;

public enum MenuOption {
    Post(1), Update(2), ListAll(3), Exit(4), None(-1);

    public final int option;

    MenuOption(int option) {
        this.option = option;
    }

    public static MenuOption fromInteger(int option) {
        return switch (option) {
            case 1 -> Post;
            case 2 -> Update;
            case 3 -> ListAll;
            case 4 -> Exit;
            default ->
                    throw new IllegalArgumentException("Could not parse option. Min=" + Post.option + ", Max=" + Exit.option);
        };
    }
}

