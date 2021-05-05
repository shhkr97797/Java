【概要】
mainBattleメソッドが実行されると2体のモンスターがバトルを開始する。
コマンドラインより、「たたかう」or「にげる」のどちらかを選択し、モンスターHPが0になれば終了。
自身が記述したのは、
-----------------------
・Monster01.java
・Monster02.java
・Monster03.java
・Hitokake.java
・Fushigiyade.java
-----------------------
の上記5ファイル。

※仕様書の指示に従いコーディングを行う↓↓↓
1．「Monster01.java」の作成
　・フィールドを作成
　・toStringメソッドをオーバーライド（メソッドの動作確認などで使用）
　・levelUpメソッドを作成
　・setWazaメソッドを作成
　・getStatusメソッドを作成
　・useWazaメソッドを作成
　・damagedメソッドを作成
 
2．「Monster02.java」の作成
　・フィールドを作成
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
  
3．「Monster03.java」の作成
　・フィールドを作成
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
　・メソッドに修飾子を付与、getter/setterの作成
 
4．「Monster3.java」 を継承してサブクラス「Hitokake.java」の作成
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
　・levelUpメソッドのオーバーライド
 
5．「Monster3.java」 を継承してサブクラス「Fushigiyade.java」の作成
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
　・levelUpメソッドのオーバーライド


【学んだ点】
・クラスの継承
・Private変数
・this()
・super()
・Bigdecimalによる計算、丸目処理
https://qiita.com/shiho97797/items/2a4caca62b331aa6ebfb


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
