package fakeapi.languages.global;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public class ResponseEntityBuilder{
    private ResponseEntityBuilder(){}
    public static <T> ResponseEntity<T> build(T response) {
        if(Objects.nonNull(response)){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.noContent().build();
    }
    public static <T> ResponseEntity<List<T>> buildList(List<T> responseList) {
        if(!responseList.isEmpty()){
            return ResponseEntity.ok(responseList);
        }
        return ResponseEntity.noContent().build();
    }
}
