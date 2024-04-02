package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

//la clase de negocio
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection <Movie> findMoviesByGenre(Genre genre) {
        //si voy a buscar peliculas, se ira al repositorio y las buscara con el metodo findall ubicado en el repositorio que devuelve una coleccion de peliculas
        //en este caso vamos a filtrarlos con stream podemos usar la funcion filter que nos devuelva las peliculas que tenga el genero al que estoy pidiendo y lo devuelvo en una lista
        return movieRepository.findAll()
                .stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }


    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll()
                .stream().filter(movie -> movie.getMinutes() <= 119).collect(Collectors.toList());
    }
}
