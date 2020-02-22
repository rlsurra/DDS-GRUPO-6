package ar.edu.utn.frba.dds.rest.controllers;

import ar.edu.utn.frba.dds.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    public class ApiError {
        private Integer code;
        private HttpStatus status;
        private String error;

        public ApiError(Integer code, HttpStatus status, String error) {
            this.code = code;
            this.status = status;
            this.error = error;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
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
        Integer code = HttpStatus.NOT_FOUND.value();
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ApiError(code, status, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            GuardarropaUsuarioException.class,
            ParametrosInvalidosException.class,
            NoSePuedePuntearUnAtuendoNoSeleccionadoException.class,
            MaximaCantidadPrendasException.class
    })
    public ResponseEntity<Object> badRequestException(Exception exception) {
        Integer code = HttpStatus.BAD_REQUEST.value();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ApiError(code, status, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            NoSePudoConectarConNingunaApiDeClima.class
    })
    public ResponseEntity<Object> apiClimaException(Exception exception) {
        Integer code = HttpStatus.SERVICE_UNAVAILABLE.value();
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(new ApiError(code, status, exception.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = UserNotLoggedException.class)
    public ResponseEntity<Object> usuarioNoLogueadoException(UserNotLoggedException exception) {
        Integer code = HttpStatus.UNAUTHORIZED.value();
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(new ApiError(code, status, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}
