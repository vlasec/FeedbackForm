# FeedbackForm
A demo feedback form to show my prowess in Java as a part of job application.

## Usage

This is a REST application with no UI. Use e.g. Postman.

### Add new feedback

`POST` a JSON with following format at root URL:

```JSON
{
    "name": "Jan Novak",
    "message": "This feedback form is lame, doesn't even have UI. 1/5"
}
```

### Retrieve feedback

`GET` at root URL. Optional parameter `name` to be used as a filter.
With no name provided, returns all feedback. 