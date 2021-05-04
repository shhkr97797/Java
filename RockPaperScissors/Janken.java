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
		player01.makeHandStatus();     //player01の出し手
		player02.makeHandStatus();     //player02の出し手
		ref.checkHands(player01);      //審判がplayer01の手を確認
		ref.checkHands(player02);      //審判がplayer02の手を確認
		ref.judge(player01, player02); //審判の勝敗判定




	}
}
