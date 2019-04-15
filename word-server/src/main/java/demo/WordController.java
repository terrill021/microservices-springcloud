package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.domain.Word;

@Controller
@RefreshScope
public class WordController {

	@Value("${words}") String words;
	@Value("${lucky-world}") String luckyWord;

	// @Value("${eureka.instance.instanceId}") String instanceId;
	
	@GetMapping("/")
	public @ResponseBody Word getWord() {
		String[] wordArray = words.split(",");
		int i = (int)Math.round(Math.random() * (wordArray.length - 1));
		return new Word(wordArray[i]); // + instanceId;
	}

	@Value("${spring.application.name}") private String appName;
	@GetMapping("/name")
	public @ResponseBody String getName() {
		return appName;
	}

	@Value("${spring.profiles}") private String profiles;
	@GetMapping("/profiles")
	public @ResponseBody String profiles() {
		return profiles;
	}
	
	@GetMapping("/lucky-word")
	public @ResponseBody String luckyWord() {
		return luckyWord;
	}
}
