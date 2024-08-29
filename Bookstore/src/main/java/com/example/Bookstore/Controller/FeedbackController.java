package com.example.Bookstore.Controller;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Model.Feedback;
import com.example.Bookstore.Model.FeedbackDTO;
import com.example.Bookstore.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore_user")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    
    @GetMapping("/get/feedback/{productId}")
    public List<Feedback>getFeedbackByProductId(@PathVariable("productId") Long productId){
        return feedbackService.getFeedbackByProductId(productId);
    }

    @PostMapping("/add/feedback/{product_id}")
    public String addFeedback(@PathVariable Long product_id, @RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.addFeedback(product_id,feedbackDTO);
    }


}
