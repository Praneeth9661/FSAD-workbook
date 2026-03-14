package com.klu.hql.demo;

import com.klu.hql.entity.Product;
import com.klu.hql.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Insert some sample products
            Product product1 = new Product("Laptop", 999.99, "Gaming laptop with high specs");
            Product product2 = new Product("Mouse", 25.50, "Wireless optical mouse");
            Product product3 = new Product("Keyboard", 75.00, "Mechanical keyboard with RGB");
            Product product4 = new Product("Monitor", 299.99, "24-inch 4K monitor");

            session.save(product1);
            session.save(product2);
            session.save(product3);
            session.save(product4);

            transaction.commit();

            // Begin a new transaction for querying
            transaction = session.beginTransaction();

            // HQL Query examples
            System.out.println("\n--- All Products ---");
            getAllProducts(session);

            System.out.println("\n--- Products with price > 50 ---");
            getProductsByPrice(session, 50.0);

            System.out.println("\n--- Products containing 'keyboard' ---");
            getProductsByName(session, "%keyboard%");

            System.out.println("\n--- Product count ---");
            getProductCount(session);

            System.out.println("\n--- Average price ---");
            getAveragePrice(session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            HibernateUtil.shutdown();
        }
    }

    // Method to get all products
    public static void getAllProducts(Session session) {
        String hql = "FROM Product";
        Query<Product> query = session.createQuery(hql, Product.class);
        List<Product> products = query.list();

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to get products by minimum price
    public static void getProductsByPrice(Session session, double minPrice) {
        String hql = "FROM Product WHERE price > :minPrice";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("minPrice", minPrice);
        List<Product> products = query.list();

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to get products by name pattern
    public static void getProductsByName(Session session, String namePattern) {
        String hql = "FROM Product WHERE lower(productName) LIKE lower(:pattern)";
        Query<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("pattern", namePattern);
        List<Product> products = query.list();

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to get product count
    public static void getProductCount(Session session) {
        String hql = "SELECT COUNT(*) FROM Product";
        Query<Long> query = session.createQuery(hql, Long.class);
        Long count = query.uniqueResult();
        System.out.println("Total products: " + count);
    }

    // Method to get average price
    public static void getAveragePrice(Session session) {
        String hql = "SELECT AVG(price) FROM Product";
        Query<Double> query = session.createQuery(hql, Double.class);
        Double avgPrice = query.uniqueResult();
        System.out.println("Average price: " + avgPrice);
    }
}