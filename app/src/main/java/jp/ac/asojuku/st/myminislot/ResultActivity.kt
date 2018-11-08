package jp.ac.asojuku.st.myminislot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import java.util.*

class ResultActivity : AppCompatActivity() {

    var coin = 0;
    var betmoney = 0;

    val imageArray:Array<Int> = arrayOf(
            R.drawable.seven,
            R.drawable.bigwin,
            R.drawable.bar,
            R.drawable.cherry,
            R.drawable.face,
            R.drawable.grape
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        val pref = PreferenceManager.getDefaultSharedPreferences(this);
//        coin = pref.getInt("COIN",1000);

        coin = intent.getIntExtra("COIN",0);
        txv_temotik2.setText(coin.toString());
        betmoney = intent.getIntExtra("BET",0);
        txv_kakek2.setText(betmoney.toString());

        btn_stp1.setOnClickListener{ onStop1ButtonTapped()};

    }
    override fun onResume() {
        super.onResume()

        btn_back.setOnClickListener { finish() }
    }

    fun onStop1ButtonTapped() {
        var x = Random().nextInt(6);
        var y = Random().nextInt(6);
        var z = Random().nextInt(6);
        imv_1.setImageResource(imageArray[x]);
        imv_2.setImageResource(imageArray[y]);
        imv_3.setImageResource(imageArray[z]);
        if(x==y && y==z){
            if(x==0){
                var wincoin = betmoney * 20;
                coin += wincoin;
            }
            else if(x==1){
                var wincoin = betmoney * 10;
                coin += wincoin;
            }
            else if(x==2){
                var wincoin = betmoney * 5;
                coin += wincoin;
            }
            else{
                var wincoin = betmoney * 2;
                coin += wincoin;
            }
//            var wincoin = betmoney * 7;
//            coin += wincoin;

            val pref = PreferenceManager.getDefaultSharedPreferences(this);
            val editor = pref.edit()
            editor.putInt("COIN",coin)
                    .apply()

            txv_temotik2.setText(coin.toString())
        }
        else{
            var losecoin = betmoney;
            coin -= losecoin;

            val pref = PreferenceManager.getDefaultSharedPreferences(this);
            val editor = pref.edit()
            editor.putInt("COIN",coin)
                    .apply()

            txv_temotik2.setText(coin.toString())
        }
    }
//    fun onStop2ButtonTapped() {
//        val rand = Random();
//        var x = rand.nextInt(6)
//        imv_2.setImageResource(imageArray[x]);
//    }
//    fun onStop3ButtonTapped() {
//        val rand = Random();
//        var x = rand.nextInt(6)
//        imv_3.setImageResource(imageArray[x]);
//    }

}

