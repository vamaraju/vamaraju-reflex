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
import android.os.Bundle;
import android.view.View;

public class BuzzerStartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_start);
    }

    public void onclick2PlayerBuzzerStart(View v) {
        Intent buzzer2PlayerActivity = new Intent(BuzzerStartActivity.this, Buzzer2PlayerActivity.class);
        startActivity(buzzer2PlayerActivity);
    }

    public void onclick3PlayerBuzzerStart(View v) {
        Intent buzzer3PlayerActivity = new Intent(BuzzerStartActivity.this, Buzzer3PlayerActivity.class);
        startActivity(buzzer3PlayerActivity);
    }

    public void onclick4PlayerBuzzerStart(View v) {
        Intent buzzer4PlayerActivity = new Intent(BuzzerStartActivity.this, Buzzer4PlayerActivity.class);
        startActivity(buzzer4PlayerActivity);
    }
}
