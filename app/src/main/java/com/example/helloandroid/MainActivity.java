package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView _lvMenu;

    private List<Map<String, Object>> _menuList;

    private static final String[] FROM = {"name", "price"};

    private static final int[] TO = {R.id.tvMenuName, R.id.tvMenuPrice};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ダークモード拒否
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //画面部品ListViewを取得し、フィールドに格納。
        _lvMenu = findViewById(R.id.lvMenu);

        //SimpleAdapterで使用する定食メニューListオブジェクトをprivateメソッドを利用して用意し、フィールドに格納。
        _menuList = createTeishokuList();

        //SimpleAdapterを生成。
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);

        //アダプタの登録。
        _lvMenu.setAdapter(adapter);

        //リストタップのリスナクラス登録。
        _lvMenu.setOnItemClickListener(new ListItemClickListener());

        //コンテキストメニューをリストビューに登録。
        registerForContextMenu(_lvMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //メニューインフレーターの取得。
        MenuInflater inflater = getMenuInflater();
        //オプションメニュー用xmlファイルをインフレイト。
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        //親クラスの同名メソッドを呼び出し、その戻り値を返却。
        return super.onCreateOptionsMenu(menu);
    }

    private List<Map<String, Object>> createTeishokuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();

        //「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        //「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        //以下データ登録の繰り返し。
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 850);
        menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 950);
        menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }

    private List<Map<String, Object>> createCurryList() {
        //カレーメニューリスト用のListオブジェクトを用意。
        List<Map<String, Object>> menuList = new ArrayList<>();

        //「ビーフカレー」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ビーフカレー");
        menu.put("price", 520);
        menu.put("desc", "特選スパイスをきかせた国産ビーフ100%のカレーです。");
        menuList.add(menu);

        //「ポークカレー」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = new HashMap<>();
        menu.put("name", "ポークカレー");
        menu.put("price", 420);
        menu.put("desc", "特選スパイスをきかせた国産ポーク100%のカレーです。");
        menuList.add(menu);

        //以下データ登録の繰り返し。
        menu = new HashMap<>();
        menu.put("name", "ハンバーグカレー");
        menu.put("price", 620);
        menu.put("desc", "特選スパイスをきかせたカレーに手ごねハンバーグをトッピングです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チーズカレー");
        menu.put("price", 560);
        menu.put("desc", "特選スパイスをきかせたカレーにとろけるチーズをトッピングです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "カツカレー");
        menu.put("price", 760);
        menu.put("desc", "特選スパイスをきかせたカレーに国産ロースカツをトッピングです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ビーフカツカレー");
        menu.put("price", 880);
        menu.put("desc", "特選スパイスをきかせたカレーに国産ビーフカツをトッピングです。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "からあげカレー");
        menu.put("price", 540);
        menu.put("desc", "特選スパイスをきかせたカレーに若鳥のから揚げをトッピングです。");
        menuList.add(menu);

        return menuList;
    }

    /**
     * リストがタップされたときの処理が記述されたメンバクラス。
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータを取得。
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

            String menuName = (String) item.get("name");
            Integer menuPrice = (Integer) item.get("price");

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice + "円");

            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //選択されたメニューのIDを取得。
        int itemId = item.getItemId();
        //IDのR値による処理の分岐。
        switch (itemId) {
            //定食メニューが選択された場合の処理。
            case R.id.menuListOptionTeishoku:
                //定食メニューリストデータの生成。
                _menuList = createTeishokuList();
                break;
            //カレーメニューが選択された場合の処理。
            case R.id.menuListOptionCurry:
                //カレーメニューリストデータの生成。
                _menuList = createCurryList();
                break;
        }
        //SimpleAdapterを選択されたメニューデータで生成。
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menuList, R.layout.row, FROM, TO);
        //アダプタの登録。
        _lvMenu.setAdapter(adapter);
        //親クラスの同名メソッドを呼び出し、その戻り値を返却。
        return super.onOptionsItemSelected(item);
    }
}