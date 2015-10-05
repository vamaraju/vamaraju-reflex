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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    protected ReflexGameStats reflexGameStats;
    protected BuzzerGameStats buzzerGameStats;
    protected final String REFLEX_FILE = "reflex.stats";
    protected final String BUZZER_FILE = "buzzer.stats";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void menuMainMenu(MenuItem menu) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void menuExitApp(MenuItem menu) {
        goToHomeScreen();
    }

    public void goToHomeScreen() {
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }

    protected void initializeGameStats() {
        Object oldReflexStats = loadObjectFromFile(REFLEX_FILE);
        Object oldBuzzerStats = loadObjectFromFile(BUZZER_FILE);

        if ((oldReflexStats == null) || (oldReflexStats.equals(new ArrayList<Long>()))) {
            reflexGameStats = new ReflexGameStats(new ArrayList<Long>());
        }
        else {
            reflexGameStats = new ReflexGameStats((ArrayList<Long>) oldReflexStats);
            reflexGameStats.updateStats();
        }

        if ((oldBuzzerStats == null) ||
            (oldBuzzerStats.equals(new ArrayList<Integer>(4))) ||
            (oldBuzzerStats.equals(new ArrayList<Integer>()))) {
            buzzerGameStats = new BuzzerGameStats(new ArrayList<Integer>(4));
        }
        else {
            buzzerGameStats = new BuzzerGameStats((ArrayList<Integer>) oldBuzzerStats);
        }
    }

    protected void writeObjectToFile(Object obj, String fileName){
        try {
            FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Object loadObjectFromFile(String fileName) {

        Object obj = null;
        File inputFile = getFileStreamPath(fileName);
        try {
            if (inputFile.exists()) {
                FileInputStream fis = openFileInput(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                obj = ois.readObject();
                ois.close();
                fis.close();
            }
            else {
                inputFile.createNewFile();
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}

