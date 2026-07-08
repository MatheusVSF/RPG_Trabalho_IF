package receiver;

public class Player {
    public int pv = 20;
    public int def = 20;
    public int atk = 10;

    public boolean estaDefendendo = false;
    public boolean estaDesviando = false;
    public int valorDesvioSorteado = 0;

    public void atacar() {
        System.out.println("O jogador ataca causando " + atk + " de dano!");
    }

    public void defender() {
        System.out.println("O jogador se defende com " + def + " de defesa total!");
    }

    public void desviar() {
        System.out.println("O jogador tenta desviar do ataque inimigo!");
    }

    public void curar() {
        System.out.println("O jogador se cura em 5 pontos de vida! PV atual: " + pv);
    }

    public void receberDano(int dano) {
        this.pv -= dano;
        if (this.pv < 0) {
            this.pv = 0;
        }
    }

    public void resetarTurno() {
        this.estaDefendendo = false;
        this.estaDesviando = false;
        this.valorDesvioSorteado = 0;
        this.def = 20; 
    }
}
