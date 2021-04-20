package by.it.khrolovich.calc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class VarRepository {
    //в него записываем, из него читаем
    static final String varsFileName = FileNameHelper.getFilePath("varx.txt", VarRepository.class);

    static void save(Map<String, Var> vars) throws CalcException {
        try (PrintWriter out = new PrintWriter(varsFileName)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n", pair.getKey(), pair.getValue());
                //можно сделать сложнее, чтобы не перезаписывать
                Logger.get().log(Language.INSTANCE.get(Message.SAVE_TO_FILE)+" "+pair.getKey()+"="+pair.getValue());
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
           throw new CalcException(Language.INSTANCE.get(Message.NO_SAVE), e);
        }
    }

    static void load() {
        try {
            Parser parser = new Parser();
            //Files.lines(Paths.get(varsFileName)).forEach(line->parser.evaluate(line));
            Files.lines(Paths.get(varsFileName)).forEach(line -> {
                try {
                    parser.evaluate(line);
                } catch (CalcException e) {
                    e.printStackTrace();
                    Logger.get().log(e.getMessage());
                }
            });
        } catch (IOException e) {
            Logger.get().log(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void save(String key, Var value) {
    }
}
