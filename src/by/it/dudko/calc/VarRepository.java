package by.it.dudko.calc;

import java.io.*;
import java.util.Map;

public class VarRepository {

    private static final String VARS_FILE_NAME =
            FileNameHelper.getFullPath(Config.VAR_REPO_FILE_NAME, VarRepository.class);

    public static void load() {
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(VARS_FILE_NAME)
                )
        ) {
            Parser parser = new Parser(new VarCreator());
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parser.evaluate(line);
            }
        } catch (IOException | CalcException e) {
            // stub
        }
    }

    public static void save(Map<String, Var> vars) throws CalcException {
        try (
                PrintWriter printWriter = new PrintWriter(VARS_FILE_NAME)
        ){
            for (Map.Entry<String, Var> nameValue : vars.entrySet()) {
                printWriter.printf("%s=%s\n", nameValue.getKey(), nameValue.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(Language.INSTANCE.get(Messages.REPO_SAVE_FAILED), e);
        }

    }
}
