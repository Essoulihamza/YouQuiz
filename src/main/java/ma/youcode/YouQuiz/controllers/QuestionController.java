package ma.youcode.YouQuiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.controllers.super_classes.Controller;
import ma.youcode.YouQuiz.models.dto.QuestionDto;

@AllArgsConstructor
@RestController
@RequestMapping("/questions")
public class QuestionController extends Controller<QuestionDto, Long> {}
