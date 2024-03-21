package ru.fcpsr.yandexballoonproject.config;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.fcpsr.yandexballoonproject.components.DataBase;
import ru.fcpsr.yandexballoonproject.models.School;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Configuration
public class Application {
    @Bean
    public CommandLineRunner dataLoader(DataBase dataBase){
        return args -> {
            parse(dataBase);
        };
    }

    private void parse(DataBase dataBase){
        System.out.println("start process");

        XSSFWorkbook wb = getWorkBookFromXSSF("./src/main/resources/static/exel/coord.xlsx");
        XSSFSheet sheet = wb.getSheet("Лист1");
        Iterator<Row> rowIter = sheet.rowIterator();
        int index = 0;
        while (rowIter.hasNext()){
            Row row = rowIter.next();
            Cell name = row.getCell(2);
            Cell coords = row.getCell(10);

            if(name != null && coords != null) {
                School school = new School();
                school.setId(index);
                school.setName(name.toString());
                school.setCoords(coords.toString());
                school.setSD();

                dataBase.addSchool(school);

                index++;
            }
        }

        System.out.println("end process");

        try {
            wb.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private XSSFWorkbook getWorkBookFromXSSF(String filePath){
        try{
            return new XSSFWorkbook(new FileInputStream(filePath));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
