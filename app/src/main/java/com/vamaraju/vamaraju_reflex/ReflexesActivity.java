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

import android.os.Handler;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReflexesActivity extends BaseActivity {

    private long startTime;
    private long endTime;
    private Button reflexButton;
    private Handler handlerButton = new Handler();
    private Handler handlerToast = new Handler();
    private Runnable reflexButtonRunnable;
    private Runnable toastCancelRunnable;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexes);

        initializeGameStats();

        reflexButton = (Button) findViewById(R.id.button_press);
        reflexButtonRunnable = new Runnable() {
            public void run() {
                reflexButton.setVisibility(View.VISIBLE);
                startTime = SystemClock.elapsedRealtime();
            }
        };

        toastCancelRunnable = new Runnable() {
            public void run() {
                toast.cancel();
            }
        };
    }

    public void onclickBackground(View v) {
        handlerButton.removeCallbacks(reflexButtonRunnable);
        handlerButton.postDelayed(reflexButtonRunnable, getRandomWait(10L, 2000L));
        toast = Toast.makeText(this, "Background Clicked - Timer Reset!", Toast.LENGTH_SHORT);
        toast.show();
        handlerToast.postDelayed(toastCancelRunnable, 200);
    }

    public void onclickStartButton(View v) {
        Button startButton = (Button)v;
        startButton.setVisibility(View.GONE);
        startGame();
    }

    public void onclickReflexButton(View v) {
        endTime = SystemClock.elapsedRealtime();
        Long elapsedTime = endTime-startTime;
        reflexGameStats.addStat(elapsedTime);
        writeObjectToFile(reflexGameStats.getStats(), REFLEX_FILE);

        toast = Toast.makeText(this, String.format("Latency: %s ms", elapsedTime), Toast.LENGTH_SHORT);
        toast.show();
        handlerToast.postDelayed(toastCancelRunnable, 200);

        reflexButton.setVisibility(View.INVISIBLE);

        handlerButton.postDelayed(reflexButtonRunnable, getRandomWait(10L, 2000L));
    }

    private void startGame() {
        handlerButton.postDelayed(reflexButtonRunnable, getRandomWait(10L, 2000L));
    }

    private Long getRandomWait(Long minWait, Long maxWait) {
        Long randomWait = (long)(10 + (Math.random()*(maxWait-minWait)));
        return randomWait;
    }



}
