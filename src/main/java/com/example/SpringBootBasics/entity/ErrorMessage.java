package com.example.SpringBootBasics.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;

//    public ErrorMessage(){}
//
//    public ErrorMessage(HttpStatus status, String message){
//        this.status = status;
//        this.message = message;
//    }
//
//    public String getMessage(){
//        return this.message;
//    }
//
//    public void setMessage(String message){
//        this.message = message;
//    }
//
//    public void setStatus(HttpStatus status){
//        this.status = status;
//    }
//
//    public HttpStatus getStatus(){
//        return this.status;
//    }
//
//    @Override
//    public String toString() {
//        return "ErrorMessage{" +
//                "status=" + status +
//                ", message='" + message + '\'' +
//                '}';
//    }
}
