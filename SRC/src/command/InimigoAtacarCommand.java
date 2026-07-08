package command;

import receiver.Player;
import model.Inimigo;
import java.util.Random;

public class InimigoAtacarCommand implements Command {
    private Inimigo inimigo;
    private Player player;
    private Random random = new Random();

    public InimigoAtacarCommand(Inimigo inimigo, Player player) {
        this.inimigo = inimigo;
        this.player = player;
    }

    @Override
    public void execute() {
        inimigo.atacar();
        int danoInimigo = inimigo.status.atk;
        int danoFinal = danoInimigo;
        
        if (player.estaDesviando) {

            int valorInimigo = random.nextInt(4) + 2; 
            System.out.println("O jogador tenta esquivar! Valor sorteado do Player: " + player.valorDesvioSorteado + " | Valor sorteado do Inimigo: " + valorInimigo);
            if (player.valorDesvioSorteado > valorInimigo) {
                danoFinal = 0;
                System.out.println("Sucesso! O jogador esquivou e sofreu 0 de dano!");
            } else {
                danoFinal = danoInimigo;
                System.out.println("Falha! O jogador não conseguiu esquivar e sofreu dano cheio (" + danoFinal + " de dano)!");
            }
        } else if (player.estaDefendendo) {
            
            danoFinal = danoInimigo - player.def;
            if (danoFinal < 0) {
                danoFinal = 0;
            }
            System.out.println("O jogador está defendendo! Dano final (Dano do Inimigo - Defesa do Player): " + danoFinal);
        } else {
        
            System.out.println("O jogador sofreu dano cheio: " + danoFinal);
        }

        player.receberDano(danoFinal);
        System.out.println("PV atual do jogador: " + player.pv);
    }
}
