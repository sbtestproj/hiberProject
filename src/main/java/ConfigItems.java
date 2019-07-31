import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ConfigItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ConfigItemsId;
    private String ConfigItemName;
    private boolean Verifiedbyexpert;

    //*************************************************

    public boolean getVerif(){return Verifiedbyexpert;}
    public void setVerif(boolean Verif) {this.Verifiedbyexpert = Verif; }

    public long getId() { return ConfigItemsId; }

    public void setId(int id) { this.ConfigItemsId = id; }

    public String getName() { return ConfigItemName;}

    public void setName(String name) { this.ConfigItemName = name;}
}
