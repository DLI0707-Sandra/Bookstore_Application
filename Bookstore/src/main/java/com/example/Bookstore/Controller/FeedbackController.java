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

//    @GetMapping
//    public List<Feedback>getAllFeedback(){
//        return feedbackService.getAllFeedback();
//    }
//    @GetMapping("/get/feedback/{productId}")
//    public List<Feedback>getFeedbackByProductId(@PathVariable("productId") Long productId){
//        return feedbackService.getFeedbackByProductId(productId);
//    }
//    @GetMapping("/{id}")
//    public Feedback getFeedbackById(Long id){
//        return feedbackService.getFeedbackById(id);
//    }
//    @PostMapping("/add/feedback/{product_id}")
//    public String addFeedback(@PathVariable Long product_id, @RequestBody FeedbackDTO feedbackDTO) {
//        return feedbackService.addFeedback(product_id,feedbackDTO);
//    }

//    @DeleteMapping("/{id}")
//    public String deleteFeedbackById(@PathVariable Long id){
//        return feedbackService.deleteFeedbackById(id);
//    }

}
