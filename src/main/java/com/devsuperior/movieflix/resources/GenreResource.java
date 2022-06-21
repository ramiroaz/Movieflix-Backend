package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
	
	@Autowired
	private GenreService service;
	
//	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
//	@GetMapping
//	public ResponseEntity<Page<GenreDTO>> findAll(Pageable pageable) {
//		Page<GenreDTO> page = service.findAllPaged(pageable);
//		return ResponseEntity.ok().body(page);
//	}
	
	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	@GetMapping
	public ResponseEntity<List<GenreDTO>> findAll() {
		List<GenreDTO> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
//	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
//	@GetMapping
//	public ResponseEntity<GenreDTO> findAll( @RequestBody GenreDTO dto) {
//		dto = service.findAllPaged(dto);      
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//		        .buildAndExpand(dto.getId()).toUri();
//		return ResponseEntity.created(uri).body(dto);
//	}
	
	
//	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
//	@GetMapping
//	public ResponseEntity<Page<GenreDTO>> findAll(
//	          	@RequestParam(value = "id", defaultValue = "") Long id,
//	          	@RequestParam(value = "name", defaultValue = "") String name,
//	          	Pageable pageable) {
//	   	
//	   	Page<GenreDTO> list = service.findAllPaged(pageable);         	
//	   	return ResponseEntity.ok().body(list);
//	}
	
	
	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<GenreDTO> findById(@PathVariable Long id) {
		GenreDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}