import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;





@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;


    public  List  getItems (String nameparam) {
        Query query;
        List a;
        String temp ="";
        temp = temp + nameparam;
        if(temp.length()>0) {

            query = entityManager.createQuery("select entity.config_item_name  from tbl_config_items entity where entity.config_item_name like '%'||:SearchSt||'%' or entity.config_item_description like '%'||:SearchSt||'%'");
            query.setParameter("SearchSt", nameparam);
            a = query.getResultList();

            for (int i = 0; i < a.size(); i++) {
                a.set(i, "name: " + a.get(i));
            }
        }
        else {
            query = entityManager.createQuery("select entity from config_items entity");
            a = query.getResultList();
        }






        return a;
    }




    public class resultClass{
        public long id;
        public String TypeName;
        public String  EntityName;
    }

    // ********************* Test Function *****************************


   public  List<tbl_entities> getEntities (String nameparam) {

        Query query;


        Query querytemp = entityManager.createQuery("" +
                "select" +
                " tbl_CITypes1.config_item_type_name," +
                "tbl_CITypes2.config_item_type_name," +
                " tbl_CItems.config_item_name " +


               // ",tbl_CSTypes.config_source_type_name" +
                " from" +
                " tbl_config_item_types  as tbl_CITypes1," +
                " tbl_config_item_types  as tbl_CITypes2," +
                " tbl_config_source_types as tbl_CSTypes," +
                " tbl_config_souces as tblCSources," +
                " tbl_config_items As tbl_CItems" +
                " where tbl_CSTypes.config_source_types_id = tblCSources.config_source_types_id and" +
                " tbl_CItems.config_sources_id = tblCSources.config_sources_id " +
                " and tbl_CITypes1.config_item_types_id = tbl_CItems.config_item_types_id " +
             //   " and tbl_CITypes2.config_item_types_id = tbl_CItems.config_item_types_id " +
             //    "and tbl_CITypes2.config_item_type_name = 'Section'" +
                "and tbl_CITypes1.config_item_type_name = 'Parameter'");

        Query query3 = entityManager.createQuery("select t1.config_items_id from tbl_config_items as t1 " +
                "where t1.config_items_id in (select e.config_items_id from tbl_config_items e) " );



        Query query2 = entityManager.createQuery("" +
                "select " +
                "c_items.config_item_name" +
                ", citype.config_item_type_name " +
                ", c_items.default_value" +
                ", c_items.config_item_description" +

               // ", c_items.config_item_description " +
               // ", mvers.version_number " +
                //", m.module_name " +
               // ", em_relations.entities_id " +
                ", ent.entity_name " +
                ", cs_types.config_source_type_name " +
                ", c_sources.config_source_name " +


                "from tbl_config_items as c_items" +
                " left join tbl_config_item_types as citype on c_items.config_item_types_id = citype.config_item_types_id" +
                " left join tbl_module_version as mvers on c_items.module_versions_id = mvers.module_versions_id" +
                " left join tbl_modules as m on m.modules_id = mvers.modules_id" +
                " left join tbl_entity_module_relations as em_relations on em_relations.modules_id= m.modules_id" +
                " left join tbl_entities as ent on ent.entities_id=em_relations.entities_id  " +
                " left join tbl_config_souces as c_sources on c_sources.config_sources_id = c_items.config_sources_id " +
                " left join tbl_config_source_types as cs_types on cs_types.config_source_types_id = c_sources.config_source_types_id" +
                " where ent.entity_types_id = 1" +
                " and (c_items.config_item_name like '%'||:SearchSt||'%' or c_items.config_item_description like '%'||:SearchSt||'%')" +
                "order by c_items.config_item_name");  //where ent.entity_types_id = 1
                 query2.setParameter("SearchSt", nameparam);

        //*************** this is working *************************
        Query queryWoring = entityManager.createQuery("select  " +
                "stypes.config_source_type_name," + // this is location
                "s.config_source_name, " +  // this is file name
                " c2.config_item_name," +  // this is section
                " c.config_item_name " +   // this is param
             //   " , h.child_config_items_id  " +
                " " +

                "from tbl_config_items_hierarchies as h " +

                "left join tbl_config_items as c on h.child_config_items_id = c.config_items_id " +

                "left join tbl_config_items as c2 on c2.config_items_id = h.parent_config_items_id " +

                "left join tbl_config_souces as s on s.config_sources_id = c.config_sources_id" +

                " left join tbl_config_source_types as stypes on s.config_source_types_id = stypes.config_source_types_id " +
                " "
        );


        long i = 2;
       tbl_entity_types  a = entityManager.find(tbl_entity_types.class,i);

    //  List<entities> ent = a.getEntity_Types_Id_List();


       List <tbl_entity_types> ArrResult = new ArrayList<tbl_entity_types>();

        ArrResult.add(a);
     //   String result = a.get();
        //  return result;

       // return ArrResult;
        //   return ent;
        return query2.getResultList();
    }

    boolean sing_new = false;
   void mylog(String my_message){
       try {
       if(sing_new)
       {
           File file = new File("c:/java_log.txt");
           file.delete();
           sing_new = true;
           PrintWriter writer = new PrintWriter("c:/java_log.txt", "UTF-8");
           writer.println(my_message);
           writer.close();
           return;
       }

            PrintWriter writer = new PrintWriter("c:/java_log.txt", "UTF-8");
       writer.println(my_message);
       writer.close();
        }catch (Exception ex) {;}
   }


}
