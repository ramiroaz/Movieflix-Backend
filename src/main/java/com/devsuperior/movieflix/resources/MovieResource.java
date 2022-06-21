package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.NewMovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
//	@GetMapping
//	public ResponseEntity<List<NewMovieDTO>> findAll() {
//		List<NewMovieDTO> list = service.findAll();		
//		return ResponseEntity.ok().body(list);
//	}
	
	@GetMapping
	public ResponseEntity<Page<NewMovieDTO>> findByGenre(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable) {
		
		Page<NewMovieDTO> list = service.findByGenre(genreId, pageable);
		return ResponseEntity.ok(list);
	}
	
//	@GetMapping
//	public ResponseEntity<List<NewMovieReviewDTO>> findMovieReview() {
//		List<NewMovieReviewDTO> list = service.findById(null);
//		return ResponseEntity.ok().body(list);
//	}
	
//	@GetMapping
//	public ResponseEntity<List<NewMovieReviewDTO>> findMovieReviews() {
//		List<NewMovieReviewDTO> list = service.findAllPaged(null);@GetMapping
//		public ResponseEntity<List<NewMovieReviewDTO>> findByGenre() {
//			List<NewMovieDTO> list = service.findByGenre();	
//			return ResponseEntity.ok().body(list);
//		}
//		return ResponseEntity.ok().body(list);
//	}
	
	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
}