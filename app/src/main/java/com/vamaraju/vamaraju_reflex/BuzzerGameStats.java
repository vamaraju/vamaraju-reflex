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

import java.util.ArrayList;

/**
 * Created by RV on 10/2/2015.
 */
public class BuzzerGameStats {

    private ArrayList<Integer> stats = new ArrayList<Integer>(4);
    private Integer numPlayers;

    public BuzzerGameStats() {
        for (int i=0; i<4; i++) {
            this.stats.add(null);
        }
    }

    public BuzzerGameStats(int numPlayers) {
        for (int i=0; i < 4; i++) {
            this.stats.add(null);
        }

        this.setNumPlayers(numPlayers);
    }

    public BuzzerGameStats(ArrayList<Integer> stats) {
        this.setStats(stats);
    }

    public void setNumPlayers(Integer numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void setStats(ArrayList<Integer> stats) {
        this.stats = stats;
        this.numPlayers = this.stats.size();

        for (int i=this.stats.size(); i < 4; i++) {
            this.stats.add(null);
        }
    }

    public Integer getNumPlayers() {
        return this.numPlayers;
    }

    public ArrayList<Integer> getStats() {
        return this.stats;
    }

    public void clearScores() {
        this.stats.clear();
        this.setNumPlayers(null);

        this.setStats(new ArrayList<Integer>(4));
    }

    public void resetPlayer1Score() {
        this.stats.set(0, 0);
    }

    public void resetPlayer2Score() {
        this.stats.set(1, 0);
    }

    public void resetPlayer3Score() {
        this.stats.set(2, 0);
    }

    public void resetPlayer4Score() {
        this.stats.set(3, 0);
    }

    public void incrementPlayer1Score() {
        this.stats.set(0, this.stats.get(0)+1);
    }

    public void incrementPlayer2Score() {
        this.stats.set(1, this.stats.get(1)+1);
    }

    public void incrementPlayer3Score() {
        this.stats.set(2, this.stats.get(2)+1);
    }

    public void incrementPlayer4Score() {
        this.stats.set(3, this.stats.get(3)+1);
    }

    public Integer getPlayer1Score() {
        return this.stats.get(0);
    }

    public Integer getPlayer2Score() {
        return this.stats.get(1);
    }

    public Integer getPlayer3Score() {
        return this.stats.get(2);
    }

    public Integer getPlayer4Score() {
        return this.stats.get(3);
    }

    public Integer getScore(Integer index) {
        return this.stats.get(index);
    }

    public String stringify(Integer index) {
        if (this.stats.get(index) == null) {return "No Stats!";}
        else {return String.valueOf(this.stats.get(index));}
    }

    public String getPrintout() {
        String printout = "";
        for (Integer i=0; i<4; i++) {
            printout = printout + String.format("Player %s Buzzes: ", i+1) + stringify(i) + '\n';
        }
        return printout;
    }
}
