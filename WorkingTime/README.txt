【概要】





【学んだ点】
・バリデーションチェックの部分
・定数化する
	//技メソッド
	void setWaza(String wn, String wdr) {
		Boolean validationCheck =  wdr.matches("^[0-9]+\\.[0-9]$");
		if(validationCheck == true) {
			wazaName = wn;
			wazaDmgRate += wdr;
		}else {
			System.out.println("[Error]わざの設定に失敗しました");
		}
	}










【躓いた点】
①while Trueにより永遠にスクレイピングを行ってしまう
→ページ監視変数を定義し、各ページスクレイピング開始時、変数に１を足すことによりページ監視を行った。if文で条件分岐を行い指定した条件を満たせば処理を抜けれるようにした。

②csvファイルへ出力した際、文字が連なって見にくい
→to_csvメソッドの引数に「sep="　"」を渡すことでスペースが空き見やすくなった。

③ログ出力で下記のコードを記述したが、
------------------------------------------------
dt = datetime.datetime.now()
now_time = dt.strftime("%Y年%m月%d日 %H:%M:%S")
with open("log.txt", "a", encoding="utf-8") as f:
	print(now_time, name.text, sep="　", file=f)
------------------------------------------------
ログを出力したい時は何回も上記コードを書くのは効率が悪く、保守性も悪い。
下記のように関数にまとめる必要があると感じた。
------------------------------------------------
def log(txt):
    now=datetime.datetime.now().strftime('%Y-%m-%d-%H-%M-%S')
    logStr = '[%s: %s] %s' % ('log',now , txt)
    # ログ出力
    with open(log_file_path, 'a', encoding='utf-8_sig') as f:
        f.write(logStr + '\n')
    print(logStr)
------------------------------------------------

④Chromeドライバー更新でエラーが発生
→ネットで調べ対処するも状況は変わらず。一度、webdriver_managerを再インストールして上手くいく。