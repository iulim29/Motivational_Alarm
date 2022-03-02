package com.example.alarmprototype_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextClock;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    TimePicker alarmTime;
    TextClock currentTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTime = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        final Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));


        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(currentTime.getText().toString().equals(AlarmTime())){
                    ringtone.play();
                }else{
                    ringtone.stop();
                }
            }


        }, 0, 1000);

    }

    public String AlarmTime(){

        Integer alarmHours = alarmTime.getCurrentHour();
        Integer alarmMinutes = alarmTime.getCurrentMinute();
        String stringAlarmMinutes;

        if(alarmMinutes <10){
            stringAlarmMinutes = "0";
            stringAlarmMinutes =  stringAlarmMinutes.concat(alarmMinutes.toString());
        }else{
            stringAlarmMinutes = alarmMinutes.toString();
        }

        String stringAlarmTime;

        if(alarmHours > 12){
            alarmHours = alarmHours - 12;
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat(" PM");
        } else {
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat(" AM");
        }
        return stringAlarmTime;
    }


}