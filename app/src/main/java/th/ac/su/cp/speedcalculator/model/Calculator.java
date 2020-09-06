package th.ac.su.cp.speedcalculator.model;

import android.app.AlertDialog;
import android.app.Dialog;

import androidx.appcompat.widget.AlertDialogLayout;

import th.ac.su.cp.speedcalculator.MainActivity;

public class Calculator {
    private double s;
    private double t;
    private double v;

    public Calculator(double s, double t) {
        this.s = s;
        this.t = t;
    }

    public double calculate() {
        v = s / t;
        v = v / (5 / 18.0);
        return v;
    }
}
