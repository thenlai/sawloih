package org.vahcuengh.sawloih.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Word")
public class WordItem {

    @Id @Property(nameInDb = "_id")
    private Long id;
    private String word;
    private String desc;

    @Generated(hash = 1382998129)
    public WordItem() {
    }

    @Generated(hash = 1112093310)
    public WordItem(Long id, String word, String desc) {
        this.id = id;
        this.word = word;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
