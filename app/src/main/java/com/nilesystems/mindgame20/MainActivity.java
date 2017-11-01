package com.nilesystems.mindgame20;

import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Integer> aa = new ArrayList<Integer>();

    public int Crcktans;
    public int Incrcktans;
    public float score, noofqu;

    public Button bt, bt2;
    public TextView tt1, tt2, tt3, tt4;
    public GridLayout gl;
    public Button b1, b2, b3, b4;
    public ImageView ii;

    public void questions() {
        Random ran = new Random();
        int a = ran.nextInt(200);
        int b = ran.nextInt(200);
        int Incrcktans = 0;

        int casess = ran.nextInt(4);

        switch(casess) {
            case 0 :
                tt2.setText(Integer.toString(a) + "+" + Integer.toString(b));
                //aa.add(a + b);

                Crcktans = ran.nextInt(4);
                aa.clear();
                for (int i = 0; i < 4; i++) {
                    if (i == Crcktans) {
                        aa.add(a + b);

                    } else {
                        Incrcktans = ran.nextInt(400);
                        while (Incrcktans == a + b) {
                            Incrcktans = ran.nextInt(400);
                        }
                    }
                    aa.add(Incrcktans);
                }

                break;

            case 1 :
                tt2.setText(Integer.toString(a) + " - " + Integer.toString(b));
                Crcktans = ran.nextInt(4);
                aa.clear();
                for (int i=0; i<4; i++) {
                    if (i == Crcktans) {
                        aa.add(a - b);
                    } else {
                        Incrcktans = ran.nextInt(41);
                        while (Incrcktans == a - b) {
                            Incrcktans = ran.nextInt(41);
                        }
                        aa.add(Incrcktans);
                    }
                }
                break;

            case 2 :
                tt2.setText(Integer.toString(a) + " X " + Integer.toString(b));
                Incrcktans = ran.nextInt(4);
                aa.clear();
                for (int i=0; i<4; i++) {
                    if (i == Crcktans) {
                        aa.add(a * b);
                    } else {
                        Incrcktans = ran.nextInt(401);
                        while (Incrcktans == a * b) {
                            Incrcktans = ran.nextInt(401);
                        }
                        aa.add(Incrcktans);
                    }
                }
                break;

            case 3 :
                if((a>b)&&(a%b==0)) {
                    tt2.setText(Integer.toString(a) + " / " + Integer.toString(b));
                    Crcktans = ran.nextInt(4);
                    aa.clear();
                    for (int i = 0; i < 4; i++) {
                        if (i == Crcktans) {
                            aa.add(a / b);
                        } else {
                            Incrcktans = ran.nextInt(41);
                            while (Incrcktans == a - b) {
                                Incrcktans = ran.nextInt(41);
                            }
                            aa.add(Incrcktans);
                        }
                    }
                }
                aa.clear();
                questions();
                break;
        }


        b1.setText(Integer.toString(aa.get(0)));
        b2.setText(Integer.toString(aa.get(1)));
        b3.setText(Integer.toString(aa.get(2)));
        b4.setText(Integer.toString(aa.get(3)));
    }

    public void randoms(View view) {
        if (view.getTag().toString().equals(Integer.toString(Crcktans))) {
            tt4.setVisibility(view.VISIBLE);
            tt4.setText("Correct");
            score++;


        } else {
            tt4.setVisibility(view.VISIBLE);
            tt4.setText("Incorrect!");
        }
        noofqu++;
        tt3.setText(Float.toString(score) + "/" + Float.toString(noofqu));
        questions();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.btn);
        tt1 = (TextView) findViewById(R.id.tv1);
        tt2 = (TextView) findViewById(R.id.tv2);
        tt3 = (TextView) findViewById(R.id.tv3);
        tt4 = (TextView) findViewById(R.id.tv4);
        gl = (GridLayout) findViewById(R.id.gridLayout);
        bt2 = (Button) findViewById(R.id.btn2);
        b1 = (Button) findViewById(R.id.g1);
        b2 = (Button) findViewById(R.id.g2);
        b3 = (Button) findViewById(R.id.g3);
        b4 = (Button) findViewById(R.id.g4);
        ii = (ImageView) findViewById(R.id.iv);

        questions();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    public void Starts(View view) {
        bt.setVisibility(View.INVISIBLE);
        tt1.setVisibility(View.VISIBLE);
        tt2.setVisibility(View.VISIBLE);
        tt3.setVisibility(View.VISIBLE);
        gl.setVisibility(View.VISIBLE);
        ii.setVisibility(View.INVISIBLE);

        new CountDownTimer(61000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tt1.setText(String.valueOf(millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {
                float value = (score / noofqu) * 100;
                if (value > 97.00) {
                    tt4.setText("Einstein!" + " " + Float.toString(value) + "%");
                } else if (value < 96.00 && value > 80.00) {
                    tt4.setText("Great" + " " + Float.toString(value) + "%");

                } else if (value > 60.00 && value < 80.00) {
                    tt4.setText("Average" + " " + Float.toString(value) + "%");
                } else if (value < 60.00 && value >= 0.00) {

                    tt4.setText("Worst!" + " " + Float.toString(value) + "%");
                }
                tt1.setText("0s");
                bt2.setVisibility(View.VISIBLE);
                gl.setVisibility(View.INVISIBLE);
                ii.setVisibility(View.VISIBLE);


            }
        }.start();
    }


    public void Playagain(View view) {
        bt2.setVisibility(View.INVISIBLE);
        ii.setVisibility(View.INVISIBLE);
        tt1.setText("0s");
        tt4.setText("");
        gl.setVisibility(View.VISIBLE);
        tt3.setText(Float.toString(score = 0) + "/" + Float.toString(noofqu = 0));
        questions();
        new CountDownTimer(61000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tt1.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {
                float value = (score / noofqu) * 100;
                if (value > 97.01) {
                    tt4.setText("Amazing Score!" + " " + Float.toString(value) + "%");
                } else if (value < 96.01 && value > 80.01) {
                    tt4.setText("Great Score!" + " " + Float.toString(value) + "%");

                } else if (value > 60.01 && value < 80.01) {
                    tt4.setText("Good Score!" + " " + Float.toString(value) + "%");
                } else if (value < 60.00 && value >= 0.00) {
                    tt4.setText("Tryagain,score" + " " + Float.toString(value) + "%");
                }
                tt1.setText("0s");
                bt2.setVisibility(View.VISIBLE);
                gl.setVisibility(View.INVISIBLE);
                ii.setVisibility(View.VISIBLE);
            }
        }.start();


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
    }
}
