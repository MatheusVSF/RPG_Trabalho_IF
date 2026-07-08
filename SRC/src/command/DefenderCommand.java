package command;

import receiver.Player;
import java.util.Random;

public class DefenderCommand implements Command {
    private Player player;
    private Random random = new Random();

    public DefenderCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        int valorDef = random.nextInt(4) + 2; 
        player.estaDefendendo = true;
        player.def += valorDef;
        System.out.println("Aumento de defesa sorteado: " + valorDef);
        player.defender();
    }
}
