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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class Buzzer4PlayerActivity extends BaseActivity {

    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer4_player);

        initializeGameStats();

        buzzerGameStats.setNumPlayers(3);
        buzzerGameStats.resetPlayer1Score();
        buzzerGameStats.resetPlayer2Score();
        buzzerGameStats.resetPlayer3Score();
        buzzerGameStats.resetPlayer4Score();

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Buzzer");
        adb.setCancelable(true);
        adb.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
    }

    public void onclickPlayer1Buzzer(View v) {
        buzzerGameStats.incrementPlayer1Score();
        writeObjectToFile(buzzerGameStats.getStats(), BUZZER_FILE);
        adb.setMessage("Player 1 buzzed first!");
        adb.create().show();
    }

    public void onclickPlayer2Buzzer(View v) {
        buzzerGameStats.incrementPlayer2Score();
        writeObjectToFile(buzzerGameStats.getStats(), BUZZER_FILE);
        adb.setMessage("Player 2 buzzed first!");
        adb.create().show();
    }

    public void onclickPlayer3Buzzer(View v) {
        buzzerGameStats.incrementPlayer3Score();
        writeObjectToFile(buzzerGameStats.getStats(), BUZZER_FILE);
        adb.setMessage("Player 3 buzzed first!");
        adb.create().show();
    }

    public void onclickPlayer4Buzzer(View v) {
        buzzerGameStats.incrementPlayer4Score();
        writeObjectToFile(buzzerGameStats.getStats(), BUZZER_FILE);
        adb.setMessage("Player 4 buzzed first!");
        adb.create().show();
    }

}
