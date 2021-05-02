class Janken {
	public static void main (String[] args) {


		/* プレイヤー名、レフェリー名インスタンス
		------------------------------ */
		Player player01 = new Player(args[0]);
		Player player02 = new Player(args[1]);
		Referee ref = new Referee(args[2]);


		/* 出力
		------------------------------ */
		ref.startJanken();             //開始の合図
		player01.makeHandStatus();     //player01の出し手を決める
		player02.makeHandStatus();     //player02の出し手を決める
		ref.checkHands(player01);      //player01の手を確認
		ref.checkHands(player02);      //player02の手を確認
		ref.judge(player01, player02); //勝敗判定




	}
}
