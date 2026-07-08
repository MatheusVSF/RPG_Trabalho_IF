package uI;

import receiver.Player;
import model.Inimigo;
import factory.CommandFactory;
import invoker.GameEngine;
import java.util.Scanner;

public class ConsoLeUI {
    private Player player;
    private Inimigo inimigo;
    private GameEngine engine;
    private Scanner scanner;

    public ConsoLeUI(Player player, Inimigo inimigo, CommandFactory factory, GameEngine engine) {
        this.player = player;
        this.inimigo = inimigo;
        this.engine = engine;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarLoopCombate() {
        System.out.println("--- INÍCIO DO COMBATE ---");
        System.out.println("Status inicial do Jogador: PV=" + player.pv + ", DEF=" + player.def + ", ATK=" + player.atk);
        System.out.println("Status inicial do Inimigo: PV=" + inimigo.status.hp + ", DEF=" + inimigo.status.def + ", ATK=" + inimigo.status.atk);
        
        while (player.pv > 0 && inimigo.status.hp > 0) {
            System.out.println("\n--- Turno do Jogador ---");
            System.out.println("Escolha sua ação: atacar, defender, desviar, curar");
            String acao = scanner.nextLine();
            
            player.resetarTurno();
            
            command.Command comandoPlayer = factory.obterComando(acao);
            engine.executarComando(comandoPlayer);
            
            if (inimigo.status.hp > 0) {
                System.out.println("\n--- Turno do Inimigo ---");
                command.Command comandoInimigo = new command.InimigoAtacarCommand(inimigo, player);
                engine.executarComando(comandoInimigo);
            }
            
            System.out.println("Status no fim do turno: PV Jogador=" + player.pv + ", PV Inimigo=" + inimigo.status.hp);
        }
        
        System.out.println("\n--- FIM DO COMBATE ---");
        if (player.pv <= 0) {
            System.out.println("O Jogador foi derrotado!");
        } else {
            System.out.println("O Inimigo foi derrotado! O Jogador venceu!");
        }
    }
}
