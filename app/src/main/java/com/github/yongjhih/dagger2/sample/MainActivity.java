package com.github.yongjhih.dagger2.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * TODO restructure packages:
 * <pre>
 * domain/
 * domain/GetRepos
 * domain/GetUsers
 * entity/Repo
 * entity/User
 * presenter/
 * presenter/SimpleReposPresenter
 * repository/
 * repository/GitHubRepository
 * inject/
 * inject/module/AppModule
 * inject/module/GitHubModule
 * inject/component/MainComponent
 * net/
 * net/GitHubService
 * ui/
 * ui/MainActivity
 * </pre>
 */
public class MainActivity
        extends RxAppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
