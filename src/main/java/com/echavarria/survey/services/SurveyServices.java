package com.echavarria.survey.services;

import com.echavarria.survey.entities.Survey;
import com.echavarria.survey.exceptions.EntityNotFoundException;
import com.echavarria.survey.exceptions.MissingRequiredDataException;
import com.echavarria.survey.repositories.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SurveyServices {

    private final SurveyRepository surveyRepository;

    public SurveyServices(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public void surveyValidator(Survey survey) {
        if (survey == null) throw new MissingRequiredDataException("Missing survey data");
        if (survey.getQuestions().size() == 0) throw new MissingRequiredDataException("Missing questions");
        if (survey.getEmailAddress() == null) throw new MissingRequiredDataException("Email required");
        if (!isAddressEmailValid(survey.getEmailAddress())) throw new MissingRequiredDataException("Invalid email");
    }

    public Boolean isAddressEmailValid(String addressEmail) {
        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(addressEmail);
        return matcher.matches();
    }

    public Survey saveSurvey(Survey survey) {
        surveyValidator(survey);
        return surveyRepository.save(survey);
    }

    public Survey retrieveSurveyById(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        if (survey.isEmpty()) throw new EntityNotFoundException("The requested survey has not been found.");
        return survey.get();
    }
}
