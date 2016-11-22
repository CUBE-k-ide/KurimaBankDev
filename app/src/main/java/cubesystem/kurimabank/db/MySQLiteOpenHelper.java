package cubesystem.kurimabank.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    static final String DB = "kurimabank.db";
    static final int DB_VERSION = 1;

    public MySQLiteOpenHelper(Context c) {
        super(c, DB, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        StringBuilder createTable = new StringBuilder();
        //明細テーブル
        createTable.append("create table KURT_DETAIL (");
        createTable.append("  DETAILNO text primary key ");
        createTable.append(", DETAILYMD text not null");
        createTable.append(", RECEIVEPAYKBN text not null");
        createTable.append(", ITMCD text not null");
        createTable.append(", ABSTRACT text not null");
        createTable.append(", RECEIVEPAYMETHODCD text not null");
        createTable.append(", MONEY integer not null");
        createTable.append(");");

        db.execSQL(createTable.toString());

        // 初期データ投入
        this.setupinitialData(db);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        StringBuilder dropTable = new StringBuilder();
        //明細テーブル
        dropTable.append("drop table KURT_DETAIL;");

        db.execSQL(dropTable.toString());
        onCreate(db);
    }

    private void setupinitialData (SQLiteDatabase db){

//        //★列の挿入(テスト)
//        ContentValues values = new ContentValues();
//        values.put("DETAILNO", "0000000001");
//        values.put("DETAILYMD", "20160905");
//        values.put("RECEIVEPAYKBN", "1");
//        values.put("ITMCD", "ITM01");
//        values.put("ABSTRACT", "摘要");
//        values.put("RECEIVEPAYMETHODCD", "1");
//        values.put("MONEY", 2000);
//
//        db.insertOrThrow("KURT_DETAIL", null, values);
    }
}
