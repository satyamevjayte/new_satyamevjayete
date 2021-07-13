package com.satyamevjayate.api.controller;

import com.satyamevjayate.api.entity.Feedback;
import com.satyamevjayate.api.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackService.listAllFeedback();
    }


    @PostMapping("/feedback")
    public String addContact(@RequestBody Feedback feedback)
    {
        feedbackService.saveFeedback(feedback);
        return "Feedback Add Successfully";
    }
}
