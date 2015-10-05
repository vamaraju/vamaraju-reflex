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

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickReflexStart(View v) {
        Intent reflexActivity = new Intent(MainActivity.this, ReflexesActivity.class);
        startActivity(reflexActivity);
    }

    public void onclickBuzzerStart(View v) {
        Intent buzzerActivity = new Intent(MainActivity.this, BuzzerStartActivity.class);
        startActivity(buzzerActivity);
    }

    public void onclickStatsStart(View v) {
        Intent statsActivity = new Intent(MainActivity.this, StatsActivity.class);
        startActivity(statsActivity);
    }

}
