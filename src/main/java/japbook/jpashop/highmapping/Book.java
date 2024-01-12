package japbook.jpashop.highmapping;

import javax.persistence.Entity;

@Entity
public class Book extends ItemH{
    private String author;
    private String isbn;
}
