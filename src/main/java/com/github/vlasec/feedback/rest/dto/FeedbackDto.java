package com.github.vlasec.feedback.rest.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Data transfer object used in both directions.
 */
@JsonDeserialize(builder = FeedbackDto.Builder.class)
public class FeedbackDto {
    private final Long id;
    private final String name;
    private final String message;
    private final String createdAt;

    private FeedbackDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.message = builder.message;
        this.createdAt = builder.createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String message;
        private String createdAt;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FeedbackDto build() {
            return new FeedbackDto(this);
        }
    }
}
