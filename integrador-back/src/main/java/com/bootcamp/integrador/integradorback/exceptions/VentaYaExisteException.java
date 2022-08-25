package com.bootcamp.integrador.integradorback.exceptions;

public class VentaYaExisteException extends Exception{
    public VentaYaExisteException() {
    }
    public VentaYaExisteException(String message) {
        super(message);
    }
}
