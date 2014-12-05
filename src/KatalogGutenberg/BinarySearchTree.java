/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KatalogGutenberg;

/**
 *
 * @author Alfian Hidayat
 */
public class BinarySearchTree {

    Node rootNumber;

    public void insertNumber(Node input) {
        if (isEmptyNumber()) {
            rootNumber = input;
        } else {
            Node current = rootNumber;
            Node parent = null;
            boolean diKiri = true;
            while (current != null) {
                parent = current;
                if (current.no.compareToIgnoreCase(input.no) < 0) {
                    current = current.kanan;
                    diKiri = false;
                } else {
                    current = current.kiri;
                    diKiri = true;
                }
            }
            if (diKiri) {
                parent.kiri = input;
            } else {
                parent.kanan = input;
            }
        }
    }

    public boolean isEmptyNumber() {
        return (rootNumber == null);
    }

    public Node searchNumber(String key) {
        Node node = null;
        Node current = rootNumber;
        while (current != null) {
            if (current.no.equalsIgnoreCase(key)) {
                node = current;
                return node;
            } else {
                if (current.no.compareTo(key) < 0) {
                    current = current.kanan;
                } else {
                    current = current.kiri;
                }
            }
        }
        return node;
    }

    public String displayNode(Node tmp) {      // display ourself
        if (tmp != null) {
            String kata = "Author  : " + tmp.author + "--";
            kata += "Title      : " + tmp.title + "--";
            kata += "No        : " + tmp.no +"--";
            if (!tmp.prop.equals("")) {
                kata += "Properties : "+tmp.prop;
            }
            return kata;
        }
        return "";
    }
}
