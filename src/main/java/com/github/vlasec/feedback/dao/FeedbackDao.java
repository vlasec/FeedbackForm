package com.github.vlasec.feedback.dao;

import com.github.vlasec.feedback.entity.Feedback;

import javax.ejb.Local;
import java.util.List;

/**
 * Data access object for Feedback entity.
 */
@Local
public interface FeedbackDao {
    /**
     * Inserts the feedback object to the data store.
     * @param feedback the entity to be stored, can be updated by the operation on the data store
     */
    void insert(Feedback feedback);

    /**
     * Returns a list containing all feedback objects stored in the data store.
     * @return all entities
     */
    List<Feedback> getAll();

    /**
     * Filters the stored feedback objects by name and returns all matching entities.
     * @param name name to be used as a filter
     * @return all matching entities
     */
    List<Feedback> filterByName(String name);
}
