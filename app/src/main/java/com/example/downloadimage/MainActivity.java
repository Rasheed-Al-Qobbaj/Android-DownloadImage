package com.example.downloadimage;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        image = findViewById(R.id.image);
        progressBar = findViewById(R.id.progressBar);
        new DownloadImageTask(image, progressBar).execute("https://scontent.fjrs27-1.fna.fbcdn.net/v/t39.30808-6/466345544_1127508562711796_4216975130353205691_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=833d8c&_nc_ohc=JN2lRtaHuBoQ7kNvgFnonjR&_nc_zt=23&_nc_ht=scontent.fjrs27-1.fna&_nc_gid=AbtoO2hBWDOMY-sm59PUg_e&oh=00_AYC4o-TvwrP2GxsnC8OlP4U_W3p_7beoORe_breLFqsWKg&oe=6750D03A");
    }
}