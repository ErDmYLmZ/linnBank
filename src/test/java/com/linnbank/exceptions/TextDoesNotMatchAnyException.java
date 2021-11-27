package com.linnbank.exceptions;

public class TextDoesNotMatchAnyException extends Exception{
    public TextDoesNotMatchAnyException(String msg){
        super(msg);
    }
}
