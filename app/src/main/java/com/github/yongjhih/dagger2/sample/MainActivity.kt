package com.github.yongjhih.dagger2.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * TODO restructure packages:
 *
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
 *
 */
class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
