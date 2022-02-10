/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.util.ArrayList;
import libraryFunctions.*;
import Objects.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 *
 * @author ny200852
 */
public class availableSeats extends javax.swing.JFrame {

    public static eventStringObject seat;
    public static eventStringObject tempSeat;

    public void getEvent() {
        tempSeat = AvailableStands.returnEvent();
    }
    private ArrayList<Integer> seatsSelected;
    private ArrayList<Integer> takenSeats;

    public availableSeats() {
        initComponents();
        getEvent();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rowField = new javax.swing.JTextField();
        columnField = new javax.swing.JTextField();
        bookAnother = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setText("Select up to 6 seats");

        backButton.setText("back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Enter seat you would like to book:");

        jLabel8.setText("Row");

        jLabel9.setText("Column");

        bookAnother.setText("Book another");
        bookAnother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookAnotherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(confirmButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rowField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(columnField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(bookAnother)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rowField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(bookAnother))
                .addGap(188, 188, 188))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        AvailableStands stand = new AvailableStands();
                stand.setVisible(true);
                this.dispose();
        
    }//GEN-LAST:event_backButtonActionPerformed
    private void getTakenSeats() {
        ArrayList<String> seatIDs = new ArrayList<>();
        databaseOrders.getTakenSeatID(tempSeat.getEvent(), seatIDs);

        for (int i = 0; i <= seatIDs.size(); i++) {
            int row = databaseOrders.getSeatRow(tempSeat.getStand(), tempSeat.getEvent());
            int column = databaseOrders.getSeatColumn(tempSeat.getStand(), tempSeat.getEvent());
            int seat = row * column;
            takenSeats.add(seat);
        }
    }
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        boolean valid = validSeats();
        String rowString = new String(rowField.getText());
        String columnString = new String(columnField.getText());
        int rowEntered = Integer.parseInt(rowString);
        int columnEntered = Integer.parseInt(columnString);
        int seatInt = rowEntered*columnEntered;
        seatsSelected.add(seatInt);
        if (valid) {
            for (int i = 0; i < seatsSelected.size(); i++) {

                int row = seatsSelected.get(i) / 8;
                int column = seatsSelected.get(i) % 8;
                String eventID = databaseOrders.getEventID(tempSeat.getEvent());
                String rowStr = Integer.toString(row);
                String columnStr = Integer.toString(column);
                String seatID = String.join(tempSeat.getStand(), rowStr, columnStr);
                double addedPrice = ticketPriceGenerator.rowPrice(row);
                seatDetailsObject seat = new seatDetailsObject(seatID, row, column, tempSeat.getEvent(), addedPrice);
                databaseOrders.addSeat(seat);
                double price = ticketPriceGenerator.ticketPrice(row, tempSeat.getEvent(), tempSeat.getStand());
                String ticketID = generateId.uniqueId();
                String bookingID = generateId.uniqueId();
                String userID = databaseOrders.returnUserID();
                Objects.ticketDetailsObject ticket = new ticketDetailsObject(ticketID, eventID, seatID, tempSeat.getType(), price);
                databaseOrders.addTicket(ticket);
                LocalDate dateBooked = LocalDate.now();

                Objects.bookingDetailsObject booking = new bookingDetailsObject(bookingID, userID, ticketID, dateBooked);
                databaseOrders.addBooking(booking);

            }
            ticketPaymentGUI pay = new ticketPaymentGUI();

            pay.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_confirmButtonActionPerformed
    private boolean validSeats() {
        getTakenSeats();
        seatsSelected.sort(Comparator.naturalOrder());
        boolean valid = true;
        ArrayList<String> userTickets = new ArrayList<>();
        ArrayList<String> ticketsBookedForEvent = new ArrayList<>();
        userTickets = databaseOrders.getTicketID();
        for (int i = 0; i < userTickets.size(); i++) {
            ticketsBookedForEvent.add(databaseOrders.getTicketIDChosen(userTickets.get(i),tempSeat.getStand()));
        }
        if (seatsSelected.size() > 6 - ticketsBookedForEvent.size()) {
            valid = false;
            System.out.println("You have booked too many seats for this event");
        }
        valid = isSeatTaken(takenSeats, valid);
        int count = 0;
        for (int i = 0; i < seatsSelected.size(); i++) {

            if (seatsSelected.get(i) % 8 == 1) {
                valid = checkRight(takenSeats, i, valid);
            } else if (seatsSelected.get(i) % 8 == 0) {
                valid = checkLeft(takenSeats, i, valid);
            } else if (seatsSelected.get(i) % 8 == 2) {
                valid = checkRight(takenSeats, i, valid);
                boolean check = false;
                for (int j = 0; j < takenSeats.size(); j++) {
                    if (takenSeats.get(j) == seatsSelected.get(i) - 1) {
                        check = true;
                        
                    }
                }
                if (check == false) {
                    valid = false;
                }
            } else if (seatsSelected.get(i) % 8 == 7) {
                valid = checkLeft(takenSeats, i, valid);
                boolean check = false;
                for (int j = 0; j < takenSeats.size(); j++) {
                    if (takenSeats.get(j) == seatsSelected.get(i) + 1) {
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    valid = false;
                }
            } else {
                valid = checkLeft(takenSeats, i, valid);
                valid = checkRight(takenSeats, i, valid);
            }
            if(valid){
                takenSeats.add(seatsSelected.get(i));
                count = count + 1;
            }
        }
        if(valid = false){
            System.out.println("You cannot leave a single seat when booking");
            for (int i = 0; i <= count; i++) {
                int top = takenSeats.size();
                takenSeats.remove(top);
            }
            
            
        }
        return valid;
    }

    

    public boolean isSeatTaken(ArrayList<Integer> takenSeats, boolean valid) {
        for (int i = 0; i < seatsSelected.size(); i++) {
            for (int j = 0; j < takenSeats.size(); j++) {
                if (seatsSelected.get(i) == takenSeats.get(j)) {
                    valid = false;
                    return valid;
                }
            }
        }
        return valid;
    }

    private boolean checkRight(ArrayList<Integer> takenSeats, int i, boolean valid) {

        boolean seatOne = false;
        boolean seatTwo = true;
        for (int j = 0; j < takenSeats.size(); j++) {
            if (takenSeats.get(j) == seatsSelected.get(i) + 1) {
                seatOne = true;
            }
            if (takenSeats.get(j) == seatsSelected.get(i) + 2) {
                seatTwo = true;
            }
        }
        if (seatOne == false && seatTwo == true) {
            valid = false;
        }
        return valid;
    }

    private boolean checkLeft(ArrayList<Integer> takenSeats, int i, boolean valid) {

        boolean seatOne = false;
        boolean seatTwo = true;
        for (int j = 0; j < takenSeats.size(); j++) {
            if (takenSeats.get(j) == seatsSelected.get(i) - 1) {
                seatOne = true;
            }
            if (takenSeats.get(j) == seatsSelected.get(i) - 2) {
                seatTwo = true;
            }
        }
        if (seatOne == false && seatTwo == true) {
            valid = false;
        }
        return valid;
    }


    private void bookAnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookAnotherActionPerformed
        String rowStr = new String(rowField.getText());
        String columnStr = new String(rowField.getText());
        int row = Integer.parseInt(rowStr);
        int column = Integer.parseInt(columnStr);
        int seat = row*column;
        seatsSelected.add(seat);
        rowField.setText("");
        rowField.setText("");
    }//GEN-LAST:event_bookAnotherActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(availableSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(availableSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(availableSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(availableSeats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new availableSeats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton bookAnother;
    private javax.swing.JTextField columnField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField rowField;
    // End of variables declaration//GEN-END:variables
}
