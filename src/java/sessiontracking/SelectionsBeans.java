/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessiontracking;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author AbhinavTyagi
 */

@ManagedBean(name="selectionsBean")
@SessionScoped
public class SelectionsBeans implements Serializable
{
    // map of topics to book titles
    private static final HashMap< String, String > booksMap =
       new HashMap< String, String >();
        private static final HashMap< String, Integer > priceMap =
       new HashMap< String, Integer >();
       int totalPrice; 
    // intialize booksMap
    static
    {
        booksMap.put("java", "Java How to Program");
        priceMap.put("Java How to Program",320);
        
        booksMap.put("cpp", "C++ How to Program");
        priceMap.put("C++ How to Program", 200);
       
        booksMap.put("iphone", "iphone for Programmers: An App-Driven Approach");
        priceMap.put("iphone for Programmers: An App-Driven Approach",500);
     
        booksMap.put("android", "Android for Programmers: An App-Driven Approach");
        priceMap.put("Android for Programmers: An App-Driven Approach", 180);
    } // end static initalizer block
    
    // stores individual user's selections
    private Set< String > selections = new TreeSet< String >();
   
    private String selection; // stores the current selection
    
    // return number of selections
    public int getNumberOfSelections()
    {
        return selections.size();
    }

    // returns the currrent selection
    public String getSelection()
    {
        return selection;
    } // end method getSelection

    // store user's selection
    public void setSelection(String topic)
    {
        selection = booksMap.get(topic);
        selections.add(selection);
     //   selectionsPrice.add(priceMap.get(topic));
    } // end method setSelection

    // return the Set of selections
    public String[] getSelections()
    {
        return selections.toArray(new String[selections.size()]);
        } // end method getSelections

    public  HashMap<String, Integer> getPriceMap() {
        return priceMap;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

   
    
} // end class SelectionsBean

