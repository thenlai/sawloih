package org.vahcuengh.sawloih;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

import org.vahcuengh.sawloih.model.dao.WordItem;

public class SearchResultAdapter
        extends RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder> {

    private final LayoutInflater inflater;
    private Context mContext;
    private static List<WordItem> list = null;

    public SearchResultAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void update(List<WordItem> data) {
        list = data;
    }
    public void append(List<WordItem> data) {
        list.addAll(data);
    }
    public void prepend(List<WordItem> data) {}

    public List<WordItem> getItems() {
        return list;
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchResultViewHolder(inflater.inflate(R.layout.item_search_result, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder, int position) {
        final WordItem c = list.get(position);

        if(c.getWord()!=null && c.getWord().length()>0) {
            holder.word.setText(c.getWord());
        }
        holder.desc.setText(c.getDesc());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public WordItem get(int position) {
        return list.get(position);
    }


    public static class SearchResultViewHolder
            extends RecyclerView.ViewHolder{
        @BindView(R.id.sri__word) TextView word;
        @BindView(R.id.sri__desc) TextView desc;

        SearchResultViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
