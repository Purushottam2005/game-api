package com.firstProject.repositories;

import com.firstProject.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 9:47 AM
 */
@RestResource(path = "game", rel = "game")
public interface GameRepository extends JpaRepository<Game, Long> {
	Page<Game> findByPrice(@Param("price") Float price, Pageable pageable);

	Page<Game> findByYear(@Param("year") Integer price, Pageable pageable);

	Game findByNameIgnoreCase(@Param("name") String name);

	@Query("DELETE from Game g where upper(g.name) like upper(:name)")
	@Modifying
	@Transactional
	void deleteByName(@Param("name") String name);
}
