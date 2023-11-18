package com.carclinic.car_clinic_auto_workshop.model;

import com.carclinic.car_clinic_auto_workshop.db.DbConnection;
import com.carclinic.car_clinic_auto_workshop.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.carclinic.car_clinic_auto_workshop.constant.Query.*;

public class EmployeeModel {

    public boolean saveEmployee(EmployeeDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_EMPLOYEE);

        statement.setString(1, dto.getEmpId());
        statement.setString(2, dto.getName());
        statement.setString(3, dto.getAddress());
        statement.setString(4, dto.getTelNum());
        statement.setString(5, dto.getDesignation());

        return statement.executeUpdate() > 0;
    }

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);

        statement.setString(1, dto.getName());
        statement.setString(2, dto.getAddress());
        statement.setString(3, dto.getAddress());
        statement.setString(4, dto.getTelNum());
        statement.setString(5, dto.getEmpId());

        return statement.executeUpdate() > 0;
    }

    public boolean deleteEmployee(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);

        statement.setString(1, id);

        return statement.executeUpdate() > 0;
    }

    public EmployeeDTO searchEmployee(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection ();
        PreparedStatement statement = connection.prepareStatement(SEARCH_EMPLOYEE);

        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        EmployeeDTO dto = null;

        if(resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String emp_name = resultSet.getString(2);
            String emp_address = resultSet.getString(3);
            String emp_tel = resultSet.getString(4);
            String emp_designation = resultSet.getString(5);

            dto = new EmployeeDTO(emp_id, emp_name, emp_address, emp_tel, emp_designation);
        }
        return dto;
    }



    public List<EmployeeDTO> getAllEmployee() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(LOAD_ALL_EMPLOYEE);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<EmployeeDTO> EmployeeDtoList = new ArrayList<>();

        while(resultSet.next()) {
            EmployeeDtoList.add(
                    new EmployeeDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return EmployeeDtoList;
    }




}
