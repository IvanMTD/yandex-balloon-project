package ru.fcpsr.yandexballoonproject.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class School {
    private int id;
    private String name;
    private String coords;
    private float s;
    private float d;

    public void setSD(){
        String parts[] = coords.split(", ");
        s = Float.parseFloat(parts[0]);
        d = Float.parseFloat(parts[1]);
    }
}
