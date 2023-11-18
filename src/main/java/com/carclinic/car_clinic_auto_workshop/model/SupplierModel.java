package com.carclinic.car_clinic_auto_workshop.model;

import com.carclinic.car_clinic_auto_workshop.db.DbConnection;
import com.carclinic.car_clinic_auto_workshop.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.carclinic.car_clinic_auto_workshop.constant.Query.*;

public class SupplierModel {

    public boolean saveSupplier(SupplierDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_SUPPLIER);

        statement.setString(1, dto.getSupId());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getAddress());
        statement.setString(4, dto.getTelNum());

        return statement.executeUpdate() > 0;
    }

    public boolean updateSupplier(SupplierDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_SUPPLIER);

        statement.setString(1, dto.getName());
        statement.setString(2, dto.getAddress());
        statement.setString(3, dto.getTelNum());
        statement.setString(4, dto.getSupId());

        return statement.executeUpdate() > 0;
    }

    public boolean deleteSupplier(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_SUPPLIER);

        statement.setString(1, id);

        return statement.executeUpdate() > 0;
    }

    public SupplierDTO searchSupplier(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection ();
        PreparedStatement statement = connection.prepareStatement(SEARCH_SUPPLIER);

        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        SupplierDTO dto = null;

        if(resultSet.next()) {
            String sup_id = resultSet.getString(1);
            String sup_name = resultSet.getString(2);
            String sup_address = resultSet.getString(3);
            String sup_tel = resultSet.getString(4);

            dto = new SupplierDTO(sup_id, sup_name, sup_address, sup_tel);
        }
        return dto;
    }

    public List<SupplierDTO> getAllSupplier() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(LOAD_ALL_SUPPLIER);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<SupplierDTO> SupplierDtoList = new ArrayList<>();

        while(resultSet.next()) {
            SupplierDtoList.add(
                    new SupplierDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return SupplierDtoList;
    }




}
