package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;
    @Before
    public void setUp() throws Exception{
        //como el repositorio es una interface entonces no nos importa la simulamos con mockito, va buscar las peliculas en el repositorio
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        //que pelicula devuelve el repositorio o en este caso el mock que simulamos, con el repositorio cuando te llame al metodo findall tu retornas estas peliculas
        Mockito.when(movieRepository.findAll()).thenReturn(
                //forzamos el arrays.aslist
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        //obteniendo los id: con stream nos permite manipular la coleccion de peliculas los cuales vamos a mapear cada pelicula a su id; y luego esto lo recolecto en una lista
        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        //si estoy pidiendo las peliculas de comedia obtendriamos la pelicula ID=3 Y ID=6, en este caso movies es la coleccion de peliculas y debemos obtener el id
        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3,6)));
    }



}