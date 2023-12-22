package task_5;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass {

    @Test
    public void testPostEditor() {
        var postEditor = new ForumPostEditor(true);
        assertEquals(postEditor.getAllPosts().size(), 0);

        postEditor.createPost("Nazar", "Test1", "Testing post text", LocalDateTime.MIN);
        postEditor.createPost("Andrew", "Test2", "Testing post text with some creativity", LocalDateTime.MIN);
        postEditor.createPost("Mykola", "Test3", "Testing post text after this there must be 3 records",
                LocalDateTime.MIN);

        var expected = new ForumPost[]{
                new ForumPost(0L, "Nazar", "Test1", "Testing post text", LocalDateTime.MIN),
                new ForumPost(1L, "Andrew", "Test2", "Testing post text with some creativity", LocalDateTime.MIN),
                new ForumPost(2L, "Mykola", "Test3", "Testing post text after this there must be 3 records",
                        LocalDateTime.MIN)
        };
        var actual = postEditor.getAllPosts().toArray(new ForumPost[0]);

        for (var exp : expected) {
            assertTrue(Arrays.asList(actual).contains(exp));
        }

        postEditor.updatePost(1L, "Absolutely new text");
        expected[1] = new ForumPost(1L, "Andrew", "Test2", "Absolutely new text", LocalDateTime.MIN);
        actual = postEditor.getAllPosts().toArray(new ForumPost[0]);

        for (var exp : expected) {
            assertTrue(Arrays.asList(actual).contains(exp));
        }
    }
}
