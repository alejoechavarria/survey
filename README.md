# Customer Satisfaction Survey
_This project is back-end of customer satisfaction survey RESTful Web Service._


## Starting 🚀

_With these instructions, you can obtain a copy of the project for your sandbox setup._


### Development Environment

_Project has developed on Github in Java language by using Intellij Idea Community._

### Pre-requirements 📋

* [JDK Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) - JDK de Java 11
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot version '2.6.1'
* [Maven](https://maven.apache.org/install.html) - maven-4.0.0

### Project Execution

* [http://localhost:8080/api](http://localhost:8080/) URL for postman
* [http://localhost:8080/h2-console](http://localhost:8080/h2-console) URL for db interface

### Services

#### Save a new satisfaction survey:
* **Path:** "api-host/survey"
* **Example body**:

```
{
	"username": "Alejandro E",
	"emailAddress": "alejo@gmail.com",
	"topic": "Satisfaction Survey",
	"questions": [
			{
				"description": "¿Cómo le parecio el servicio?",
				"type": "INPUT",
				"answer": "Excelente servicio"
			}
		]
	
}
```

#### Consult an existing survey:
* **Path:** "api-host/survey/{id}"
* **Example of response**:


```
{
    "id": 1,
    "username": "Alejandro E",
    "emailAddress": "alejo@gmail.com",
    "topic": "Satisfaction Survey",
    "questions": [
        {
            "id": 1,
            "description": "¿Cómo le parecio el servicio?",
            "type": "INPUT",
            "answer": "Excelente servicio"
        }
    ]
}

```


## Database Organization

_There are two tables named SURVEYS and QUESTIONS._

Survey fields:
* SURVEY_ID
* USERNAME
* EMAIL_ADDRESS
* TOPIC

Question fields:
* QUESTION_ID
* DESCRIPTION
* TYPE
* ANSWER
* FK_SURVEY_QUESTION

## Built with 🛠️

* [JDK Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) - JDK de Java 11
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot version '2.6.1'
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Spring Data JPA for Entity & Repository layers
* [Spring Web services](https://spring.io/projects/spring-ws) - for Service & Controller layers
* [H2 Database](https://www.h2database.com/html/main.html) Inmemory & embedded & portability & fast
* [Maven](https://maven.apache.org/install.html) - maven-4.0.0



## Author ✒️

* **Alejandro Echavarria** - *Initial Work* - [alejoechavarria](https://github.com/alejoechavarria)




---

