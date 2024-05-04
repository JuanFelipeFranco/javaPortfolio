package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate; //campo privado para el repositorio
    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        //los argumentos por la interfaz de jdbctemplate deben ser una array de objetos donde indica el valor necesario en este caso id
        Object [] args = {id};

        //utilizamos forObject ya que este solo devuelve un elemento un id en este caso. el ? es el parametro que vamos a colocar en los argumentos
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        //usaremos jdbctemplate para buscar todas las peliculas y con movieMapper es donde indicamos como transformamos cada fila de la base de datos en un objeto pelicula
        return jdbcTemplate.query("select * from movies",movieMapper); //en este caso hacemos la consulta a la base de datos por el query y transformando cada pelicula en un objeto movie
    }

    //los querys sirven para obtener datos.
    @Override
    public void saveOrUpdate(Movie movie) {
        //este metodo sirve para hacer actualizaciones en la base de datos.
        jdbcTemplate.update("insert into movies (name, minutes, genre) VALUES (?,?,?)",
                movie.getName(),movie.getMinutes(),movie.getGenre().toString());
    }

    @Override
    public Collection<Movie> findByName(String name){
        return findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByNameSQLMethod(String name){

        name = name.toLowerCase();
        return jdbcTemplate.query("SELECT * FROM MOVIES WHERE LOWER(name) LIKE '%" + name + "%'", movieMapper);
    }

    //usaremos un rowmapper de movie
    private static RowMapper <Movie> movieMapper = new RowMapper<Movie>() {
        // atraves del objeto rs que representa la fila actual de la base de datos,
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            //creamos una nueva pelicula,dandole los datos que necesita para ello(id,nombre,minutes,genero) que lo obtendremos de la base de datos.
            return new Movie(
                    //para obtener cada uno usamos el rs y teniendo en cuenta el tipo de dato que devuelve
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    //de la base de datos se obtiene un string pero como el tipo de datos es genre transforma el string en obejto genre
                    Genre.valueOf(rs.getString("genre")));
        }
    };
}
