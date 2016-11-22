package cubesystem.kurimabank.activity;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import cubesystem.kurimabank.R;
import cubesystem.kurimabank.model.Info;
import cubesystem.kurimabank.model.Info2;

/**
 * Created by sayaka-kurima on 2016/09/07.
 */

public class Register extends AppCompatActivity {
    private Spinner dCode;
    private Spinner dUchiwake;
    private Spinner dCashOrCard;
    private EditText tMoney;
    private Spinner dPlan;
    private CheckBox cTatekae;

    private Button mClearButton;
    private Button mSaveButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Calendar cal = Calendar.getInstance();       //カレンダーを取得

        int iYear = cal.get(Calendar.YEAR);         //年を取得
        int iMonth = cal.get(Calendar.MONTH);       //月を取得
        int iDate = cal.get(Calendar.DATE);         //日を取得

        String strDay = iYear + "年" + (iMonth + 1) + "月" + iDate + "日";     //日付を表示形式で設定

        TextView tv = (TextView)findViewById(R.id.TextDate);
        tv.setText(strDay);

        //支出・入金区分をセット
        dCode = (Spinner)findViewById(R.id.Code);
        //dCode.getSelectedItem()
        final String[] code_values = getResources().getStringArray(R.array.list1);
        for (int i = 0; i < code_values.length; i++){
            //★★★　09/13　このreasonがよくわからない★★★
            if (code_values[i].equalsIgnoreCase(Info2.getInstance().reason)){
                dCode.setSelection(i);
                //dCode.getSelectedItem()
                break;
            }
        }

        //内訳をセット
        dUchiwake = (Spinner)findViewById(R.id.Uchiwake);
        final String[] uchiwake_values = getResources().getStringArray(R.array.list2);
        for (int i = 0; i < uchiwake_values.length; i++){
            //★★★　09/13　このreasonがよくわからない★★★
            if (uchiwake_values[i].equalsIgnoreCase(Info.getInstance().reason)){
                dUchiwake.setSelection(i);
                break;
            }
        }

        mClearButton= (Button)findViewById(R.id.ClearButton);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //入力値をクリア

            }
        });

        mSaveButton= (Button)findViewById(R.id.SaveButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DBに登録
                // サマリ画面へ遷移
                Intent intent = new Intent(Register.this, Summary.class);
                startActivity(intent);

            }
        });

        mCancelButton= (Button)findViewById(R.id.CancelButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // サマリ画面へ遷移
                Intent intent = new Intent(Register.this, Summary.class);
                startActivity(intent);
            }
        });

    }

}