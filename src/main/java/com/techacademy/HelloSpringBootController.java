//ある文章に注を加えて本文の意味を説明すること 注釈（ちゅうしゃく）＠アノテーション
package com.techacademy;

import java.time.LocalDateTime; // 追加
import java.time.format.DateTimeFormatter; // 追加

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // 追加
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!";
    }

    // ----- dispTimeメソッドを追加　追加:ここから -----
    @GetMapping("now")
    public String dispTime() {
        String now = LocalDateTime.now().format( DateTimeFormatter.ofPattern("HH:mm:ss") );

        return "現在時刻：" + now;
    }
    // ----- 追加:ここまで -----

 // ----- URLのパラメータをサーバ側で受け取って、その値を利用した処理　calcPlusメソッドを追加　追加:ここから -----
    //{val1}と{val2}の部分は「パスパラメータ」と呼ばれるURLのパス部分に指定した値を変数として取り出す機能
    //それぞれの変数は@PathVariableというアノテーションで取得できます
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }
    // ----- 追加:ここまで -----
}