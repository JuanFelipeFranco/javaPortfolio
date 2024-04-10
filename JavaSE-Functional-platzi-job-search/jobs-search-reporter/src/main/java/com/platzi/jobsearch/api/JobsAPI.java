package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Esta interfaz sera usada por Feign para hacer las peticiones a la API de gi thub.
 */

//CREANDO EL METODO QUE NOS DEVUELVE EL LISTADO DE TRABAJOS DISPONIBLES
@Headers("Accept: application/json") //anotacion dentro de la libreria feign con la que puedo indicar las cabecera que se envian atraves de la peticion
public interface JobsAPI {
    @RequestLine("GET /positions.json") //LE DECIMOS A FEIGN COMO HACER LA PETICION
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap); //QUERYMAP hace un mapa delos elementos que van dentro de la peticion

    @RequestLine("GET /positions/{id}.json")
    JobPosition job(@Param("id") String id);
}
