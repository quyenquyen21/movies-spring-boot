package dev.tuongquyendao.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity <List<Movie>> getAllMovies(){
        return new  ResponseEntity <List<Movie>>(movieService.allMovies(), HttpStatus.OK);

    }
    @GetMapping("/{imdbId}")
    public ResponseEntity <Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new  ResponseEntity <Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }
}
