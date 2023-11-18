package com.carclinic.car_clinic_auto_workshop.model;

import com.carclinic.car_clinic_auto_workshop.db.DbConnection;
import com.carclinic.car_clinic_auto_workshop.dto.AppointmentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.carclinic.car_clinic_auto_workshop.constant.Query.*;

public class AppointmentModel {

    public boolean saveAppointment(AppointmentDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_APPOINTMENT);

        statement.setString(1, dto.getAppointmentId());
        statement.setString(2, dto.getCustomerId());
        statement.setString(3, dto.getVehicleId());
        statement.setString(4, dto.getSlotId());
        statement.setString(5, dto.getDate());
        statement.setString(6, dto.getTime());
        statement.setString(7, dto.getIssue());

        return statement.executeUpdate() > 0;
    }

    public boolean updateAppointment(AppointmentDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_APPOINTMENT);

        statement.setString(1, dto.getCustomerId());
        statement.setString(2, dto.getVehicleId());
        statement.setString(3, dto.getSlotId());
        statement.setString(4, dto.getDate());
        statement.setString(5, dto.getTime());
        statement.setString(6, dto.getIssue());
        statement.setString(7, dto.getAppointmentId());

        return statement.executeUpdate() > 0;
    }

    public boolean deleteAppointment(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_APPOINTMENT);

        statement.setString(1, id);

        return statement.executeUpdate() > 0;
    }

    public AppointmentDTO searchAppointment(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection ();
        PreparedStatement statement = connection.prepareStatement(SEARCH_APPOINTMENT);

        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        AppointmentDTO dto = null;

        if(resultSet.next()) {
            String ap_id = resultSet.getString(1);
            String cus_id = resultSet.getString(2);
            String vcl_id = resultSet.getString(3);
            String slot_id = resultSet.getString(4);
            String date = resultSet.getString(5);
            String time = resultSet.getString(6);
            String issue = resultSet.getString(7);

            dto = new AppointmentDTO(ap_id, cus_id, vcl_id, slot_id, date, time, issue);
        }
        return dto;
    }



    public List<AppointmentDTO> getAllAppointment() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(LOAD_ALL_APPOINTMENT);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<AppointmentDTO> AppointmentDtoList = new ArrayList<>();

        while(resultSet.next()) {
            AppointmentDtoList.add(
                    new AppointmentDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7)
                    )
            );
        }
        return AppointmentDtoList;
    }




}
