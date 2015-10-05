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
public class ReflexGameStats {

    private ArrayList<Long> stats = new ArrayList<Long>();
    private Double minAll = null;
    private Double maxAll = null;
    private Double meanAll = null;
    private Double medianAll = null;
    private Double min10 = null;
    private Double max10 = null;
    private Double mean10 = null;
    private Double median10 = null;
    private Double min100 = null;
    private Double max100 = null;
    private Double mean100 = null;
    private Double median100 = null;

    public ReflexGameStats() {

    }

    public ReflexGameStats(ArrayList<Long> stats) {
        this.setStats(stats);
    }

    public void setStats(ArrayList<Long> stats) {
        this.stats = stats;
        this.updateStats();
    }

    public ArrayList<Long> getStats() {
        return this.stats;
    }

    public void addStat(Long stat) {
        this.stats.add(0, stat);
    }

    public void updateStats() {
        int size = this.stats.size();
        if (size == 0) {return;}

        this.setAllStats();

        if (size <= 10) {
            this.set10Stats(this.stats);
            this.set100Stats(this.stats);
        }
        else {
            this.set10Stats(StatsHelper.slice(this.stats, 0, 10));
            if (size > 100) {this.set100Stats(StatsHelper.slice(this.stats, 0, 100));}
            else {this.set100Stats(this.stats);}
        }
    }

    public void clearStats() {
        this.stats.clear();

        this.minAll = null;
        this.maxAll = null;
        this.meanAll = null;
        this.medianAll = null;
        this.min10 = null;
        this.max10 = null;
        this.mean10 = null;
        this.median10 = null;
        this.min100 = null;
        this.max100 = null;
        this.mean100 = null;
        this.median100 = null;
    }

    public Double getMinAll() {
        return minAll;
    }

    public Double getMaxAll() {
        return maxAll;
    }

    public Double getMeanAll() {
        return meanAll;
    }

    public Double getMedianAll() {
        return medianAll;
    }

    public Double getMin10() {
        return min10;
    }

    public Double getMax10() {
        return max10;
    }

    public Double getMean10() {
        return mean10;
    }

    public Double getMedian10() {
        return median10;
    }

    public Double getMin100() {
        return min100;
    }

    public Double getMax100() {
        return max100;
    }

    public Double getMean100() {
        return mean100;
    }

    public Double getMedian100() {
        return median100;
    }

    private void setMinAll(Double minAll) {
        this.minAll = minAll;
    }

    private void setMaxAll(Double maxAll) {
        this.maxAll = maxAll;
    }

    private void setMeanAll(Double meanAll) {
        this.meanAll = meanAll;
    }

    private void setMedianAll(Double medianAll) {
        this.medianAll = medianAll;
    }

    private void setMin10(Double min10) {
        this.min10 = min10;
    }

    private void setMax10(Double max10) {
        this.max10 = max10;
    }

    private void setMean10(Double mean10) {
        this.mean10 = mean10;
    }

    private void setMedian10(Double median10) {
        this.median10 = median10;
    }

    private void setMin100(Double min100) {
        this.min100 = min100;
    }

    private void setMax100(Double max100) {
        this.max100 = max100;
    }

    private void setMean100(Double mean100) {
        this.mean100 = mean100;
    }

    private void setMedian100(Double median100) {
        this.median100 = median100;
    }

    private void setAllStats() {
        this.setMinAll(StatsHelper.min(this.stats));
        this.setMaxAll(StatsHelper.max(this.stats));
        this.setMeanAll(StatsHelper.mean(this.stats));
        this.setMedianAll(StatsHelper.median(this.stats));
    }

    private void set10Stats(ArrayList<Long> stats10) {
        this.setMin10(StatsHelper.min(stats10));
        this.setMax10(StatsHelper.max(stats10));
        this.setMean10(StatsHelper.mean(stats10));
        this.setMedian10(StatsHelper.median(stats10));
    }

    private void set100Stats(ArrayList<Long> stats100) {
        this.setMin100(StatsHelper.min(stats100));
        this.setMax100(StatsHelper.max(stats100));
        this.setMean100(StatsHelper.mean(stats100));
        this.setMedian100(StatsHelper.median(stats100));
    }

    public String getPrintout() {
        String printout = "";
        printout += printoutHelper("Min of All Reactions: %s\n", this.minAll);
        printout += printoutHelper("Max of All Reactions: %s\n", this.maxAll);
        printout += printoutHelper("Mean of All Reactions: %s\n", this.meanAll);
        printout += printoutHelper("Median of All Reactions: %s\n", this.medianAll);

        printout += printoutHelper("Min of Previous 10 Reactions: %s\n", this.min10);
        printout += printoutHelper("Max of Previous 10 Reactions: %s\n", this.max10);
        printout += printoutHelper("Mean of Previous 10 Reactions: %s\n", this.mean10);
        printout += printoutHelper("Median of Previous 10 Reactions: %s\n", this.median10);

        printout += printoutHelper("Min of Previous 100 Reactions: %s\n", this.min100);
        printout += printoutHelper("Max of Previous 100 Reactions: %s\n", this.max100);
        printout += printoutHelper("Mean of Previous 100 Reactions: %s\n", this.mean100);
        printout += printoutHelper("Median of Previous 100 Reactions: %s\n", this.median100);

        return printout;
    }

    private String printoutHelper(String message, Double substitution) {
        if (substitution == null) {return String.format(message, "No Stats!");}
        else {return String.format(message, substitution);}
    }
}
