package dev.service.cloud.service;

import java.util.List;

import dev.service.cloud.model.Quiz;
import dev.service.cloud.model.QuizOption;
import dev.service.cloud.repository.QuizRepository;

public class QuizService {
	private final QuizRepository quizRepository;
	
	public QuizService() {
		quizRepository = new QuizRepository();
	}


	public List<Quiz> selectQuizzes() {
		// 랜덤으로 퀴즈 10개 가져오기
		return quizRepository.findTop10OrderByRandom();
	}
	

	public boolean isCorrectAnswer(Quiz quiz, int userAnswer) {
		boolean ret;
		
		List<QuizOption> options = quiz.getOptions();
		if(quiz.isWeird()) { // 이상한 문제인 경우
			if(options.get(userAnswer - 1).isAnswer()) ret = false;
			else ret = true;
		} else { // 정상적인 문제인 경우
			if(options.get(userAnswer - 1).isAnswer()) ret = true;
			else ret = false;
		}
		
		return ret;
	}

}
