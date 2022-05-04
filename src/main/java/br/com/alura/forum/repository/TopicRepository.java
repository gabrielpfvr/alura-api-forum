package br.com.alura.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	Page<Topic> findByCourseName(String courseName, Pageable pagination);
	
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome = : nomeCurso")
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

}