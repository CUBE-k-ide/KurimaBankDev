package cubesystem.kurimabank.activity;

//import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import cubesystem.kurimabank.R;
import cubesystem.kurimabank.db.MySQLiteOpenHelper;
import cubesystem.kurimabank.model.Info;

/**
 * Created by kurimabank-kurima on 2016/08/31.
 */
public class Login extends AppCompatActivity {
    private Calendar mRadioGroupAction;
    private Button mButtonNext;
    //private EditText mEditText1;
    //private SetTime mSetTimeComingTime;
    //private Button mButtonNext;

    //private Action[] actionList = {
    //new ActionDelay("遅刻",""),
    //new ActionVacation("午前半休"),
    //new ActionVacation("午後半休"),
    //new ActionVacation("全休")

    //★
    static SQLiteDatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        DBオープン ⇒　削除　⇒ 登録　⇒ 検索
         */

        //★DBオープン
        MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(getApplicationContext());
        mydb = hlpr.getWritableDatabase();

        //★列の削除
        int isDelete = mydb.delete("KURT_DETAIL", null, null);

        //★列の挿入
        ContentValues values = new ContentValues();
        values.put("DETAILNO", "0000000001");
        values.put("DETAILYMD", "20160905");
        values.put("RECEIVEPAYKBN", "1");
        values.put("ITMCD", "ITM01");
        values.put("ABSTRACT", "摘要");
        values.put("RECEIVEPAYMETHODCD", "1");
        values.put("MONEY", 2000);
        mydb.insert("KURT_DETAIL", null, values);

        //★列の検索
        Cursor cur = null;
        cur = mydb.query("KURT_DETAIL"
                ,new String[] {"DETAILNO", "DETAILYMD", "RECEIVEPAYKBN", "ABSTRACT"} //select項目
                ,"DETAILNO = ? " //where句
                ,new String[] {"0000000001"} //バインド変数に設定する値
                ,null //group byする列
                ,null //havingする列
                ,null //order byする列
                ,null //limit 句の内容
        );



        //★検索結果の取得
        if (cur != null && cur.moveToFirst()) {
            String detailNo = cur.getString(cur.getColumnIndex("DETAILNO"));
            String detailYmd = cur.getString(cur.getColumnIndex("DETAILYMD"));
            String receivepaykbn = cur.getString(cur.getColumnIndex("RECEIVEPAYKBN"));
            String abstruct = cur.getString(cur.getColumnIndex("ABSTRACT"));

        }

    }


    //ボタン押したら画面遷移したい
    public void onClick(View view){
        switch (view.getId()){
            case R.id.email_sign_in_button:
                Intent intent = new Intent(Login.this, Summary.class);
                startActivity(intent);
                break;
        }
    }

}