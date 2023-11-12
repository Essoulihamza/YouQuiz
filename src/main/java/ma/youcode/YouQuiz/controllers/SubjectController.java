package ma.youcode.YouQuiz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.youcode.YouQuiz.models.dto.SubjectDto;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController extends Controller<SubjectDto, Long> {}
