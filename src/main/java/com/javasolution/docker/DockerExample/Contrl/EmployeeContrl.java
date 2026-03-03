package com.javasolution.docker.DockerExample.Contrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeContrl {

    @Value("${app.file.path}")
    private  String filePath;

@PostMapping("addName")
 public  String addEmployeeName(@RequestBody String name){
    File file = new File(filePath);

    // create directory if not exists
    file.getParentFile().mkdirs();

    try (FileWriter fw = new FileWriter(file, true)) {
        fw.write(name + System.lineSeparator());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    return "Name saved successfully";

}
    @GetMapping("getNames")
    public  List<String> getNames() throws IOException {
        Path path=Paths.get(filePath);
       // String data=Files.readString(path);
        return Files.readAllLines(path);
    }

    @PostMapping("deleteName")
    public  String deleteName(@RequestBody String empName) throws IOException {
        Path path=Paths.get(filePath);
        List<String> updatedNames =
                Files.readAllLines(path).stream().map(String::trim).filter(n -> !n.equalsIgnoreCase(empName.trim()))
                .toList();
        Files.write(path, updatedNames,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE);
        return "Name removed successfully";

    }
}
