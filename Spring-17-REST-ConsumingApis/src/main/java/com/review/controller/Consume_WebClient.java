package com.review.controller;

import com.review.entity.Genre;
import com.review.entity.MovieCinema;
import com.review.repository.GenreRepository;
import com.review.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient
{
    /**
        We're consuming with Webclient, basically it's a builder
        I'm consuming my own API with WebClient
     */
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    /**
     * This is more than one MovieCiname and instead of using List' used Flux
     */
    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux(){

        return Flux.fromIterable(movieCinemaRepository.findAll());

    }


    /**
     * This is only return one MovieCiname so we're using Mono
     */
//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
//
//         return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    /**
     *  ResponseEntity passing with Header
     */
    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readById(@PathVariable("id") Long id){

        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));

    }

    /**
     *  Request Body
     */
    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){

        Genre createdGenre = genreRepository.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    /**
     * If we don't return anything, using void
     * We don't have body so we use Mono.empty()
     */

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){

        genreRepository.deleteById(id);

        return Mono.empty();
    }

// ========================================Web Client ========================================================

    /**
     *Consume with WEB CLIENT as REACT WAY
     * Passing with Header
     */
    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){

        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);

    }

    /**
     *
     */
    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){

        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);

    }



}
