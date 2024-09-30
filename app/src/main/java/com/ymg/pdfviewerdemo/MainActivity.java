package com.ymg.pdfviewerdemo;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ymg.pdf.viewer.PDFView;
import com.ymg.pdf.viewer.listener.OnLoadCompleteListener;
import com.ymg.pdf.viewer.listener.OnPageChangeListener;
import com.ymg.pdf.viewer.listener.OnPageErrorListener;
import com.ymg.pdf.viewer.scroll.DefaultScrollHandle;
import com.ymg.pdf.viewer.util.FitPolicy;


public class MainActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {

    PDFView pdfView;
    private int pageNumber = 0;
    private String sampleFile = "sample.pdf"; // The name of your PDF file in the assets folder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pdfView = findViewById(R.id.pdfView);
        loadPDF();

    }

    private void loadPDF() {
        pdfView.fromAsset(sampleFile)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .pageFitPolicy(FitPolicy.BOTH)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        // Handle page change
    }

    @Override
    public void loadComplete(int nbPages) {
        // Handle when the PDF is fully loaded
    }

    @Override
    public void onPageError(int page, Throwable t) {
        // Handle page error
    }
}