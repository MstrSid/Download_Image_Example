package by.kos.downloadimageexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutionException;

import by.kos.downloadimageexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String url = "https://m.media-amazon.com/images/I/61xJJMe4uDL._AC_SL1500_.jpg";
    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImageTask task = new DownloadImageTask();
                try {
                    bitmap = task.execute(url).get();
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
                if(bitmap != null){
                    binding.ivDownload.setImageBitmap(bitmap);
                }
            }
        });
    }
}