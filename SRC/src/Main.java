import java.util.Scanner;
import receiver.Player;
import model.Inimigo;
import command.Command;
import command.InimigoAtacarCommand;
import factory.CommandFactory;
import invoker.GameEngine;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player jogador = new Player();
        Inimigo inimigo = new Inimigo();
        GameEngine engine = new GameEngine();
        CommandFactory factory = new CommandFactory(jogador, inimigo);

        System.out.println("=== RPG INICIADO ===");
        System.out.println("Status do Jogador: PV=" + jogador.pv + " | DEF=" + jogador.def + " | ATK=" + jogador.atk);
        System.out.println("Inimigo Tipo " + inimigo.tipo + " apareceu! Status: HP=" + inimigo.status.hp + " | DEF=" + inimigo.status.def + " | ATK=" + inimigo.status.atk);
        System.out.println("====================\n");

        while (jogador.pv > 0 && inimigo.status.hp > 0) {
            jogador.resetarTurno();

            System.out.println("Escolha sua ação: [atacar] [defender] [desviar] [curar]");
            System.out.print("> ");
            String acao = scanner.nextLine().trim().toLowerCase();

            Command comandoJogador = factory.obterComando(acao);
            if (comandoJogador == null) {
                System.out.println("Ação inválida! Você perdeu o turno.");
            } else {
                System.out.println("\n--- Turno do Jogador ---");
                engine.executarComando(comandoJogador);
            }

            if (inimigo.status.hp <= 0) {
                System.out.println("\nParabéns! Você derrotou o inimigo!");
                break;
            }

            System.out.println("\n--- Turno do Inimigo ---");
            Command comandoInimigo = new InimigoAtacarCommand(inimigo, jogador);
            engine.executarComando(comandoInimigo);

            if (jogador.pv <= 0) {
                System.out.println("\nVocê foi derrotado... Fim de jogo!");
                break;
            }

            System.out.println("\n=== Fim do Turno ===");
            System.out.println("Status do Jogador: PV=" + jogador.pv + " | DEF=" + jogador.def + " | ATK=" + jogador.atk);
            System.out.println("Status do Inimigo: HP=" + inimigo.status.hp + " | DEF=" + inimigo.status.def + " | ATK=" + inimigo.status.atk);
            System.out.println("====================\n");
        }

        scanner.close();
    }
}