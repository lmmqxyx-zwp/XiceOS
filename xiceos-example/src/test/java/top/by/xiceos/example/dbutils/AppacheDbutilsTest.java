package top.by.xiceos.example.dbutils;

import org.junit.Test;
import top.by.xiceos.example.dbutils.entity.Customer;
import top.by.xiceos.example.dbutils.helper.DatabaseHelper;
import top.by.xiceos.example.dbutils.util.BeanMapUtil;

import java.util.List;
import java.util.UUID;

public class AppacheDbutilsTest {

    /**
     * 数据插入
     */
    @Test
    public void insertEntityTest() {
        Customer customer = new Customer();

        customer.setName(UUID.randomUUID().toString());
        customer.setContact(UUID.randomUUID().toString());
        customer.setTelephone(UUID.randomUUID().toString());
        customer.setEmail(UUID.randomUUID().toString());
        customer.setRemark(UUID.randomUUID().toString());

        try {
            boolean b = DatabaseHelper.insertEntity(Customer.class, BeanMapUtil.objectToMap(customer));
            if (b) {
                System.out.println("insert success");
            } else {
                System.out.println("insert filed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据查询
     */
    @Test
    public void queryEntityListTest() {
        List<Customer> list = DatabaseHelper.queryEntityList(Customer.class, "select * from t_customer");

        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

}
