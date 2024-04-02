package com.platzi.javatests.movies.data;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;

//Este repositorio guardara las peliculas en la base de datos.
public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie>findAll();
    void saveOrUpdate(Movie movie);

}
