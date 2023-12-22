package task_5;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Базовий клас для збереження інформації про пост на форумі.
 * <p>
 * Має перевизначені методи equals(), hashCode() та toString() відповідно до завдання
 * </p>
 *
 * @param author       автор посту
 * @param topic        основна тема посту (розділ)
 * @param text         повідомлення посту
 * @param creationTime час, коли було опубліковано пост
 */
public record ForumPost(Long id, String author, String topic, String text, LocalDateTime creationTime) {

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ForumPost otherPost)) {
            return false;
        }

        return this.id.equals(otherPost.id) &&
                this.author.equals(otherPost.author) &&
                this.topic.equals(otherPost.topic) &&
                this.text.equals(otherPost.text) &&
                this.creationTime.equals(otherPost.creationTime);
    }

    /**
     * Згенеровано за допомогою IDE IntelliJ IDEA
     * */
    @Override
    public int hashCode() {
        return Objects.hash(id, author, topic, text, creationTime);
    }

    @Override
    public String toString() {
        return String.format("Post: { id=%d, author=%s, topic='%s', text='%s'. published on=%s }",
                this.id, this.author,
                this.topic, this.text,
                this.creationTime
        );
    }
}
