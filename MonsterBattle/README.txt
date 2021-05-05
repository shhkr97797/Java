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
　・フィールドを作成（private）
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
　・levelUpメソッドのオーバーライド
 
5．「Monster3.java」 を継承してサブクラス「Fushigiyade.java」の作成
　・フィールドを作成（private）
　・コンストラクタ作成（引数なし、引数2つ、引数3つ）
　・levelUpメソッドのオーバーライド


【学んだ点】
・クラスの継承
・private → そのクラス内からのみアクセス可能
・getter/setter → privateが付いている変数、メソッドにクラス外からアクセスに使用（参照：getter 代入：setter）
・this()
・super() → 親クラスのオブジェクトを参照
・Bigdecimalによる計算、丸目処理
https://qiita.com/shiho97797/items/2a4caca62b331aa6ebfb
