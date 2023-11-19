package com.carclinic.car_clinic_auto_workshop.constant;

public class Query {

    /**
     * Appointment
     */
    public static final String SAVE_APPOINTMENT = "INSERT INTO appointment VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_APPOINTMENT = "UPDATE appointment SET cus_id = ?, vcl_id = ?, slot_id = ?, date = ? time = ?, issue = ? WHERE appointment_id = ?";
    public static final String DELETE_APPOINTMENT = "DELETE FROM appointment WHERE appointment_id = ?";
    public static final String SEARCH_APPOINTMENT = "SELECT * FROM appointment WHERE appointment_id = ?";
    public static final String LOAD_ALL_APPOINTMENT =  "SELECT * FROM appointment";


    /**
     * Customer
     */
    public static final String SAVE_CUSTOMER = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_CUSTOMER = "UPDATE customer SET cus_name = ?, address = ?, email = ?, tel_num = ? WHERE cus_id = ?";
    public static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE cus_id = ?";
    public static final String SEARCH_CUSTOMER = "SELECT * FROM customer WHERE cus_id = ?";
    public static final String LOAD_ALL_CUSTOMER =  "SELECT * FROM customer";
    public static final String LOAD_ALL_CUSTOMER_BY_SEARCH_VAL =  "SELECT * FROM customer WHERE cus_id LIKE ? OR cus_name LIKE ? OR address LIKE ? OR email LIKE ? OR tel_num LIKE ?";


    /**
     * Employee_Appointment
     */
    public static final String SAVE_EMPLOYEE_APPOINTMENT = "INSERT INTO employee_appointment VALUES(?, ?)";
//    public static final String UPDATE_EMPLOYEE_APPOINTMENT = "UPDATE employee_appointment SET user = ?, name = ?, address = ?, tele = ? WHERE id = ?";
//    public static final String DELETE_EMPLOYEE_APPOINTMENT = "DELETE FROM employee_appointment WHERE id = ?";
//    public static final String SEARCH_EMPLOYEE_APPOINTMENT = "SELECT * FROM employee_appointment WHERE id = ?";
    public static final String LOAD_ALL_EMPLOYEE_APPOINTMENT =  "SELECT * FROM employee_appointment";


    /**
     * Employee
     */
    public static final String SAVE_EMPLOYEE = "INSERT INTO employee VALUES(?, ?, ?, ?, ?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, address = ?, tel_num = ?, designation = ? WHERE emp_id = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE emp_id = ?";
    public static final String SEARCH_EMPLOYEE = "SELECT * FROM employee WHERE emp_id = ?";
    public static final String LOAD_ALL_EMPLOYEE =  "SELECT * FROM employee";


    /**
     * Item
     */
    public static final String SAVE_ITEM = "INSERT INTO item VALUES(?, ?, ?, ?, ?)";
    public static final String UPDATE_ITEM = "UPDATE item SET model = ?, description = ?, unit_price = ?, qty_on_hand = ? WHERE item_id = ?";
    public static final String DELETE_ITEM = "DELETE FROM item WHERE item_id = ?";
    public static final String SEARCH_ITEM = "SELECT * FROM item WHERE item_id = ?";
    public static final String LOAD_ALL_ITEM =  "SELECT * FROM item";


    /**
     * Order_Detail
     */
    public static final String SAVE_ORDER_DETAIL = "INSERT INTO order_detail VALUES(?, ?)";
//    public static final String UPDATE_ORDER_DETAIL = "UPDATE order_detail SET address = ?, tele = ? WHERE id = ?";
//    public static final String DELETE_ORDER_DETAIL = "DELETE FROM order_detail WHERE id = ?";
//    public static final String SEARCH_ORDER_DETAIL = "SELECT * FROM order_detail WHERE id = ?";
    public static final String LOAD_ALL_ORDER_DETAIL =  "SELECT * FROM order_detail";


    /**
     * Order
     */
    public static final String SAVE_ORDER = "INSERT INTO order VALUES(?, ?, ?, ?, ?)";
    public static final String UPDATE_ORDER = "UPDATE order SET amount = ?, date = ?, time = ?, slot_id = ? WHERE ord_id = ?";
    public static final String DELETE_ORDER = "DELETE FROM order WHERE ord_id = ?";
    public static final String SEARCH_ORDER = "SELECT * FROM order WHERE ord_id = ?";
    public static final String LOAD_ALL_ORDER =  "SELECT * FROM order";


    /**
     * Slot
     */
    public static final String SAVE_SLOT = "INSERT INTO slot VALUES(?, ?, ?, ?)";
    public static final String UPDATE_SLOT = "UPDATE slot SET status = ?, space = ?, charging_outlet = ? WHERE slot_id = ?";
    public static final String DELETE_SLOT = "DELETE FROM slot WHERE slot_id = ?";
    public static final String SEARCH_SLOT = "SELECT * FROM slot WHERE slot_id = ?";
    public static final String LOAD_ALL_SLOT =  "SELECT * FROM slot";


    /**
     * Supplier
     */
    public static final String SAVE_SUPPLIER = "INSERT INTO supplier VALUES(?, ?, ?, ?)";
    public static final String UPDATE_SUPPLIER = "UPDATE supplier SET name = ?, address = ?, tel_num = ? WHERE sup_id = ?";
    public static final String DELETE_SUPPLIER = "DELETE FROM supplier WHERE sup_id = ?";
    public static final String SEARCH_SUPPLIER = "SELECT * FROM supplier WHERE sup_id = ?";
    public static final String LOAD_ALL_SUPPLIER =  "SELECT * FROM supplier";


    /**
     * Supplier_Order_Detail
     */
    public static final String SAVE_SUPPLIER_ORDER_DETAIL = "INSERT INTO s_order_detail VALUES(?, ?, ?)";
//    public static final String UPDATE_SUPPLIER_ORDER_DETAIL = "UPDATE s_order_detail SET user = ?, name = ?, address = ?, tele = ? WHERE id = ?";
//    public static final String DELETE_SUPPLIER_ORDER_DETAIL = "DELETE FROM s_order_detail WHERE id = ?";
//    public static final String SEARCH_SUPPLIER_ORDER_DETAIL = "SELECT * FROM s_order_detail WHERE id = ?";
      public static final String LOAD_ALL_SUPPLIER_ORDER_DETAIL = "SELECT * FROM s_order_detail";


    /**
     * User
     */
    public static final String SAVE_USER = "INSERT INTO user VALUES(?, ?, ?, ?, ?)";
    public static final String UPDATE_USER = "UPDATE user SET password = ?, name = ? WHERE user_name = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE user_name = ?";
    public static final String SEARCH_USER = "SELECT * FROM user WHERE user_name = ?";
    public static final String LOAD_ALL_USER = "SELECT * FROM user";


    /**
     * Vehicle
     */
    public static final String SAVE_VEHICLE = "INSERT INTO vehicle VALUES(?, ?, ?, ?, ?)";
    public static final String UPDATE_VEHICLE = "UPDATE vehicle SET cus_id = ?, vcl_ctgry = ?, manufacturer = ?, model = ? WHERE vcl_id = ?";
    public static final String DELETE_VEHICLE = "DELETE FROM vehicle WHERE vcl_id = ?";
    public static final String SEARCH_VEHICLE = "SELECT * FROM vehicle WHERE vcl_id = ?";
    public static final String LOAD_ALL_VEHICLE = "SELECT * FROM vehicle";

}
