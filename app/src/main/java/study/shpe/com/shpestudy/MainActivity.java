package study.shpe.com.shpestudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.firebase.client.Firebase;
class Event {

    String name;
    String place;
    String capacity;
    int day, month;
    int hour, minute;



    public Event(String nameText, String placeText, String capacityText,int day, int month,
                 int hour, int minute){
        this.name = nameText;
        this.place = placeText;
        this.capacity = capacityText;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;

    }
}


public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText place;
    EditText capacity;
    DatePicker date;
    Button submit;
    TimePicker time;
    String nameText;
    String placeText;
    String capacityText;
    int day, month;
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        setContentView(R.layout.createform);

        name = (EditText) findViewById(R.id.Name);
        date = (DatePicker) findViewById(R.id.DateTime);
        place = (EditText) findViewById(R.id.Place);
        capacity = (EditText) findViewById(R.id.Capacity);
        submit = (Button) findViewById(R.id.Submit);
        time = (TimePicker) findViewById(R.id.timePicker);


    }
    public void showTimePickerDialog(View v) {

        TimeSettings.mainActivity = this;

        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void clicked(View v) {
        nameText = name.getText().toString();

        placeText = place.getText().toString();

        capacityText = capacity.getText().toString();

        day = date.getDayOfMonth();
        month = date.getMonth();

        hour = time.getHour();
        minute = time.getMinute();

        Firebase ref = new Firebase("https://shpestudy.firebaseio.com/");
        Firebase eventRef = ref.child("shpestudy").child(nameText);
        System.out.println(nameText + " " + placeText + " " + capacityText + " " + day + " " + month + " " + hour + " " + minute);
        Event event = new Event(nameText, placeText, capacityText, day, month, hour, minute);
        eventRef.setValue(event);
    }

    void resetTime(int hours, int minutes) {
        time.setHour(hours);
        time.setMinute(minutes);
    }
}