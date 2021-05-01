import java.sql.Time;

public class CalcWorkingTime {

	public static void main(String[] args) {

		/*---------- �萔 ----------*/
		final int HOURLY_SALARY = 900;
		final int MINUTE_SALALY = HOURLY_SALARY / 60;
		final int CONV_MINUTE_TO_MSEC = 1000 * 60;
		final int CONV_HOUR_TO_MINUTE = 60;
		final long WORK_TIME_TYPE01_END = 6 * CONV_HOUR_TO_MINUTE;  //6���Ԗ���
		final long WORK_TIME_TYPE02_START = 6 * CONV_HOUR_TO_MINUTE;//6���Ԉȏ�8���Ԗ����J�n
		final long WORK_TIME_TYPE02_END = 6 * CONV_HOUR_TO_MINUTE;  //6���Ԉȏ�8���Ԗ����I��
		final long REST_TYPE01 = 45 * CONV_MINUTE_TO_MSEC;          //6���Ԗ����x�e
		final long REST_TYPE02 = 60 * CONV_MINUTE_TO_MSEC;          //8���Ԉȏ�x�e
		final int ACTUAL_WORK_TIME_OVER = 8 * CONV_HOUR_TO_MINUTE;  //�c�Ƃ���������J�����ԁi8���ԁj
		final double OVER_WORK_RATE = 1.25;                         //�c�ƃ��[�g

		/*---------- �ϐ� ----------*/
		Time startTime = Time.valueOf(args[0]);                     //�o�Ύ���
		Time finishTime = Time.valueOf(args[1]);                    //�ދΎ���
		long workTime = finishTime.getTime() - startTime.getTime(); //�J�����ԁi�~���b�j
		int actualWorkTime = 0;                                     //���J�����ԁi���j
		int partTimeJobSalary = 0;                                  //���^


		/*---------------------------
			�J�����Ԍv�Z�i�~���b���番�ɕϊ��j
		---------------------------*/
		if(workTime <= WORK_TIME_TYPE01_END){

			actualWorkTime = (int)(workTime / CONV_MINUTE_TO_MSEC); //workTime �� �i1000 * 60�j

		}else if(workTime >= WORK_TIME_TYPE02_START && workTime <= WORK_TIME_TYPE02_END){

			actualWorkTime = (int)((workTime - REST_TYPE01) / CONV_MINUTE_TO_MSEC);

		}else{

			actualWorkTime = (int)((workTime - REST_TYPE02) / CONV_MINUTE_TO_MSEC);

		}


		/*---------------------------
			���^�v�Z
		---------------------------*/
		if(actualWorkTime >= ACTUAL_WORK_TIME_OVER){

			partTimeJobSalary = (MINUTE_SALALY * ACTUAL_WORK_TIME_OVER)
													+ (int)(OVER_WORK_RATE * (actualWorkTime - ACTUAL_WORK_TIME_OVER));

		}else{

			partTimeJobSalary = MINUTE_SALALY * actualWorkTime;

		}


		/*---------------------------
			���^�v�Z
		---------------------------*/
		System.out.println("�{���̋��^��" + partTimeJobSalary + "�ł��B");
	}
}
