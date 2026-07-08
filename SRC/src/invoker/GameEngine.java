package invoker;

import command.Command;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private List<Command> historicoComandos = new ArrayList<>();

    public void executarComando(Command comando) {
        if (comando != null) {
            comando.execute();
            historicoComandos.add(comando);
        } else {
            System.out.println("Comando inválido ou não definido.");
        }
    }

    public List<Command> getHistorico() {
        return historicoComandos;
    }
}
