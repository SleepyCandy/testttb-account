package com.ttbtest.saleandservice.account.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomSalesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FindRankSaleByCustomerDTO> findMaxSaleByCustomer(int year) {
        String sql = "with maxOfSaleByCustomer as (\n" +
                "select    \n" +
                "\tc.customer_id,\n" +
                "    c.firstname,\n" +
                "    c.lastname, \n" +
                "    max(s.sale_amount) as amount \n" +
                "from customer c\n" +
                "left join sales s on s.customer_id = c.customer_id\n" +
                "where YEAR(sale_date) = :year \n" +
                "GROUP BY c.customer_id, c.firstname, c.lastname\n" +
                ") \n" +
                "select  \n" +
                "\trow_number() over (order by m.amount desc ) as rank,\n" +
                "\tm.customer_id,\n" +
                "\tm.firstname,\n" +
                "\tm.lastname,\n" +
                "\tm.amount\n" +
                "from maxOfSaleByCustomer m\n" +
                "\n";
        return entityManager.createNativeQuery(sql, FindRankSaleByCustomerDTO.class)
                .setParameter("year", year)
                .getResultList();
    }

}
