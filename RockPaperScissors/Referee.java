class Referee {

	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";


	/* フィールド
	------------------------------ */
	String name;       //審判名
	
	/* コンストラクタ
	------------------------------ */
	Referee(String rf){
		this.name = rf;
	}
	
	/* スタート合図
	------------------------------ */
	void startJanken(){
		refereeSay("じゃんけん・・・ぽん！！！");
	}

	/* ハンドステータス確認
	------------------------------ */
	void checkHands(Player p){

		if(p.handStatus.equals(HAND_G)){
			refereeSay(p.name + "さんの手はグーでした！");
		}else if(p.handStatus.equals(HAND_C)){
			refereeSay(p.name + "さんの手はチョキでした！");
		}else if(p.handStatus.equals(HAND_P)){
			refereeSay(p.name + "さんの手はパーでした！");
		}else{
			System.out.println("[Error] ハンドステータスが不正です。");
		}

	}

	/* 結果判定
	------------------------------ */
	void judge(Player player01, Player player02){

		if((player01.handStatus).equals(player02.handStatus)){ //あいこの場合
			refereeSay("あいこ！勝負つかず！");
		} else if (                                            //player01が勝った場合
			player01.handStatus.equals(HAND_G) && player02.handStatus.equals(HAND_C) ||
			player01.handStatus.equals(HAND_C) && player02.handStatus.equals(HAND_P) ||
			player01.handStatus.equals(HAND_P) && player02.handStatus.equals(HAND_G)
		){
			refereeSay(player01.name + "さんの勝利！");
		}else if(                                              //player02が勝った場合
			player02.handStatus.equals(HAND_G) && player01.handStatus.equals(HAND_C) ||
			player02.handStatus.equals(HAND_C) && player01.handStatus.equals(HAND_P) ||
			player02.handStatus.equals(HAND_P) && player01.handStatus.equals(HAND_G)
		){
			refereeSay(player02.name + "さんの勝利！");
		}else{
			System.out.println("[Error] じゃんけんの判定が不正です。");
		}

	}

	/* command出力
	------------------------------ */
	void refereeSay(String msg){
		System.out.println( this.name + "「" + msg + "」" );
	}



}
