package com.github.vlasec.feedback.rest;

import com.github.vlasec.feedback.entity.Feedback;
import com.github.vlasec.feedback.rest.dto.create.FeedbackDtoCreator;
import com.github.vlasec.feedback.rest.dto.extract.FeedbackDtoExtractor;
import com.github.vlasec.feedback.service.FeedbackService;
import com.github.vlasec.feedback.rest.dto.FeedbackDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class FeedbackController {
    @Inject
    private FeedbackService feedbackService;
    @Inject
    private FeedbackDtoExtractor feedbackDtoExtractor;
    @Inject
    private FeedbackDtoCreator feedbackDtoCreator;

    /**
     * Response to POST, stores the feedback.
     * @param feedbackDto input DTO to be stored.
     * @return response with updated entity that includes ID and creation date
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackDtoExtractor.extract(feedbackDto);
        feedbackService.save(feedback);

        FeedbackDto updatedDto = feedbackDtoCreator.create(feedback);
        return Response.accepted(updatedDto).build();
    }

    /**
     * Response to GET, returns all stored feedback or filters by name if name parameter is provided.
     * @param name name to be used as filter, all results if null or empty
     * @return response with all stored feedback or filtered results
     */
    @GET
    @Produces("application/json")
    public Response filterByName(@QueryParam("name") String name) {
        final List<Feedback> result;
        if (name == null || "".equals(name)) {
            result = feedbackService.getAll();
        } else {
            result = feedbackService.filterByName(name);
        }

        List<FeedbackDto> dto = feedbackDtoCreator.create(result);
        return Response.ok(dto).build();
    }
}
