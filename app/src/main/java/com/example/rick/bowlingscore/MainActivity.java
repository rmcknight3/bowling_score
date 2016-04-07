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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity{
    //Variables
    public int arrayClear = 0;
    public int[] frameViewArray = new int[]{R.id.frameTotal1,R.id.frameTotal2,R.id.frameTotal3,R.id.frameTotal4,R.id.frameTotal5,R.id.frameTotal6,R.id.frameTotal7,R.id.frameTotal8,R.id.frameTotal9,R.id.frameTotal10};
    public int frameIndex = 0;

    public int textArrayIndex = 0;
    public int[] textViewArray = new int[]{R.id.roll1,R.id.roll2,R.id.roll3,R.id.roll4,R.id.roll5,R.id.roll6,R.id.roll7,R.id.roll8,R.id.roll9,R.id.roll10,R.id.roll11,R.id.roll12,R.id.roll13,R.id.roll14,R.id.roll15,R.id.roll16,R.id.roll17,R.id.roll18,R.id.roll19,R.id.roll20};

    public int[] inputArray = new int[20];
    public int inputIndex = 0;

    public int[] totalsArray = new int[10];
    public int totalsIndex = 0;

    public Toast toast;
    public Toast toast2;
    public EditText mEditText;
    public TextView rollTextView;
    public TextView frameTotalView;

    //running total of total game score
    public int gameScoreInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE); //lock display to landscape view
        textViewArray = new int[]{R.id.roll1,R.id.roll2,R.id.roll3,R.id.roll4,R.id.roll5,R.id.roll6,R.id.roll7,R.id.roll8,R.id.roll9,R.id.roll10,R.id.roll11,R.id.roll12,R.id.roll13,R.id.roll14,R.id.roll15,R.id.roll16,R.id.roll17,R.id.roll18,R.id.roll19,R.id.roll20};
        mEditText = (EditText) findViewById(R.id.editText);//refers to edit text/user input on the activity layout
    }

    public void clickTheButton(View view) {
        rollTextView = (TextView) findViewById(textViewArray[textArrayIndex]);
        frameTotalView = (TextView) findViewById(frameViewArray[frameIndex]);

        //if blank, force an entry (TextUtils.isEmpty)
        if (TextUtils.isEmpty(mEditText.getText().toString())){
            toast = Toast.makeText(getApplicationContext(), "Enter something!", Toast.LENGTH_SHORT);
            toast.show();
        } else{//continues normally
            if(inputIndex<=18){//input index starts as 0
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

                gameScoreInt = (totalsArray[0] + totalsArray[1] + totalsArray[2] + totalsArray[3] + totalsArray[4] + totalsArray[5] + totalsArray[6] + totalsArray[7] + totalsArray[8] + totalsArray[9]);

                rollTextView.setText(mEditText.getText().toString());
                frameTotalView.setText(Integer.toString(gameScoreInt));//put current total in current frame

//                mEditText.getText().clear();//clear editText input
                mEditText.setText("4");
                textArrayIndex++;//move to next space
                inputIndex++;
                totalsIndex++;

                //add more for each frame
                if(inputIndex == 2 || inputIndex == 4|| inputIndex == 6|| inputIndex == 8|| inputIndex == 10|| inputIndex == 12|| inputIndex == 14|| inputIndex == 16|| inputIndex == 18)
                {frameIndex++;}//next Frame

            }
            else if (inputIndex==19){
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

                gameScoreInt = (totalsArray[0] + totalsArray[1] + totalsArray[2] + totalsArray[3] + totalsArray[4] + totalsArray[5] + totalsArray[6] + totalsArray[7] + totalsArray[8] + totalsArray[9]);

                rollTextView.setText(mEditText.getText().toString());
                frameTotalView.setText(Integer.toString(gameScoreInt));//put current total in current frame

                toast = Toast.makeText(getApplicationContext(), "No more frames", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void clearButton(View view){
        //clear text views

            TextView rollTextView1 = (TextView) findViewById(R.id.roll1);
            TextView rollTextView2 = (TextView) findViewById(R.id.roll2);
            TextView rollTextView3 = (TextView) findViewById(R.id.roll3);
            TextView rollTextView4 = (TextView) findViewById(R.id.roll4);
            TextView rollTextView5 = (TextView) findViewById(R.id.roll5);
            TextView rollTextView6 = (TextView) findViewById(R.id.roll6);
            TextView rollTextView7 = (TextView) findViewById(R.id.roll7);
            TextView rollTextView8 = (TextView) findViewById(R.id.roll8);
            TextView rollTextView9 = (TextView) findViewById(R.id.roll9);
            TextView rollTextView10 = (TextView) findViewById(R.id.roll10);
            TextView rollTextView11 = (TextView) findViewById(R.id.roll11);
            TextView rollTextView12 = (TextView) findViewById(R.id.roll12);
            TextView rollTextView13 = (TextView) findViewById(R.id.roll13);
            TextView rollTextView14 = (TextView) findViewById(R.id.roll14);
            TextView rollTextView15 = (TextView) findViewById(R.id.roll15);
            TextView rollTextView16 = (TextView) findViewById(R.id.roll16);
            TextView rollTextView17 = (TextView) findViewById(R.id.roll17);
            TextView rollTextView18 = (TextView) findViewById(R.id.roll18);
            TextView rollTextView19 = (TextView) findViewById(R.id.roll19);
            TextView rollTextView20 = (TextView) findViewById(R.id.roll20);

            rollTextView1.setText(null);
            rollTextView2.setText(null);
            rollTextView3.setText(null);
            rollTextView4.setText(null);
            rollTextView5.setText(null);
            rollTextView6.setText(null);
            rollTextView7.setText(null);
            rollTextView8.setText(null);
            rollTextView9.setText(null);
            rollTextView10.setText(null);
            rollTextView11.setText(null);
            rollTextView12.setText(null);
            rollTextView13.setText(null);
            rollTextView14.setText(null);
            rollTextView15.setText(null);
            rollTextView16.setText(null);
            rollTextView17.setText(null);
            rollTextView18.setText(null);
            rollTextView19.setText(null);
            rollTextView20.setText(null);

        TextView frameView1 = (TextView) findViewById(R.id.frameTotal1);
        TextView frameView2 = (TextView) findViewById(R.id.frameTotal2);
        TextView frameView3 = (TextView) findViewById(R.id.frameTotal3);
        TextView frameView4 = (TextView) findViewById(R.id.frameTotal4);
        TextView frameView5 = (TextView) findViewById(R.id.frameTotal5);
        TextView frameView6 = (TextView) findViewById(R.id.frameTotal6);
        TextView frameView7 = (TextView) findViewById(R.id.frameTotal7);
        TextView frameView8 = (TextView) findViewById(R.id.frameTotal8);
        TextView frameView9 = (TextView) findViewById(R.id.frameTotal9);
        TextView frameView10 = (TextView) findViewById(R.id.frameTotal10);

        frameView1.setText(null);
        frameView2.setText(null);
        frameView3.setText(null);
        frameView4.setText(null);
        frameView5.setText(null);
        frameView6.setText(null);
        frameView7.setText(null);
        frameView8.setText(null);
        frameView9.setText(null);
        frameView10.setText(null);

        frameIndex = 0;
        textArrayIndex = 0;
        inputIndex = 0;
        totalsIndex = 0;
        gameScoreInt = 0;

        totalsArray = new int[10];
        Arrays.fill(totalsArray,0);
        Arrays.fill(inputArray, 0);

        toast = Toast.makeText(getApplicationContext(), "Clear the board! Value reset to " + inputArray[0], Toast.LENGTH_LONG);
        toast.show();
    }
}
