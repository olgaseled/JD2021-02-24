package by.it.levchuk.levchuk.jd02_04;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class VarRepository {

    private static final String VARS_FILE =
            FileNameHelper.getFilePath("vars.txt", VarRepository.class);

    public static void save(Map<String, Var> vars) throws CalcException {
        try (PrintWriter out = new PrintWriter(VARS_FILE)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException("no save", e);
        }
    }

    static void loading() {
        if (new File(VARS_FILE).exists())
            try {
                Parser parser = new Parser();
                Files.lines(Paths.get(VARS_FILE))
                        .forEach(line -> {
                            try {
                                parser.analyze(line);
                            } catch (CalcException e) {
                            }
                        });
            } catch (IOException e) {
            }
    }
}
