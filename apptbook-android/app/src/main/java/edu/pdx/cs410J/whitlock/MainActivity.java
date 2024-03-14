package edu.pdx.cs410J.whitlock;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.pdx.cs410J.whitlock.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int GET_SUM = 42;
    private ArrayAdapter<Integer> sums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView sumsList = findViewById(R.id.sums);

        sums = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        readSumsFromFile();
        sumsList.setAdapter(sums);

    }

    private void readSumsFromFile() {
        File sumsFile = getSumsFile();

        try (BufferedReader br = new BufferedReader(new FileReader(sumsFile))) {
            for (String sumLine = br.readLine(); sumLine != null; sumLine = br.readLine()) {
                int sum = Integer.parseInt(sumLine);
                this.sums.add(sum);
            }

        } catch (IOException e) {
            Toast.makeText(this, "While reading sums: " + e, Toast.LENGTH_LONG).show();
        }

    }

    public void displayCalculator(View view) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivityForResult(intent, GET_SUM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_SUM) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    int sum = data.getIntExtra(CalculatorActivity.SUM_VALUE, 0);
                    this.sums.add(sum);
                    writeSumsToFile();

                    Appointment appointment = new Appointment("Got sum " + sum);
                    Toast.makeText(this, appointment.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void writeSumsToFile() {
        File sumsFile = getSumsFile();

        try (PrintWriter pw = new PrintWriter(new FileWriter(sumsFile), true)) {
            for (int i = 0; i < this.sums.getCount(); i++) {
                pw.println(this.sums.getItem(i));
            }

        } catch (IOException e) {
            Toast.makeText(this, "While writing sums: " + e, Toast.LENGTH_LONG).show();
        }
    }

    @NonNull
    private File getSumsFile() {
        File dataDirectory = this.getDataDir();
        File sumsFile = new File(dataDirectory, "sums.txt");
        return sumsFile;
    }
}