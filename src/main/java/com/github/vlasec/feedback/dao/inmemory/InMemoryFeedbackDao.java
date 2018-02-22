package com.github.vlasec.feedback.dao.inmemory;

import com.github.vlasec.feedback.dao.FeedbackDao;
import com.github.vlasec.feedback.entity.Feedback;

import javax.ejb.Singleton;
import java.time.LocalDateTime;
import java.util.*;

/**
 * A simple in-memory implementation of a DAO, basically a better mock.
 * This should be replaced by some JPA or JDBC implementation if it was a real scenario and not just a test / demo.
 * Methods are synchronized to prevent possible issues with concurrent access.
 */
@Singleton
public class InMemoryFeedbackDao implements FeedbackDao {
    private List<Feedback> values = new ArrayList<>();
    // A simple way of indexing the contents, to prevent reading through all the entries when filtering.
    private Map<String, List<Feedback>> nameIndex = new HashMap<>();
    private long lastId = 0;

    @Override
    public synchronized void insert(Feedback feedback) {
        feedback.setId(++lastId);
        feedback.setCreatedAt(LocalDateTime.now());
        values.add(feedback);
        // initializes to an empty list if there hasn't been any feedback from a bearer of this name.
        nameIndex.putIfAbsent(feedback.getName(), new ArrayList<>());
        nameIndex.get(feedback.getName()).add(feedback);
    }

    @Override
    public synchronized List<Feedback> getAll() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public synchronized List<Feedback> filterByName(String name) {
        return Collections.unmodifiableList(nameIndex.getOrDefault(name, Collections.emptyList()));
    }
}
