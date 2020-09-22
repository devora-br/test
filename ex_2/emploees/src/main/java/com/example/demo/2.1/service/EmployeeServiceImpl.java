package com.example.demo.service;


import javax.sql.DataSource;

import com.example.demo.model.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends RouteBuilder {
    @Autowired
    DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void configure() throws Exception {

        from("direct:insert").process(new Processor() {
            public void   process(Exchange xchg) throws Exception {
                Employee employee = xchg.getIn().getBody(Employee.class);
                String query = "INSERT INTO employee(empId,empName)values('" + employee.getEmpId() + "','"
                        + employee.getEmpName() + "')";
                xchg.getIn().setBody(query);
            }
        }).to("jdbc:dataSource");

    }
}
