class Janken {
	public static void main (String[] args) {


		/* �v���C���[���A���t�F���[���C���X�^���X
		------------------------------ */
		Player player01 = new Player(args[0]);
		Player player02 = new Player(args[1]);
		Referee ref = new Referee(args[2]);


		/* �o��
		------------------------------ */
		ref.startJanken();             //�J�n�̍��}
		player01.makeHandStatus();     //player01�̏o��������߂�
		player02.makeHandStatus();     //player02�̏o��������߂�
		ref.checkHands(player01);      //player01�̎���m�F
		ref.checkHands(player02);      //player02�̎���m�F
		ref.judge(player01, player02); //���s����




	}
}
