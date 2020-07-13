package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Address {
    @Column(length = 20)
    private String city;

    @Column(length = 40)
    private String street;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    public String getFullAddress() {
        return String.format("%s %s (%s)", this.city, this.street, this.zipCode);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            final Address other = (Address) obj;
            return Objects.equals(this.city, other.city) &&
                    Objects.equals(this.street, other.street) &&
                    Objects.equals(this.zipCode, other.zipCode);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.street, this.zipCode);
    }
}
