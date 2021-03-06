package co.ceryle.fitgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FitGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (FitGridView) findViewById(R.id.gridView);
        gridView.setFitGridAdapter(new Adapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private int counter = 0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item) {
            switch (counter) {
                case 0:
                    item.setTitle("2*2");
                    changeSize(2, 2);
                    break;
                case 1:
                    item.setTitle("3*3");
                    changeSize(3, 3);
                    break;
                case 2:
                    item.setTitle("4*3");
                    changeSize(4, 3);
                    break;

            }
        }
        counter = ++counter % 3;

        return super.onOptionsItemSelected(item);
    }

    private void changeSize(int r, int c) {
        gridView.setRow(r);
        gridView.setColumn(c);
        gridView.update();
    }
}
