package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {
    //creamos una funcion que muestre el manual cuando la propiedad isHelp este presente
    static void showHelp(CLIArguments cliArguments){
        //definimos internamente un consumer que es una interface que trabaja sobre un tipo de dato, consume los datos
        Consumer <CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()){
                System.out.println("manual solicitado");
            }
        };

        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI(){
        //funcion que se encarga de generar datos -> proveer datos.
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        return generator.get();
    }
}
