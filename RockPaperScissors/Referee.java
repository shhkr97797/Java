class Referee {

	final String HAND_G = "�O�[";
	final String HAND_C = "�`���L";
	final String HAND_P = "�p�[";


	/* �t�B�[���h
	------------------------------ */
	String name;       //�R����
	
	/* �R���X�g���N�^
	------------------------------ */
	Referee(String rf){
		this.name = rf;
	}
	
	/* �X�^�[�g���}
	------------------------------ */
	void startJanken(){
		refereeSay("����񂯂�E�E�E�ۂ�I�I�I");
	}

	/* �n���h�X�e�[�^�X�m�F
	------------------------------ */
	void checkHands(Player p){

		if(p.handStatus.equals(HAND_G)){
			refereeSay(p.name + "����̎�̓O�[�ł����I");
		}else if(p.handStatus.equals(HAND_C)){
			refereeSay(p.name + "����̎�̓`���L�ł����I");
		}else if(p.handStatus.equals(HAND_P)){
			refereeSay(p.name + "����̎�̓p�[�ł����I");
		}else{
			System.out.println("[Error] �n���h�X�e�[�^�X���s���ł��B");
		}

	}

	/* ���ʔ���
	------------------------------ */
	void judge(Player player01, Player player02){

		if((player01.handStatus).equals(player02.handStatus)){ //�������̏ꍇ
			refereeSay("�������I���������I");
		} else if (                                            //player01���������ꍇ
			player01.handStatus.equals(HAND_G) && player02.handStatus.equals(HAND_C) ||
			player01.handStatus.equals(HAND_C) && player02.handStatus.equals(HAND_P) ||
			player01.handStatus.equals(HAND_P) && player02.handStatus.equals(HAND_G)
		){
			refereeSay(player01.name + "����̏����I");
		}else if(                                              //player02���������ꍇ
			player02.handStatus.equals(HAND_G) && player01.handStatus.equals(HAND_C) ||
			player02.handStatus.equals(HAND_C) && player01.handStatus.equals(HAND_P) ||
			player02.handStatus.equals(HAND_P) && player01.handStatus.equals(HAND_G)
		){
			refereeSay(player02.name + "����̏����I");
		}else{
			System.out.println("[Error] ����񂯂�̔��肪�s���ł��B");
		}

	}

	/* command�o��
	------------------------------ */
	void refereeSay(String msg){
		System.out.println( this.name + "�u" + msg + "�v" );
	}



}
