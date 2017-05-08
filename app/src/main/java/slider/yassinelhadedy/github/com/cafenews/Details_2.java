package slider.yassinelhadedy.github.com.cafenews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Details_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_2);

        ImageView imageView=(ImageView)findViewById(R.id.imageview);

        int pic=getIntent().getIntExtra("key",2);
        Glide.with(this).load(pic).into(imageView);
    }
}
