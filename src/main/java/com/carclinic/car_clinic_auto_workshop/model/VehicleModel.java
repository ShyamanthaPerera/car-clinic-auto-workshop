package com.carclinic.car_clinic_auto_workshop.model;

import com.carclinic.car_clinic_auto_workshop.db.DbConnection;
import com.carclinic.car_clinic_auto_workshop.dto.VehicleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.carclinic.car_clinic_auto_workshop.constant.Query.*;

public class VehicleModel {

    public boolean saveVehicle(VehicleDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_VEHICLE);

        statement.setString(1, dto.getVclId());
        statement.setString(2, dto.getCusId());
        statement.setString(3, dto.getVclCategory());
        statement.setString(4, dto.getManufacturer());
        statement.setString(5, dto.getModel());

        return statement.executeUpdate() > 0;
    }

    public boolean updateVehicle(VehicleDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_VEHICLE);

        statement.setString(1, dto.getCusId());
        statement.setString(2, dto.getVclCategory());
        statement.setString(3, dto.getManufacturer());
        statement.setString(4, dto.getModel());
        statement.setString(5, dto.getVclId());

        return statement.executeUpdate() > 0;
    }

    public boolean deleteVehicle(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLE);

        statement.setString(1, id);

        return statement.executeUpdate() > 0;
    }

    public VehicleDTO searchVehicle(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection ();
        PreparedStatement statement = connection.prepareStatement(SEARCH_VEHICLE);

        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        VehicleDTO dto = null;

        if(resultSet.next()) {
            String vcl_id = resultSet.getString(1);
            String cus_id = resultSet.getString(2);
            String category = resultSet.getString(3);
            String manufacturer = resultSet.getString(4);
            String model = resultSet.getString(5);

            dto = new VehicleDTO(vcl_id, cus_id, category, manufacturer, model);
        }
        return dto;
    }



    public List<VehicleDTO> getAllVehicle() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(LOAD_ALL_VEHICLE);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<VehicleDTO> VehicleDtoList = new ArrayList<>();

        while(resultSet.next()) {
            VehicleDtoList.add(
                    new VehicleDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return VehicleDtoList;
    }




}
