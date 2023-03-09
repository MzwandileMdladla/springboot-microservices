package za.co.jengo.springbbootrestapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int id;
    private String firstname;
    private String lastname;
}
