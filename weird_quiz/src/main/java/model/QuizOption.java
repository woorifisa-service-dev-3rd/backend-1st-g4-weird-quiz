package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizOption {

	private int id;
	
	private String content;
	
	private boolean isAnswer;
	
	private String weirdAnswerMessage;
}
