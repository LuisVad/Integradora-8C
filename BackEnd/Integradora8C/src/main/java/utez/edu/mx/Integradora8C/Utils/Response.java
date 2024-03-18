package utez.edu.mx.Integradora8C.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response <T>{
    private T data;
    private boolean error;
    private int status;
    private String message;
}
