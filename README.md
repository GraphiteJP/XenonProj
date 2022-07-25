# XenonProj

## What Is "Xenon" ?

Xenonは、Graphiteによる新しいプログラミング言語です。

## 言語仕様について(仮案)

### コメント

```
// コメント
/* コメント */
/*
  コメント
*/
```

### 変数

```
// まだ決まってない
```

### 関数

```
fn main() {
    // メイン関数
}

fn newFunction(x:int, y:int) -> int {
    // ->で返り値
    return x * y
}
```

### クラス

```
class newClass {
    /*
     * フィールド変数はデフォルトでprivate
     * pubをつけるとパブリック
     * メソッド内からのアクセスにはselfが必要
     */
    pub int x = 0
    pub int y = 0
    @Static
    pub int z = 0 // @Staticで静的

    newClass(self, x:int, y:int) {
        // コンストラクタ
        self.x = x
        self.y = y
    }

    fn method(self) {
        // メソッド
        return self.x + self.y
    }
}
```
