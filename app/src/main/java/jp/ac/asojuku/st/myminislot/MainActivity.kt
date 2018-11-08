package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var betmoney:Int = 10;
    var coin:Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        coin = pref.getInt("COIN",1000);
        betmoney = pref.getInt("BET",10);


        txv_temotik.setText(coin.toString());


        btn_start.setOnClickListener{ onStartButtonTapped(it)};

        btn_Reset.setOnClickListener{ onResetButtonTapped(it)};
        btn_down.setOnClickListener{ onDownButtonTapped(it)};
        btn_up.setOnClickListener{ onUpButtonTapped(it)};

    }

    fun onStartButtonTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java);
        intent.putExtra("COIN", coin).putExtra("BET",betmoney);
        startActivity(intent);
    }

    fun onResetButtonTapped(view: View?){
        coin = 1000;
        betmoney = 10;
        txv_kakek.setText(betmoney.toString());
        txv_temotik.setText(coin.toString());
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        val editor = pref.edit();
        editor.clear().apply();
    }
    fun onDownButtonTapped(view: View?){
        betmoney-=10;
        coin+=10;
        txv_kakek.setText(betmoney.toString());
        txv_temotik.setText(coin.toString());
    }
    fun onUpButtonTapped(view: View?){
        betmoney+=10;
        coin-=10;
        txv_kakek.setText(betmoney.toString());
        txv_temotik.setText(coin.toString());
    }
}
