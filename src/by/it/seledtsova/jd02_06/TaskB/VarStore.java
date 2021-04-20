package by.it.seledtsova.jd02_06.TaskB;

import java.io.*;
import java.util.Map;

public class VarStore {
        private static final String VARS_NAME =
                FilePath.getFilePath("vars.txt", VarStore.class);

        public static void load() {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(VARS_NAME))                 )
            {
                Parser parser = new Parser();
                String line;
                while ((line = reader.readLine()) != null) {
                    parser.calc(line);
                }
            } catch (CaltExeption | IOException e) {
              }
        }


            public static void save(Map<String, Var> vars) throws CaltExeption {
            try (
                    PrintWriter out = new PrintWriter(VARS_NAME)) {
                for (Map.Entry<String, Var>  varPair : vars.entrySet()) {
                //   printWriter.printf("%s=%s\n", nameValue.getKey(), nameValue.getValue());
                    out.println(varPair.getValue()+" "+varPair.getValue());
                }
            } catch (FileNotFoundException e) {
                throw new CaltExeption("сохранение не удалось", e);
            }

        }
    }

