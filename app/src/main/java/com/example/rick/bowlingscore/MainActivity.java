package com.example.rick.bowlingscore;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.GetChars;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;//imported
import android.widget.TextView;//imported
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    //Variables
    public int[] frameViewArray = new int[]{R.id.frameTotal1,R.id.frameTotal2,R.id.frameTotal3,R.id.frameTotal4,R.id.frameTotal5,R.id.frameTotal6,R.id.frameTotal7,R.id.frameTotal8,R.id.frameTotal8,R.id.frameTotal10};
    public int frameIndex = 0;

    public int textArrayIndex = 0;
    public int[] textViewArray = new int[]{R.id.roll1,R.id.roll2,R.id.roll3,R.id.roll4,R.id.roll5,R.id.roll6,R.id.roll7,R.id.roll8,R.id.roll9,R.id.roll10,R.id.roll11,R.id.roll12,R.id.roll13,R.id.roll14,R.id.roll15,R.id.roll16,R.id.roll17,R.id.roll18,R.id.roll19,R.id.roll20};

    public int[] inputArray = new int[20];
    public int inputIndex = 0;

    public int[] totalsArray = new int[10];
    public int totalsIndex = 0;

    public Toast toast;
    public EditText mEditText;
    public TextView rollTextView;
    public TextView frameTotalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); //lock display to landscape view
        textViewArray = new int[]{R.id.roll1,R.id.roll2,R.id.roll3,R.id.roll4,R.id.roll5,R.id.roll6,R.id.roll7,R.id.roll8,R.id.roll9,R.id.roll10,R.id.roll11,R.id.roll12,R.id.roll13,R.id.roll14,R.id.roll15,R.id.roll16,R.id.roll17,R.id.roll18,R.id.roll19,R.id.roll20};
        mEditText = (EditText) findViewById(R.id.editText);//refers to edit text/user input on the activity layout
    }

    public void clickTheButton(View view) {
        rollTextView = (TextView) findViewById(textViewArray[textArrayIndex]);//set all declarations within button
        frameTotalView = (TextView) findViewById(frameViewArray[frameIndex]);

        //if blank, force an entry (TextUtils.isEmpty)
        if (TextUtils.isEmpty(mEditText.getText().toString())){
            toast = Toast.makeText(getApplicationContext(), "Enter something!", Toast.LENGTH_SHORT);
            toast.show();
        }else{//continues normally
            if(textArrayIndex<textViewArray.length){//input index starts as 0
                inputArray[inputIndex] = Integer.parseInt(mEditText.getText().toString());
                totalsArray[0] = inputArray[0] + inputArray[1];
                totalsArray[1] = inputArray[2] + inputArray[3];
                totalsArray[2] = inputArray[4] + inputArray[5];
                totalsArray[3] = inputArray[6] + inputArray[7];
                totalsArray[4] = inputArray[8] + inputArray[9];
                totalsArray[5] = inputArray[10] + inputArray[11];
                totalsArray[6] = inputArray[12] + inputArray[13];
                totalsArray[7] = inputArray[14] + inputArray[15];
                totalsArray[8] = inputArray[16] + inputArray[17];
                totalsArray[9] = inputArray[18] + inputArray[19];

                rollTextView.setText(mEditText.getText().toString());
                frameTotalView.setText(Integer.toString(totalsArray[frameIndex]));//put score total in current frame

                mEditText.getText().clear();//clear editText input
                textArrayIndex++;//move to next space
                inputIndex++;
                totalsIndex++;
                if(inputIndex == 2 || inputIndex == 4|| inputIndex == 6|| inputIndex == 8|| inputIndex == 10){frameIndex++;}//next Frame
            }else{
                toast = Toast.makeText(getApplicationContext(), "No more frames", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
