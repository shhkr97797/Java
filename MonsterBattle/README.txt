�y�T�v�z
mainBattle���\�b�h�����s������2�̂̃����X�^�[���o�g�����J�n����B
�R�}���h���C�����A�u���������vor�u�ɂ���v�̂ǂ��炩��I�����A�����X�^�[HP��0�ɂȂ�ΏI���B




�y�w�񂾓_�z
�E�N���X�̌p��
�EPrivate�ϐ�
�Ethis()
�Esuper()
�EBigdecimal�ɂ��v�Z
�E�ۖڏ���








�y�T�����_�z
�@while True�ɂ��i���ɃX�N���C�s���O���s���Ă��܂�
���y�[�W�Ď��ϐ����`���A�e�y�[�W�X�N���C�s���O�J�n���A�ϐ��ɂP�𑫂����Ƃɂ��y�[�W�Ď����s�����Bif���ŏ���������s���w�肵�������𖞂����Ώ����𔲂����悤�ɂ����B

�Acsv�t�@�C���֏o�͂����ہA�������A�Ȃ��Č��ɂ���
��to_csv���\�b�h�̈����Ɂusep="�@"�v��n�����ƂŃX�y�[�X���󂫌��₷���Ȃ����B

�B���O�o�͂ŉ��L�̃R�[�h���L�q�������A
------------------------------------------------
dt = datetime.datetime.now()
now_time = dt.strftime("%Y�N%m��%d�� %H:%M:%S")
with open("log.txt", "a", encoding="utf-8") as f:
	print(now_time, name.text, sep="�@", file=f)
------------------------------------------------
���O���o�͂��������͉������L�R�[�h�������̂͌����������A�ێ琫�������B
���L�̂悤�Ɋ֐��ɂ܂Ƃ߂�K�v������Ɗ������B
------------------------------------------------
def log(txt):
    now=datetime.datetime.now().strftime('%Y-%m-%d-%H-%M-%S')
    logStr = '[%s: %s] %s' % ('log',now , txt)
    # ���O�o��
    with open(log_file_path, 'a', encoding='utf-8_sig') as f:
        f.write(logStr + '\n')
    print(logStr)
------------------------------------------------

�CChrome�h���C�o�[�X�V�ŃG���[������
���l�b�g�Œ��בΏ�������󋵂͕ς�炸�B��x�Awebdriver_manager���ăC���X�g�[�����ď�肭�����B