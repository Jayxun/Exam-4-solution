package uz.pdp.online.WebLogAnalyzer;

import uz.pdp.online.WebLogAnalyzer.dto.DTO;
import uz.pdp.online.WebLogAnalyzer.service.InputService;
import uz.pdp.online.WebLogAnalyzer.service.OutputService;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        /**
        DTO - Data Transfer Object
        bu malumotlarni bir joydan ikkinchi joyga bitta o'ram qilib ko'chirishga yordam beradi
        */
        DTO dto = InputService.getResult();

        OutputService.run(dto);

        System.out.println("Dastur yakunlandi. \n" +
                "Biroz qo'shimcha qo'shardim ammo vaqt cheklangan ekan." +
                "\n Hurmat ila Jayxunbey");



    }


}
