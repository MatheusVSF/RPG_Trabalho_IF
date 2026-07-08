package command;

import receiver.Player;

public class CurarCommand implements Command {
    private Player player;

    public CurarCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pv += 5;
        player.curar();
    }
}
