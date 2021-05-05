package churimon;

class Fushigiyade extends Monster03 {

	/*---------- コンストラクタ ----------*/
	Fushigiyade() {
		super.setCharacter( "フシギヤネ" );
	}

	Fushigiyade( String tr, String nm ) {
		super( tr, nm );
		super.setCharacter( "フシギヤネ" );
	}

	Fushigiyade( String tr, String nm, int lv ) {
		super( tr, nm, lv );
		super.setCharacter( "フシギヤネ" );
	}


	/*---------- メソッド ----------*/
	// levelupメソッド（オーバーライド）
	public void levelUp( int lv ) {
		setLevel( getLevel() + lv * 1);
		setHp( getHp() + lv * 31 );
		setAtk( getAtk() + lv * 8 );
		setDef( getDef() + lv * 5 );
		setSpd( getSpd() + lv * 9 );
		setHpMax( getHp() );
	}



}
