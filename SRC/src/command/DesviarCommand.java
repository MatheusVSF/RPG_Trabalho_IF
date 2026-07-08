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
        int valorDesvio = random.nextInt(4) + 2; 
        player.estaDesviando = true;
        player.valorDesvioSorteado = valorDesvio;
        System.out.println("Esforço/Valor de desvio sorteado: " + valorDesvio);
        player.desviar();
    }
}
