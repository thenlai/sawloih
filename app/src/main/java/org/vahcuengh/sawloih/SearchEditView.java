package org.vahcuengh.sawloih;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class SearchEditView extends RelativeLayout {

    private Context mContext;
    @BindView(R.id.sev__input) EditText input;
    @BindView(R.id.sev__hisotry) ImageButton history;
    @BindView(R.id.sev__clear) ImageButton clear;

    public SearchEditView(Context context) {
        super(context);
        init(context);
    }

    public SearchEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SearchEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View selfView = inflater.inflate(R.layout.view_search_edit, this);
        ButterKnife.bind(selfView);
    }

    @OnClick(R.id.sev__clear)
    void onClearClick(View view) {
        input.setText("");
    }

    @OnTextChanged(R.id.sev__input)
    void onInputChanged(final CharSequence s, final int start, final int before, final int count) {
        if(input.getText().length()<=0) {
            hideClear();
        } else {
            showClear();
        }
    }

    public void setOnEditorActionListener(TextView.OnEditorActionListener l) {
        input.setOnEditorActionListener(l);
    }

    private void blur() {
        input.clearFocus();
    }

    private void hideClear() {
        clear.setVisibility(View.GONE);
    }

    private void showClear() {
        clear.setVisibility(View.VISIBLE);
    }

    private void showHistory() {
        history.setVisibility(View.VISIBLE);
    }

    private void hideHistory() {
        history.setVisibility(View.GONE);
    }

    public CharSequence getText() {
        return input.getText();
    }
}