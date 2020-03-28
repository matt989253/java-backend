package ch.heigvd.pro.b04.endpoints;

import ch.heigvd.pro.b04.questions.Question;
import ch.heigvd.pro.b04.questions.QuestionIdentifier;
import ch.heigvd.pro.b04.questions.QuestionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

  @Autowired
  private QuestionRepository repository;

  public QuestionController(QuestionRepository repo) {
    repository = repo;
  }

  @RequestMapping(value = "/question", method = RequestMethod.GET)
  List<Question> all() {
    return repository.findAll();
  }

  @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
  Question byId(@PathVariable QuestionIdentifier id) {
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found."));
  }
}
