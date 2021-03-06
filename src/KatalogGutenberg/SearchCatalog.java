/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KatalogGutenberg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfian Hidayat
 */
public class SearchCatalog extends javax.swing.JFrame {

    String cari;
    String author = null, title = null, no = null, prop = null;
    String line, kata = "";
    boolean mulai = false;
    BinarySearchTree bst = new BinarySearchTree();
    ArrayList<Node> as = new ArrayList<Node>();
    ButtonGroup bg = new ButtonGroup();

    public SearchCatalog() {
        Random r = new Random();
        ArrayList<Node> at = new ArrayList<Node>();
        this.setTitle("Catalog Gutenberg Project");

        Exit = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String file = ("GUTINDEX.ALL");
        try {
            if (file != null) {
                BufferedReader br = new BufferedReader(new FileReader(new File(file)));
                //Read File Line By Line
                while ((line = br.readLine()) != null) {
                    if (line.equals("TITLE and AUTHOR                                                     ETEXT NO.")) {
                        mulai = true;
                        continue;
                    }
                    if (line.contains("                                GUTINDEX.")) {
                        mulai = false;
                    }
                    if (line.equalsIgnoreCase("<==End of GUTINDEX.ALL==>")) {
                        break;
                    }
                    if (mulai) {
                        if (line.length() != 0) {
                            String[] arr1;
                            if (line.contains(".xxx]")) {
                                arr1 = line.split("\\[.*\\]");
                                if (arr1.length > 1) {
                                    if (arr1[1] != null) {
                                        no = arr1[1].trim();
                                    }
                                }
                            } else {
                                arr1 = line.split("[ ]{3,}");
                                if (arr1.length > 1) {
                                    if (arr1[1] != null) {
                                        no = arr1[1].trim();
                                    }
                                }
                            }

                            kata = kata + arr1[0];
                        } else {
                            if (kata.length() != 0) {
                                String proper = "";
                                String[] arr2 = kata.split("(,by |, by )");
                                if (arr2.length > 1) {
                                    int index = arr2[1].indexOf("[");
                                    if (index >= 0) {
                                        author = arr2[1].substring(0, index).trim();
                                        String properties;
                                        properties = arr2[1].substring(index).replaceAll("\\]", "");
                                        String[] tmp = properties.split("\\[");
                                        for (int i = 1; i < tmp.length; i++) {
                                            proper += "--- " + tmp[i] + "\n";
                                        }
                                    } else {
                                        author = arr2[1].trim();
                                    }
                                }
                                title = arr2[0].trim();
                                Node tmp = new Node(author, title, no, proper);
                                at.add(tmp);
                                as.add(tmp);
                            }
                            kata = "";
                            author = "";
                            title = "";
                            no = "";
                        }
                    }
                }
            }
        } catch (Exception e) {
            for (StackTraceElement i : e.getStackTrace()) {
                System.err.println(i.toString());
            }
            JOptionPane.showMessageDialog(Output, "Error: " + e);
        }
        while (!at.isEmpty()) {
            int rand = new Random().nextInt(at.size());
            bst.insertNumber(at.remove(rand));
        }
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        searchButton = new javax.swing.JButton();
        Output = new java.awt.List();
        Exit = new javax.swing.JButton();
        InputText = new java.awt.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        image = new javax.swing.JLabel();
        radioAuthor = new javax.swing.JRadioButton();
        radioTitle = new javax.swing.JRadioButton();
        Created = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Frame"); // NOI18N

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        InputText.setName("Input");
        InputText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTextActionPerformed(evt);
            }
        });

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/KatalogGutenberg/projectgutenberg.jpg"))); // NOI18N

        radioAuthor.setText("Author");
        radioAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAuthorActionPerformed(evt);
            }
        });

        radioTitle.setText("Title");
        radioTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                radioTitleMousePressed(evt);
            }
        });
        radioTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTitleActionPerformed(evt);
            }
        });

        Created.setText("by Group 8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Output, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Created)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(image)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioAuthor)
                            .addComponent(radioTitle))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InputText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Exit)
                    .addComponent(Created))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        JFrame frame = new JFrame();
        int answer = JOptionPane.showConfirmDialog(frame, "Are you sure ?");
        if (answer == JOptionPane.YES_OPTION) {
            System.exit(0);
        }


    }//GEN-LAST:event_ExitActionPerformed

    private void InputTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTextActionPerformed

        if (radioAuthor.isSelected()) {
            searchAction(radioAuthor.getText());
        } else if (radioTitle.isSelected()) {
            searchAction(radioTitle.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Select Search by ?");
        }
    }//GEN-LAST:event_InputTextActionPerformed

    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_OutputActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (radioAuthor.isSelected()) {
            searchAction(radioAuthor.getText());
        } else if (radioTitle.isSelected()) {
            searchAction(radioTitle.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Select Search by ?");
        }
}//GEN-LAST:event_searchButtonActionPerformed

    private void radioTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTitleActionPerformed

    }//GEN-LAST:event_radioTitleActionPerformed

    private void radioAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAuthorActionPerformed
        groupButton();
    }//GEN-LAST:event_radioAuthorActionPerformed

    private void radioTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioTitleMousePressed
        groupButton();
    }//GEN-LAST:event_radioTitleMousePressed

    public String Output() {
        return cari;
    }

    private void groupButton() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAuthor);
        bg.add(radioTitle);
    }

    void searchAction(String select) {

        Output.clear();
        cari = InputText.getText();
        Node tmp;
        Boolean isFound = false;
        for (int i = 0; i < as.size(); i++) {
            if (as.get(i).author.toLowerCase().contains(cari.toLowerCase()) && select.equalsIgnoreCase("author")) {
                tmp = bst.searchNumber(as.get(i).no);
                isFound = true;
                String[] arr = bst.displayNode(tmp).split("--");
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != null) {
                        Output.add(arr[j]);
                    }
                }
                Output.add("");
            }
            if (as.get(i).title.toLowerCase().contains(cari.toLowerCase()) && select.equalsIgnoreCase("title")) {
                tmp = bst.searchNumber(as.get(i).no);
                isFound = true;
                String[] arr = bst.displayNode(tmp).split("--");
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] != null) {
                        Output.add(arr[j]);
                    }
                }
                Output.add("");
            }
        }
        if (!isFound) {
            JOptionPane.showMessageDialog(null, "Catalog Not Found");
        }
        JOptionPane.showMessageDialog(null, "Search Finished");
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SearchCatalog().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Created;
    private javax.swing.JButton Exit;
    private java.awt.TextField InputText;
    private java.awt.List Output;
    private javax.swing.JLabel image;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioAuthor;
    private javax.swing.JRadioButton radioTitle;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
