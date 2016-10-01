package org.vahcuengh.sawloih.model.dao;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class WordItemDBModel {
    private Context context;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private WordItemDao wordItemDao;
    private static WordItemDBModel instance;

    private WordItemDBModel(Context context) {
        this.context = context;
        daoMaster = new DaoMaster(WordItemDBManager.getInstance(context).getReadibleDatabase());
        daoSession = daoMaster.newSession();
        wordItemDao = daoSession.getWordItemDao();
    }

    public static WordItemDBModel getInstance(Context context) {
        if(instance == null) {
            synchronized (WordItemDBModel.class) {
                instance = new WordItemDBModel(context);
            }
        }
        return instance;
    }

    public WordItem queryWord(String keyword){
        QueryBuilder<WordItem> qb = wordItemDao.queryBuilder();
        qb.where(WordItemDao.Properties.Word.eq(keyword));
        if(qb.list() == null || qb.list().size() == 0){
            return null;
        }
        return qb.list().get(0);
    }

    public List<WordItem> queryAll(String keyword){
        QueryBuilder<WordItem> qb = wordItemDao.queryBuilder();
        return qb
                .where(WordItemDao.Properties.Word.eq(keyword))
                //.orderDesc(WordItemDao.Properties.Word)
                .list();
    }


}
