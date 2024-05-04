package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        //1. nos estamos conectando a la base de datos que esta en memoria.
        //consiguiendo la coneccion a base de datos; en este caso la url dada esta creando una base de datos en memoria con formato MYSQL
         dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        //2. estoy ejecutando un Script para crear la tabla de peliculas e introducir tres peliculas de ejemplo
        //vamos a cargar el script de la base de datos y que carga las peliculas. ClassPathResource es la ruta donde esta nuestro archivo sql
        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scrips/test-dat.sql"));

        //3. Estoy creando el jdbctemplate que necesita mi repositorio para conectarse a la base de datos.
        //conseguimos el jdbctemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //creamos el repositorio que hemos definido
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    //vamos a probar que podemos cargar todas las peliculas
    @Test
    public void load_all_movies(){
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

    @Test //probamos que en este test cargamos cada pelicula por id
    public void load_movie_by_id() {

        Movie movie = movieRepository.findById(2);

        assertThat(movie, is( new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test //test para insertar una pelicula.
    public void insert_a_movie() {
        //creamos una nueva pelicula.
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

        //en mi repositorio quiero llamar al metodo de guardar una pelicula
        movieRepository.saveOrUpdate(movie);

        //recuperando la pelicula por medio del id;
        Movie movieFromDb = movieRepository.findById(4);

        //al crear la pelicula sin ID, debemos comprobar con el ID ya que este lo introduce la base de Datos y para comprobarla se requiere el ID
        assertThat(movieFromDb, is(new Movie(4,"Super 8", 112, Genre.THRILLER)));
    }

    @Test
    public void load_movie_by_name(){
        Collection <Movie> movieSearch = movieRepository.findByName("Dark Knight");
        assertThat(movieSearch, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION))));
    }

    @Test
    public void load_movie_by_name_SQL_method(){
        Collection <Movie> movies = movieRepository.findByNameSQLMethod("dark");
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                new Movie(2, "Memento", 113, Genre.THRILLER) ,
                new Movie(3, "Matrix", 136, Genre.ACTION))));
    }

    @After //se ejecuta despues de cada test esto lo que hace es borrar los datos una vez se ejecute cada test
    public void tearDown() throws Exception {
        //Remove h2 files --https//stackoverflow.com/a/51809831/1121497
        final Statement s = dataSource.getConnection().createStatement();
        //SENTENCIA QUE ME BORRA LOS DATOS DE LA DB
        s.execute("drop all objects delete files"); //"shutdown" is also enough for mem db
    }
}