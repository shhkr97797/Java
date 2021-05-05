package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Monster02 {

	/*---------- フィールド  ----------*/
	String character;                   //種族
	String trainer;                        //トレーナー
	String name;                         //名前
	int level;                                //レベル
	int hp;                                  //HP
	int atk;                                 //攻撃
	int def;                                  //防御
	int spd;                                 //速さ
	int hpMax;                            //HP初期値
	String wazaName;                 //技（名前）
	String wazaDmgRate;            //技（ダメージ倍率）


	/*---------- コンストラクタ ----------*/
	Monster02() {
		this.character         = "(Unknown)"; //種族
		this.trainer             = "(Wild)";       //トレーナー
		this.name              = "(NoName)"; //名前
		this.level                = 1;                //レベル
		this.hp                   = 80;              //HP
		this.atk                  = 15;              //攻撃
		this.def                  = 10;              //防御
		this.spd                 = 10;              //速さ
		this.hpMax            = 80;              //HP初期値
		this.wazaName      = "たいあたり"; //技（名前）
		this.wazaDmgRate = "1.0";           //技（ダメージ倍率）
	}

	Monster02( String tr, String nm ) {
		this();                                         // 引数無しコンストラクタを呼び出し
		this.trainer             = tr;               //トレーナー
		this.name              = nm;             //名前
	}

	Monster02( String tr, String nm, int lv ) {
		this( tr, nm );                                          // 引数無しコンストラクタを呼び出
		if( lv > 1 ) {
			levelup( lv - 1 );
		}
	}



	/*---------- フィールド定数  ----------*/
	String DMAGE_CORRECTION_1 = "1";         //ダメージ計算補正（1）
	String DMAGE_CORRECTION_120 = "120";  //ダメージ計算補正（120）


	/*---------- toStringメソッド  ----------*/
	public String toString() {
		String status =  "<フィールド確認>character：" + this.character + " / " +
				"trainer：" + this.trainer + " / " +
				"name：" + this.name + " / " +
				"level：" + this.level + " / " +
				"hp：" + this.hp + " / " +
				"atk：" + this.atk + " / " +
				"def：" + this.def + " / " +
				"spd：" + this.spd + " / " +
				"hpMax：" + this.hpMax + " / " +
				"wazaName：" + this.wazaName + " / " +
				"wazaDmgRate：" + this.wazaDmgRate;
		return status;
	}


	//レベルアップメソッド
	void levelup( int lv ) {
		level += lv * 1;
		hpMax += lv * 30;
		atk   += lv * 5;
		def   += lv * 5;
		spd   += lv * 5;
		hpMax = hp;
	}


	//技メソッド
	void setWaza( String wn, String wdr ) {
		Boolean validationCheck =  wdr.matches( "^[0-9]+\\.[0-9]$" );
		if( validationCheck == true ) {
			wazaName = wn;
			wazaDmgRate += wdr;
		} else {
			System.out.println( "[Error]わざの設定に失敗しました" );
		}
	}


	// ステータス確認
	public String getStatus() {
		String status = "[" + name + " " + level + " " + hp + "/" + hpMax + "]";
		return status;
	}


	// 相手にダメージを与える
	int useWaza() {
		BigDecimal a = new BigDecimal(atk);
		BigDecimal b = new BigDecimal(wazaDmgRate);

		int dmg = ((a.multiply(b)).setScale(0, RoundingMode.DOWN)).intValue();
		return dmg;
	}


	// 相手からダメージを受ける
	int damaged(int td) {
		BigDecimal bdTd = new BigDecimal(td);
		BigDecimal bdDc1 = new BigDecimal(DMAGE_CORRECTION_1);
		BigDecimal bdD120 = new BigDecimal(DMAGE_CORRECTION_120);
		BigDecimal bdDef = new BigDecimal(def);

		// ダメージ減産率【 1 / ( 1 + 防御 / 120) ] ※小数第3位以下切り捨て】
		BigDecimal bddmgRate =  bdDc1.divide( bdDc1.add( bdDef.divide( bdD120, 2, RoundingMode.DOWN ) ), 2, RoundingMode.DOWN ) ;

		// 実際に受けるダメージ：【引数 * ダメージ減産率】※int型へ変換
		int damageReceived = ( bdTd.multiply( bddmgRate ) ).setScale(0, RoundingMode.DOWN ).intValue();

		// 受けるダメージが大きい場合はhpを0にする
		if( hp > damageReceived ) {
			hp += hp - damageReceived;
		} else {
			hp += 0;
		}
		return damageReceived;
	}



}
