package com.vims.rs.exception;
import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class FieldsAreMandatoryException extends RuntimeException implements Serializable
{
       private static final long serialVersionUID = -9079599545356989460L;
       public FieldsAreMandatoryException(String s){
              super(s+"must not be empty");
       }
}
