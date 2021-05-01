import java.sql.Time;

public class WorkingTime {

	public static void main(String[] args) {

		/*---------- 定数 ----------*/
		final int HOURLY_SALARY = 900;
		final int MINUTE_SALALY = HOURLY_SALARY / 60;
		final int CONV_MINUTE_TO_MSEC = 1000 * 60;
		final int CONV_HOUR_TO_MINUTE = 60;
		final long WORK_TIME_TYPE01_END = 6 * CONV_HOUR_TO_MINUTE;  //6時間未満
		final long WORK_TIME_TYPE02_START = 6 * CONV_HOUR_TO_MINUTE;//6時間以上8時間未満開始
		final long WORK_TIME_TYPE02_END = 6 * CONV_HOUR_TO_MINUTE;  //6時間以上8時間未満終了
		final long REST_TYPE01 = 45 * CONV_MINUTE_TO_MSEC;          //6時間未満休憩
		final long REST_TYPE02 = 60 * CONV_MINUTE_TO_MSEC;          //8時間以上休憩
		final int ACTUAL_WORK_TIME_OVER = 8 * CONV_HOUR_TO_MINUTE;  //残業が発生する労働時間（8時間）
		final double OVER_WORK_RATE = 1.25;                         //残業レート

		/*---------- 変数 ----------*/
		Time startTime = Time.valueOf(args[0]);                     //出勤時間
		Time finishTime = Time.valueOf(args[1]);                    //退勤時間
		long workTime = finishTime.getTime() - startTime.getTime(); //労働時間（ミリ秒）
		int actualWorkTime = 0;                                     //実労働時間（分）
		int partTimeJobSalary = 0;                                  //給与


		/*---------------------------
			労働時間計算（ミリ秒から分に変換）
		---------------------------*/
		if(workTime <= WORK_TIME_TYPE01_END){

			actualWorkTime = (int)(workTime / CONV_MINUTE_TO_MSEC); //workTime ÷ （1000 * 60）

		}else if(workTime >= WORK_TIME_TYPE02_START && workTime <= WORK_TIME_TYPE02_END){

			actualWorkTime = (int)((workTime - REST_TYPE01) / CONV_MINUTE_TO_MSEC);

		}else{

			actualWorkTime = (int)((workTime - REST_TYPE02) / CONV_MINUTE_TO_MSEC);

		}


		/*---------------------------
			給与計算
		---------------------------*/
		if(actualWorkTime >= ACTUAL_WORK_TIME_OVER){

			partTimeJobSalary = (MINUTE_SALALY * ACTUAL_WORK_TIME_OVER)
													+ (int)(OVER_WORK_RATE * (actualWorkTime - ACTUAL_WORK_TIME_OVER));

		}else{

			partTimeJobSalary = MINUTE_SALALY * actualWorkTime;

		}


		/*---------------------------
			給与計算
		---------------------------*/
		System.out.println("本日の給与は" + partTimeJobSalary + "です。");
	}
}
