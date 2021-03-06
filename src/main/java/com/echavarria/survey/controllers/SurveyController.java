package com.echavarria.survey.controllers;

import com.echavarria.survey.entities.Survey;
import com.echavarria.survey.services.SurveyServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/survey")
@CrossOrigin(origins = "*")
public class SurveyController {

    private final SurveyServices surveyServices;

    public SurveyController(SurveyServices surveyServices) {
        this.surveyServices = surveyServices;
    }

    @PostMapping("")
    public Survey saveSurvey(@RequestBody Survey survey) {
        return surveyServices.saveSurvey(survey);
    }

    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable("id") Long id) {
        return surveyServices.retrieveSurveyById(id);
    }

}
