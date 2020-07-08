package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(final String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpashop");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            final Album album = new Album();
            album.setName("testAlbum");
            album.setPrice(10000);
            album.setStockQuantity(10);
            album.setArtist("testArtist");
            album.setEtc("testEtc");
            entityManager.persist(album);

            final Book book = new Book();
            book.setName("testBook");
            book.setPrice(20000);
            book.setStockQuantity(20);
            book.setAuthor("testAuthor");
            book.setIsbn("testIsbn");
            entityManager.persist(book);

            final Movie movie = new Movie();
            movie.setName("testMovie");
            movie.setPrice(30000);
            movie.setStockQuantity(30);
            movie.setDirector("testDirector");
            movie.setActor("testActor");
            entityManager.persist(movie);

            entityTransaction.commit();
        } catch (final Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
