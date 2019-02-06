package part2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade= CascadeType.ALL)
    private List<BuddyInfo> buddys;


    public AddressBook() {

        buddys = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddys.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {

        buddys.remove(buddy);
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public List<BuddyInfo> getBuddys() {

        return buddys;
    }

    public void setBuddys(List<BuddyInfo> buddys) {

        this.buddys = buddys;
    }

    @Override
    public String toString() {
        String returnme = "--------\n";
        for (BuddyInfo bud: buddys) {
            returnme += bud.toString() + "\n--------\n";
        }
        return returnme;
    }

    public static void main(String[] args) {
        AddressBook addBook = new AddressBook();
        BuddyInfo bud = new BuddyInfo("Blessing", "1234");
        BuddyInfo myBud = new BuddyInfo("Sean", "5678");

        addBook.addBuddy(bud);
        addBook.addBuddy(myBud);
        System.out.println(addBook.toString());
    }
}
