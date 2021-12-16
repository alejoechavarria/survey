package com.echavarria.survey.services;

import com.echavarria.survey.entities.Question;
import com.echavarria.survey.entities.QuestionType;
import com.echavarria.survey.entities.Survey;
import com.echavarria.survey.exceptions.EntityNotFoundException;
import com.echavarria.survey.exceptions.MissingRequiredDataException;
import com.echavarria.survey.repositories.SurveyRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SurveyServicesTest {

    private SurveyRepository repository;
    private SurveyServices services;

    @Before
    public void setup() {
        //Arrange
        repository = mock(SurveyRepository.class);
        services = new SurveyServices(repository);
    }

    @Test
    public void email_is_invalid() {
        //Act
        boolean email = services.isAddressEmailValid("__.--@gmail.com");

        //Assert
        assertEquals(false, email);
    }

    @Test
    public void email_is_correct() {
        //Act
        boolean email = services.isAddressEmailValid("camilo.perez@outlook.com");

        //Assert
        assertEquals(true, email);
    }

    @Test
    public void surveyValidator_throw_exception_when_email_is_null() {
        //Arrange
        Question aboutService = new Question(null, "How did you find the service?", QuestionType.INPUT,
                "It's ok");
        List<Question> questions = List.of(aboutService);
        Survey survey = new Survey(null, "Test", null, "Test Topic", questions);
        try {
            //Act
            services.surveyValidator(survey);
        } catch (MissingRequiredDataException e) {
            //Assert
            assertEquals("Email required", e.getMessage());
        }
    }

    @Test
    public void surveyValidator_throw_exception_when_question_list_is_empty() {
        //Arrange
        List<Question> questions = Collections.emptyList();
        Survey survey = new Survey(null, "Test", "test@gmail.com", "Test Topic", questions);
        try {
            //Act
            services.surveyValidator(survey);
        } catch (MissingRequiredDataException e) {
            //Assert
            assertEquals("Missing questions", e.getMessage());
        }
    }

    @Test
    public void surveyValidator_throw_exception_when_email_is_invalid() {
        //Arrange
        Question aboutService = new Question(null, "How did you find the service?", QuestionType.INPUT,
                "It's ok");
        List<Question> questions = List.of(aboutService);
        Survey survey = new Survey(null, "Test", "__.__@gmail.com", "Test Topic", questions);
        try {
            //Act
            services.surveyValidator(survey);
        } catch (MissingRequiredDataException e) {
            //Assert
            assertEquals("Invalid email", e.getMessage());
        }
    }

    @Test
    public void saveSurvey_is_correct() {
        //Arrange
        Question aboutService = new Question(1L, "How did you find the service?", QuestionType.INPUT,
                "It's ok");
        List<Question> questions = List.of(aboutService);
        Survey surveyFromDB = new Survey(1L, "Test", "emailtest@outlook.com", "Test Topic",
                questions);
        when(repository.save(any(Survey.class))).thenReturn(surveyFromDB);

        Survey survey = new Survey(null, "Test", "emailtest@outlook.com", "Test Topic",
                questions);

        //Act
        Survey surveySaved = services.saveSurvey(survey);

        //Assert
        assertEquals(surveyFromDB.toString(), surveySaved.toString());
        verify(repository).save(any(Survey.class));
    }

    @Test
    public void saveSurvey_throw_found_exception() {
        //Arrange
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        try {
            //Act
            services.retrieveSurveyById(1L);
        } catch (EntityNotFoundException e) {
            //Assert
            assertEquals("The requested survey has not been found.", e.getMessage());
        }
    }

    @Test
    public void retrieve_survey_by_id_is_correct() {
        //Arrange
        Question aboutService = new Question(1L, "How did you find the service?", QuestionType.INPUT,
                "It's ok");
        List<Question> questions = List.of(aboutService);
        Survey surveyFromDB = new Survey(1L, "Test", "emailtest@outlook.com", "Test Topic",
                questions);
        when(repository.findById(anyLong())).thenReturn(Optional.of(surveyFromDB));

        //Act
        Survey surveyQuery = services.retrieveSurveyById(1L);

        //Assert
        assertEquals(surveyFromDB, surveyQuery);
        verify(repository).findById(anyLong());
    }
}