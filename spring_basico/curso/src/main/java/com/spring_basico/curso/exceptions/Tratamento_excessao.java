package com.spring_basico.curso.exceptions;

// Esta classe é uma exceção personalizada que estende RuntimeException. Ela é usada para lançar mensagens de erro específicas quando um produto não é encontrado ou quando ocorre algum problema relacionado aos produtos.

public class Tratamento_excessao extends RuntimeException {
    public Tratamento_excessao(String message) {
        super(message);
    }

}
