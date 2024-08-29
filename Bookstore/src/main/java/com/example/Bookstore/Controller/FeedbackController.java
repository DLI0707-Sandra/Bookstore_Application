package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Feedback;
import com.example.Bookstore.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @GetMapping
    public List<Feedback>getAllFeedback(){
        return feedbackService.getAllFeedback();
    }
    @GetMapping("/product/{productId}")
    public Optional<Feedback> getFeedbackByProductId(Long productId){
        return feedbackService.getFeedbackByProductId(productId);
    }
    @GetMapping("/{id}")
    public Feedback getFeedbackById(Long id){
        return feedbackService.getFeedbackById(id);
    }
    @PostMapping("/feedback/{bookId}")
    public Feedback addFeedback(@PathVariable Long bookId, @RequestBody Feedback feedback) {
        feedback.setProductId(bookId);
        return feedbackService.addFeedback(feedback);
    }
    @DeleteMapping("/{id}")
    public String deleteFeedbackById(@PathVariable Long id){
        return feedbackService.deleteFeedbackById(id);
    }

}
