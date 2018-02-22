package com.github.vlasec.feedback.service;

import com.github.vlasec.feedback.dao.FeedbackDao;
import com.github.vlasec.feedback.entity.Feedback;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * This service contains application logic that handles feedback.
 */
@Stateless
@LocalBean
public class FeedbackService {
    @Inject
    private FeedbackDao feedbackDao;

    /**
     * Saves the feedback
     */
    public void save(Feedback feedback) {
        feedbackDao.insert(feedback);
    }

    /**
     * Returns all contained feedback
     */
    public List<Feedback> getAll() {
        return feedbackDao.getAll();
    }

    /**
     * Returns all feedback filtered by name.
     */
    public List<Feedback> filterByName(String name) {
        return feedbackDao.filterByName(name);
    }
}

