package by.it.khrolovich.calc;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class VarRepository {
    //в него записываем, из него читаем
    static final String varsFileName = FileNameHelper.getFilePath("varx.txt",VarRepository.class);

    static void save(Map<String, Var> vars) throws CalcException {
        try(PrintWriter out = new PrintWriter(varsFileName)){
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n",pair.getKey(),pair.getValue());
                        //можно сделать сложнее, чтобы не перезаписывать
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new CalcException("no save",e);
        }
    }
    static void load(){
        //if(//TODO
        try{
            Parser parser= new Parser();
            //Files.lines(Paths.get(varsFileName)).forEach(line->parser.evaluate(line));
            Files.lines(Paths.get(varsFileName)).forEach(line-> {
                try {
                    parser.evaluate(line);
                } catch (CalcException e) {
                    e.printStackTrace();
                }
            });
            //минус выражения: как только исключение, То появлятся
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static void save(String key, Var value) {
    }
}
