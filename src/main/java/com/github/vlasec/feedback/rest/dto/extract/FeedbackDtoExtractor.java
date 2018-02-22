package com.github.vlasec.feedback.rest.dto.extract;

import com.github.vlasec.feedback.entity.Feedback;
import com.github.vlasec.feedback.rest.dto.FeedbackDto;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class FeedbackDtoExtractor implements DtoExtractor <FeedbackDto, Feedback> {
    @Override
    public Feedback extract(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setName(feedbackDto.getName());
        feedback.setMessage(feedbackDto.getMessage());
        return feedback;
    }
}
