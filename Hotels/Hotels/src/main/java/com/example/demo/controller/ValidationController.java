package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/validation_schema") //endpoint validation schema
public class ValidationController {

    @GetMapping //получаем тип комнаты, а получаем схему
    public ResponseEntity<String> getValidationSchema(@PathVariable String roomType) {
        String validationSchema = getValidationSchemaByRoomType(roomType);

        if (validationSchema != null) {
            return ResponseEntity.ok(validationSchema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getValidationSchemaByRoomType(String roomType) {
        String res = ""; //все пораметры, записанные в виде джейсона
        res = "{" +
                "\"properties\": {" +
                "\"id\": {\"type\": \"integer\"}," +
                "\"dateStart\": {\"type\": \"string\", \"format\": \"date-time\"}," +
                "\"DateEnd\": {\"type\": \"string\", \"format\": \"date-time\"}," +
                "\"NumberRoom\": {\"type\": \"number\"}," +
                "\"NameClient\": {\"type\": \"string\"}," +
                "\"Needs\": {\"type\": \"string\"}," +
                "\"Status\": {\"type\": \"integer\"}" +
                "}," +
                "\"required\": [\"dateStart\", \"DateEnd\", \"NumberRoom\", \"NameClient\", \"Needs\", \"Status\"]" +
                "}";
        return res;
    }
}
