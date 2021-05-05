package churimon;

class Hitokake extends Monster03 {

	/*---------- コンストラクタ ----------*/
	Hitokake() {
		super.setCharacter( "ヒトカケ" );
	}

	Hitokake( String tr, String nm ) {
		super( tr, nm );
		super.setCharacter( "ヒトカケ" );
	}

	Hitokake( String tr, String nm, int lv ) {
		super( tr, nm, lv );
		super.setCharacter( "ヒトカケ" );
	}


	/*---------- メソッド ----------*/
	// levelupメソッド（オーバーライド）
	public void levelUp( int lv ) {
		setLevel( getLevel() + lv * 1);
		setHp( getHp() + lv * 29 );
		setAtk( getAtk() + lv * 8 );
		setDef( getDef() + lv * 5 );
		setSpd( getSpd() + lv * 9 );
		setHpMax( getHp() );
	}



}
