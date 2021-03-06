package com.jatasra.sarvex.notes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.jatasra.sarvex.notes.data.NoteDataSource;
import com.jatasra.sarvex.notes.data.NoteItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    private static final Logger log = LoggerFactory.getLogger(MainActivity.class);
    private NoteDataSource dataSource;
    List<NoteItem> notes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new NoteFragment()).commit();
		}

        dataSource = new NoteDataSource(this);

        refreshDisplay();
    }

    private void refreshDisplay() {
        notes = dataSource.findAll();

        ArrayAdapter<NoteItem> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
