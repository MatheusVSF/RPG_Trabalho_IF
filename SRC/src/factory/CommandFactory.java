package factory;

import command.*;
import receiver.Player;
import model.Inimigo;

public class CommandFactory {
    private Player player;
    private Inimigo inimigo;

    public CommandFactory(Player player, Inimigo inimigo) {
        this.player = player;
        this.inimigo = inimigo;
    }

    public Command obterComando(String tipoAction) {
        switch (tipoAction.toLowerCase()) {
            case "atacar":
                return new AtacarCommand(player, inimigo);
            case "defender":
                return new DefenderCommand(player);
            case "desviar":
                return new DesviarCommand(player);
            case "curar":
                return new CurarCommand(player);
            default:
                return null;
        }
    }
}
    