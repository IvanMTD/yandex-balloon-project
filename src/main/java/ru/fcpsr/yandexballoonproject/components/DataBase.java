package ru.fcpsr.yandexballoonproject.components;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fcpsr.yandexballoonproject.models.School;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class DataBase {
    private List<School> schools = new ArrayList<>();

    public void addSchool(School school){
        schools.add(school);
    }
}
