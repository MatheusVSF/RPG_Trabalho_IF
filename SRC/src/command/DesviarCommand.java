package command;

import receiver.Player;
import java.util.Random;

public class DesviarCommand implements Command {
    private Player player;
    private Random random = new Random();

    public DesviarCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        int valorDesvio = random.nextInt(4) + 2; // Sorteia entre 2 e 5 (inclusive)
        System.out.println("Esforço/Valor de desvio sorteado: " + valorDesvio);
        player.desviar();
    }
}
