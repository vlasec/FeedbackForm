package com.github.vlasec.feedback.rest.dto.create;

import com.github.vlasec.feedback.entity.Feedback;
import com.github.vlasec.feedback.rest.dto.FeedbackDto;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.format.DateTimeFormatter;

@LocalBean
@Stateless
public class FeedbackDtoCreator implements DtoCreator<Feedback, FeedbackDto> {

    @Override
    public FeedbackDto create(Feedback feedback) {
        return new FeedbackDto.Builder()
                .withId(feedback.getId())
                .withName(feedback.getName())
                .withMessage(feedback.getMessage())
                .withCreatedAt(feedback.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }
}
