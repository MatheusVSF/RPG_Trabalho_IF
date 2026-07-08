package command;

import receiver.Player;

public class AtacarCommand implements Command {
    private Player player;

    public AtacarCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.atacar();
    }
}
