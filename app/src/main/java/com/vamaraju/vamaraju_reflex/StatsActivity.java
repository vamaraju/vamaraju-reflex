/**
 Copyright 2015 Raghav Vamaraju

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.vamaraju.vamaraju_reflex;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        initializeGameStats();
        showReflexStats();
        showBuzzerStats();
    }

    @Override
    public void onResume() {
        super.onResume();

        reflexGameStats.updateStats();
        showReflexStats();
        showBuzzerStats();
    }

    private void showReflexStats() {
        setTextView(R.id.text_dyn_min_all, reflexGameStats.getMinAll());
        setTextView(R.id.text_dyn_max_all, reflexGameStats.getMaxAll());
        setTextView(R.id.text_dyn_mean_all, reflexGameStats.getMeanAll());
        setTextView(R.id.text_dyn_median_all, reflexGameStats.getMedianAll());

        setTextView(R.id.text_dyn_min_10, reflexGameStats.getMin10());
        setTextView(R.id.text_dyn_max_10, reflexGameStats.getMax10());
        setTextView(R.id.text_dyn_mean_10, reflexGameStats.getMean10());
        setTextView(R.id.text_dyn_median_10, reflexGameStats.getMedian10());

        setTextView(R.id.text_dyn_min_100, reflexGameStats.getMin100());
        setTextView(R.id.text_dyn_max_100, reflexGameStats.getMax100());
        setTextView(R.id.text_dyn_mean_100, reflexGameStats.getMean100());
        setTextView(R.id.text_dyn_median_100, reflexGameStats.getMedian100());
    }

    private void showBuzzerStats() {
        setTextView(R.id.text_dyn_player1_buzzer, buzzerGameStats.stringify(0));
        setTextView(R.id.text_dyn_player2_buzzer, buzzerGameStats.stringify(1));
        setTextView(R.id.text_dyn_player3_buzzer, buzzerGameStats.stringify(2));
        setTextView(R.id.text_dyn_player4_buzzer, buzzerGameStats.stringify(3));
    }

    private void setTextView(int id, Double value) {
        TextView tv = (TextView) findViewById(id);
        if (value == null) {tv.setText("No Stats!");}
        else {tv.setText(formatString("%.2f", value) + " ms");}
    }

    private void setTextView(int id, String value) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(value);
    }

    private String formatString(String format, Double value) {
        return String.format(format, value);
    }

    public void onclickClearStats(View v) {
        reflexGameStats.clearStats();
        buzzerGameStats.clearScores();
        writeObjectToFile(reflexGameStats.getStats(), REFLEX_FILE);
        writeObjectToFile(buzzerGameStats.getStats(), BUZZER_FILE);
        showReflexStats();
        showBuzzerStats();
    }

    public void onclickEmailStats(View v) {
        // Code from: http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application, 2015-10-05
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_SUBJECT, "Stats from Reflex App");
        email.putExtra(Intent.EXTRA_TEXT, reflexGameStats.getPrintout() + buzzerGameStats.getPrintout());
        email.setData(Uri.parse("mailto:vamaraju@ualberta.ca"));
        email.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(email);
    }
}
