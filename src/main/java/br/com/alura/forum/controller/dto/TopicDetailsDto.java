package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.TopicStatus;
import br.com.alura.forum.model.Topic;

public class TopicDetailsDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;
	private String authorName;
	private TopicStatus status;
	private List<AnswerDto> answers;

	public TopicDetailsDto(Topic topic) {
		this.id = topic.getId();
		this.title = topic.getTitle();
		this.message = topic.getMessage();
		this.creationDate = topic.getCreationDate();
		this.authorName = topic.getAuthor().getName();
		this.status = topic.getStatus();
		this.answers = new ArrayList<>();
		this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

}
