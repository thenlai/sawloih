package org.vahcuengh.sawloih;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

import org.vahcuengh.sawloih.model.dao.WordItem;
import org.vahcuengh.sawloih.model.dao.WordItemDBModel;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SawloihActivity extends AppCompatActivity
implements TextView.OnEditorActionListener {

    @BindView(R.id.sla__container) RecyclerView container;
    @BindView(R.id.sla__search) SearchEditView searchEdit;
    @BindView(R.id.sla__main) LinearLayout mainContainer;

    private WordItemDBModel dbModel;
    private SearchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sawloih);
        ButterKnife.bind(this);

        dbModel = WordItemDBModel.getInstance(this);
        Context context = getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        container.setLayoutManager(linearLayoutManager);
        container.setHasFixedSize(true);

        searchEdit.setOnEditorActionListener(this);

        // todo: search
        //doSearch("log");
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            String keyword = searchEdit.getText().toString();
            if(keyword.trim().isEmpty()) {
                // todo: alert user input is empty
                String message = "关键词不能为空";
                Snackbar.make(mainContainer, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                return true;
            } else {
                SawloihApp.hideKeyboard(this);
                doSearch(keyword);
                return true;
            }
        }
        return false;
    }

    void doSearch(String keyword) {
        List<WordItem> data = dbModel.queryAll(keyword);

        if(data.size()>=1) {
            adapter = new SearchResultAdapter(this);
            container.setAdapter(adapter);
            adapter.update(data);
        } else {
            Log.i("Search = ", "empty");
            String message = "该关键词无任何内容";
            Snackbar.make(mainContainer, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

    }
}
