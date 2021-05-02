import java.util.Random;

class Player {


	final String HAND_G = "グー";
	final String HAND_C = "チョキ";
	final String HAND_P = "パー";


	/* フィールド
	------------------------------ */
	String name;       //プレイヤー名
	String handStatus; //じゃんけんの手
	
	/* コンストラクタ
	------------------------------ */
	Player(String py){
		this.name = py;
	}

	/* ハンドステータス
	------------------------------ */
	void makeHandStatus(){

		Random rd = new Random();
		int index = rd.nextInt(3);
		switch (index) {
			case 0:
				this.handStatus = HAND_G;
				break;
			case 1:
				this.handStatus = HAND_C;
				break;
			case 2:
				this.handStatus = HAND_P;
				break;
		}

	}


}

