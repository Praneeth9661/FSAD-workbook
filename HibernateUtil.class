package com.klu.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class ProductApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE (Insert)
        Product p1 = new Product("Laptop", "Electronics", 55000, 10);
        Product p2 = new Product("Mouse", "Accessories", 800, 50);

        session.save(p1);
        session.save(p2);

        // READ (Fetch by ID)
        Product product = session.get(Product.class, 1);
        if (product != null) {
            System.out.println("Product Name: " + product.getName());
        }

        // UPDATE
        if (product != null) {
            product.setPrice(52000);
            session.update(product);
        }

        // DELETE
        Product deleteProduct = session.get(Product.class, 2);
        if (deleteProduct != null) {
            session.delete(deleteProduct);
        }

        tx.commit();
        session.close();

        System.out.println("CRUD operations completed successfully.");
    }
}
