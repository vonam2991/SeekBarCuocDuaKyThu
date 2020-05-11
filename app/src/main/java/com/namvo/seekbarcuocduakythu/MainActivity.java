package com.namvo.seekbarcuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mtxtDiem;
    CheckBox mcb1, mcb2, mcb3;
    SeekBar mseekBar1, mseekBar2, mseekBar3;
    ImageButton mbtnPlay;
    int msoDiem = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        setEnableCheckBox();
        mseekBar1.setEnabled(false);
        mseekBar2.setEnabled(false);
        mseekBar3.setEnabled(false);
        mtxtDiem.setText(msoDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int random1 = new Random().nextInt(5) + 1;
                int random2 = new Random().nextInt(5) + 1;
                int random3 = new Random().nextInt(5) + 1;
                mseekBar1.setProgress(mseekBar1.getProgress() + random1);
                mseekBar2.setProgress(mseekBar2.getProgress() + random2);
                mseekBar3.setProgress(mseekBar3.getProgress() + random3);

                if (mseekBar1.getProgress() >= 100) {
                    this.cancel();
                    setEnableCheckBox();
                    mbtnPlay.setVisibility(View.VISIBLE);
                    if (mcb1.isChecked()) {
                        msoDiem += 10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    } else {
                        msoDiem -= 5;
                        Toast.makeText(MainActivity.this, "You Close", Toast.LENGTH_SHORT).show();
                    }

                    mtxtDiem.setText(msoDiem + "");
                }
                if (mseekBar2.getProgress() >= 100) {
                    this.cancel();
                    setDisableCheckBox();
                    mbtnPlay.setVisibility(View.VISIBLE);
                    if (mcb2.isChecked()) {
                        msoDiem += 10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    } else {
                        msoDiem -= 5;
                        Toast.makeText(MainActivity.this, "You Close", Toast.LENGTH_SHORT).show();
                    }

                    mtxtDiem.setText(msoDiem + "");
                }
                if (mseekBar3.getProgress() >= 100) {
                    this.cancel();
                    setEnableCheckBox();
                    mbtnPlay.setVisibility(View.VISIBLE);

                    if (mcb3.isChecked()) {
                        msoDiem += 10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    } else {
                        msoDiem -= 5;
                        Toast.makeText(MainActivity.this, "You Close", Toast.LENGTH_SHORT).show();
                    }

                    mtxtDiem.setText(msoDiem + "");
                }
            }

            @Override
            public void onFinish() {
                if (mseekBar1.getProgress() <= 100) {
                    this.start();
                }
            }
        };

        mbtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mseekBar1.setProgress(0);
                mseekBar2.setProgress(0);
                mseekBar3.setProgress(0);
                if (mcb1.isChecked() || mcb2.isChecked() || mcb3.isChecked()) {
                    countDownTimer.start();
                    setDisableCheckBox();
                    mbtnPlay.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Ban chưa đặc cược", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mcb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcb1.setChecked(true);
                mcb2.setChecked(false);
                mcb3.setChecked(false);
            }
        });

        mcb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcb1.setChecked(false);
                mcb2.setChecked(true);
                mcb3.setChecked(false);
            }
        });

        mcb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcb1.setChecked(false);
                mcb2.setChecked(false);
                mcb3.setChecked(true);
            }
        });
    }

    private void setEnableCheckBox() {
        mcb1.setEnabled(true);
        mcb2.setEnabled(true);
        mcb3.setEnabled(true);
    }

    private void setDisableCheckBox() {
        mcb1.setEnabled(false);
        mcb2.setEnabled(false);
        mcb3.setEnabled(false);
    }

    private void AnhXa() {
        mtxtDiem = findViewById(R.id.textViewDiem);
        mcb1 = findViewById(R.id.checkbox1);
        mcb2 = findViewById(R.id.checkbox2);
        mcb3 = findViewById(R.id.checkbox3);
        mseekBar1 = findViewById(R.id.seekBar1);
        mseekBar2 = findViewById(R.id.seekBar2);
        mseekBar3 = findViewById(R.id.seekBar3);
        mbtnPlay = findViewById(R.id.btnPlay);
    }
}
