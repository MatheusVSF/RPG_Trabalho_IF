package command;

import receiver.Player;
import model.Inimigo;

public class AtacarCommand implements Command {
    private Player player;
    private Inimigo inimigo;

    public AtacarCommand(Player player, Inimigo inimigo) {
        this.player = player;
        this.inimigo = inimigo;
    }

    @Override
    public void execute() {
        player.atacar();
        int danoFinal = Math.max(1, player.atk - inimigo.status.def);
        inimigo.receberDano(danoFinal);
        System.out.println("Dano aplicado ao inimigo: " + danoFinal + " | HP do inimigo restante: " + inimigo.status.hp);
    }
}
