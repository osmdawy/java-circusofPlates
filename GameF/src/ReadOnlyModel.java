
public class ReadOnlyModel  {
	ReadOnlyPlayer player1;
	ReadOnlyPlayer player2;
	public ReadOnlyModel(Player p1, Player p2){
		player1 = new ReadOnlyPlayer(p1);
		player2 = new ReadOnlyPlayer(p2);
	}
	public ReadOnlyPlayer getPlayer1() {
		return player1;
	}

	public void setPlayer1(ReadOnlyPlayer player1) {
		this.player1 = player1;
	}

	public ReadOnlyPlayer getPlayer2() {
		return player2;
	}

	public void setPlayer2(ReadOnlyPlayer player2) {
		this.player2 = player2;
	}

	

}
