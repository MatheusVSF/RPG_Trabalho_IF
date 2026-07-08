package model;

import java.util.Random;

public class Inimigo {
    public Status status;
    public int tipo;

    public Inimigo() {
        Random random = new Random();
        this.tipo = random.nextInt(2) + 1; 
        if (this.tipo == 1) {
            this.status = new Status(10, 5, 5);
        } else {
            this.status = new Status(20, 20, 10);
        }
    }

    public void receberDano(int dano) {
        this.status.hp -= dano;
        if (this.status.hp < 0) {
            this.status.hp = 0;
        }
    }

    public void atacar() {
        System.out.println("Inimigo do tipo " + tipo + " se prepara para atacar!");
    }
}
