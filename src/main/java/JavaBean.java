import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;


    public  List<ConfigItems> getItems (String nameparam) {
        Query query;
        String temp ="";
        temp = temp + nameparam;
        if(temp.length()>0) {
            query = entityManager.createQuery("select entity from ConfigItems entity");
        }
        else {
            query = entityManager.createQuery("select entity from ConfigItems entity where entity.ConfigItemName like '%'||:SearchSt||'%'");
            query.setParameter("SearchSt", nameparam);
        }

        return query.getResultList();
    }


}
