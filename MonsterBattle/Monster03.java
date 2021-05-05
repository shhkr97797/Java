package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Monster03 {

	/*---------- フィールド  ----------*/
	private String character;                   //種族
	private String trainer;                        //トレーナー
	private String name;                         //名前
	private int level;                                //レベル
	private int hp;                                  //HP
	private int atk;                                 //攻撃
	private int def;                                  //防御
	private int spd;                                 //速さ
	private int hpMax;                            //HP初期値
	private String wazaName;                 //技（名前）
	private String wazaDmgRate;            //技（ダメージ倍率）


	/*---------- コンストラクタ ----------*/
	Monster03() {
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

	Monster03( String tr, String nm ) {
		this();                                         // 引数無しコンストラクタを呼び出し
		this.trainer             = tr;               //トレーナー
		this.name              = nm;             //名前
	}

	Monster03( String tr, String nm, int lv ) {
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
	public void levelup( int lv ) {
		level += lv * 1;
		hpMax += lv * 30;
		atk   += lv * 5;
		def   += lv * 5;
		spd   += lv * 5;
		hpMax = hp;
	}


	//技メソッド
	public void setWaza( String wn, String wdr ) {
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
	public int useWaza() {
		BigDecimal a = new BigDecimal(atk);
		BigDecimal b = new BigDecimal(wazaDmgRate);

		int dmg = ((a.multiply(b)).setScale(0, RoundingMode.DOWN)).intValue();
		return dmg;
	}


	// 相手からダメージを受ける
	public int damaged(int td) {
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



	/*---------- getter / setter  ----------*/
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public String getWazaName() {
		return wazaName;
	}

	public void setWazaName(String wazaName) {
		this.wazaName = wazaName;
	}

	public String getWazaDmgRate() {
		return wazaDmgRate;
	}

	public void setWazaDmgRate(String wazaDmgRate) {
		this.wazaDmgRate = wazaDmgRate;
	}





}
