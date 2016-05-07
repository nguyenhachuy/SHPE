package study.shpe.com.shpestudy;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Dickface on 5/6/2016.
 */
public class TimeSettings implements TimePickerDialog.OnTimeSetListener {
    Context context;
    static MainActivity mainActivity;

    public TimeSettings(Context context){
        this.context = context;

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        System.out.println(hourOfDay + " " + minute);

        mainActivity.resetTime(hourOfDay, minute);
    }
}
