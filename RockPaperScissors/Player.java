import java.util.Random;

class Player {


	final String HAND_G = "�O�[";
	final String HAND_C = "�`���L";
	final String HAND_P = "�p�[";


	/* �t�B�[���h
	------------------------------ */
	String name;       //�v���C���[��
	String handStatus; //����񂯂�̎�
	
	/* �R���X�g���N�^
	------------------------------ */
	Player(String py){
		this.name = py;
	}

	/* �n���h�X�e�[�^�X
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

