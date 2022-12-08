/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4.stackiterator;

/**
 *
 * @author kamaj
 */
public class ListItem {

        private	String data;
        private ListItem next;

        public ListItem() {
                next = null; // taitaa olla kyllä oletusarvo
        }
        public String getData() {
                return data;
        }
        public void setData(String aData) {
                data = aData;
        }

        public void setLink(ListItem aNext) {
                next = aNext;
        }
        public ListItem getLink() {
                return next;
        }
}
