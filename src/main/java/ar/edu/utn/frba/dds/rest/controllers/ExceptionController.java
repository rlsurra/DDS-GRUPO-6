package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.exceptions.EntidadNoEncontradaException;
import ar.edu.utn.frba.dds.exceptions.GuardarropaUsuarioException;
import ar.edu.utn.frba.dds.exceptions.NoSePuedePuntearUnAtuendoNoSeleccionadoException;
import ar.edu.utn.frba.dds.exceptions.ParametrosInvalidosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    public class ApiError {
        private HttpStatus status;
        private String error;

        public ApiError(HttpStatus status, String error) {
            this.status = status;
            this.error = error;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    @ExceptionHandler(value = EntidadNoEncontradaException.class)
    public ResponseEntity<Object> entidadNoEncontradaException(EntidadNoEncontradaException exception) {
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            GuardarropaUsuarioException.class,
            ParametrosInvalidosException.class,
            NoSePuedePuntearUnAtuendoNoSeleccionadoException.class
    })
    public ResponseEntity<Object> badRequestException(Exception exception) {
        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
