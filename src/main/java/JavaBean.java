import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;


    public  List<ConfigItems> getItems () {
        Query query = entityManager.createQuery("select entity from ConfigItems entity");

        return query.getResultList();
    }


}
