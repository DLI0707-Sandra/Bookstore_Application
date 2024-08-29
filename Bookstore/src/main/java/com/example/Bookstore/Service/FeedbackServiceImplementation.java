package com.example.Bookstore.Service;

import com.example.Bookstore.Model.Feedback;
import com.example.Bookstore.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImplementation implements FeedbackService{
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> getFeedbackByProductId(Long productId) {
        return feedbackRepository.findByProductId(productId);
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteFeedbackById(Long id) {
        if (feedbackRepository.findById(id).isEmpty())
            return "Feedback not found";
        else
        {
            feedbackRepository.deleteById(id);
            return "Feedback deleted";
        }
    }
}
