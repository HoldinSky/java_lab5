package task_5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Основний керуючий клас для маніпуляціє публякаціями на форумі.
 * <p>
 * Реалізовує інтерфейс IForumPostEditor, імітуючи форум зі збереженням змін лише у пам'яті.
 * </p>
 */
public class ForumPostEditor implements IForumPostEditor {

    /**
     * Колекція, що представляє собою список постів на форумі.
     * <p>
     * У реальному застосунку повинено бути налаштований зв'язок з БД.
     * </p>
     */
    private final List<ForumPost> posts;
    private Long counter = 0L;

    /**
     * Базовий конструктор для імітацій форуму з тестовим наповненням.
     *
     * @param clear якщо передано true, внутрішня колекція буде порожньою. В іншому випадку - наповнена тестовими
     *              даними
     */
    public ForumPostEditor(boolean clear) {
        posts = new ArrayList<>();

        if (clear) return;

        posts.add(new ForumPost(counter++, "Nazar Krylov", "Java", "Creating Lab5 for KPI right now.",
                LocalDateTime.of(LocalDate.ofYearDay(2023, 320), LocalTime.MIDNIGHT)));
        posts.add(new ForumPost(counter++, "Nazar Krylov", "Physics", "Is everybody informed about control work that "
                + "is " + "coming next week?", LocalDateTime.of(LocalDate.ofYearDay(2023, 321), LocalTime.MIDNIGHT)));
        posts.add(new ForumPost(counter++, "Bogdan", "C++", "Rate this new game I have been developing for the last " +
                "2" + " months!", LocalDateTime.of(LocalDate.ofYearDay(2023, 322), LocalTime.MIDNIGHT)));
        posts.add(new ForumPost(counter++, "Mark", "Kotlin", "Have you already tried new features of recent update?",
                LocalDateTime.of(LocalDate.ofYearDay(2023, 323), LocalTime.MIDNIGHT)));
    }

    @Override
    public void createPost(String author, String topic, String text, LocalDateTime creationTime) {
        posts.add(new ForumPost(counter++, author, topic, text, creationTime));
    }

    @Override
    public void updatePost(Long oldPostId, String newText) throws IllegalArgumentException {
        var oldPost =
                posts.stream().filter(p -> p.id().equals(oldPostId)).findFirst().orElseThrow(
                        () -> new IllegalArgumentException("Failed to find post by specified id")
                );

        posts.remove(oldPost);
        posts.add(new ForumPost(oldPostId, oldPost.author(), oldPost.topic(), newText, oldPost.creationTime()));
    }

    @Override
    public List<ForumPost> getAllPosts() {
        return posts;
    }
}
