package task_5;

import java.time.LocalDateTime;
import java.util.List;

public interface IForumPostEditor {
	void createPost(String author, String topic, String text, LocalDateTime creationTime);
	void updatePost(Long oldPostId, String newText) throws IllegalArgumentException;
	List<ForumPost> getAllPosts();
}
