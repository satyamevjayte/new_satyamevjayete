package com.satyamevjayate.api.services;

import com.satyamevjayate.api.entity.Feedback;
import com.satyamevjayate.api.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedback_repo;
    public List<Feedback> listAllFeedback()
    {
        return feedback_repo.findAll();
    }
    public void saveFeedback(Feedback feedback)
    {
        feedback_repo.save(feedback);
    }
}
