package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatViews generated by hbm2java
 */
@Entity
@Table(name="cat_views"
    ,catalog="lealtad_schema"
)
public class CatView  implements java.io.Serializable {


     private int catViewId;
     private String colors;
     private String logos;
     private String messages;

    public CatView() {
    }

	
    public CatView(int catViewId) {
        this.catViewId = catViewId;
    }
    public CatView(int catViewId, String colors, String logos, String messages) {
       this.catViewId = catViewId;
       this.colors = colors;
       this.logos = logos;
       this.messages = messages;
    }
   
     @Id 

    
    @Column(name="cat_view_id", unique=true, nullable=false)
    public int getCatViewId() {
        return this.catViewId;
    }
    
    public void setCatViewId(int catViewId) {
        this.catViewId = catViewId;
    }

    
    @Column(name="colors", length=100)
    public String getColors() {
        return this.colors;
    }
    
    public void setColors(String colors) {
        this.colors = colors;
    }

    
    @Column(name="logos", length=300)
    public String getLogos() {
        return this.logos;
    }
    
    public void setLogos(String logos) {
        this.logos = logos;
    }

    
    @Column(name="messages", length=300)
    public String getMessages() {
        return this.messages;
    }
    
    public void setMessages(String messages) {
        this.messages = messages;
    }


}


