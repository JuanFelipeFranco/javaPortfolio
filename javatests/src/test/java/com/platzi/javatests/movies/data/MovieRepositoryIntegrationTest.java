package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    //vamos a probar que podemos cargar todas las peliculas
    @Test
    public void load_all_movies() throws SQLException {
        //1. nos estamos conectando a la base de datos que esta en memoria.
        //consiguiendo la coneccion a base de datos; en este caso la url dada esta creando una base de datos en memoria con formato MYSQL
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        //2. estoy ejecutando un Script para crear la tabla de peliculas e introducir tres peliculas de ejemplo
        //vamos a cargar el script de la base de datos y que carga las peliculas. ClassPathResource es la ruta donde esta nuestro archivo sql
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scrips/test-dat.sql"));

        //3. Estoy creando el jdbctemplate que necesita mi repositorio para conectarse a la base de datos.
        //conseguimos el jdbctemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //creamos el repositorio que hemos definido
        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        //4 Recupero las peliculas en una coleccion
        Collection<Movie> movies = movieRepository.findAll();

        //5 compruebo que las peliculas obtenidas son las correctas a las que tengo en la base de datos creadas en el archivo sql
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                new Movie(2, "Memento", 113, Genre.THRILLER) ,
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));

        //6.se debe crear el metodo equals para comparar objetos correctamente se implementa en movie
    }

}