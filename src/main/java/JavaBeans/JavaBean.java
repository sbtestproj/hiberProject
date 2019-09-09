package JavaBeans;

import Entities.tbl_module_version;
import Entities.tbl_entities;
import Entities.tbl_entity_types;
import Entities.tbl_modules;
import Entities.tbl_config_items;
import Entities.tbl_config_item_sections;
import Entities.tbl_config_item_possible_values;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;






@Stateless
public class JavaBean {

    @PersistenceContext(unitName = "myUnit")
    EntityManager entityManager;

    //********************************************** Saving data ***************************************************
    //***********************************************           ****************************************************
    //**************************************************************************************************************
    public String saveConfigItemPossibleValues(tbl_config_item_possible_values NewItem){
        entityManager.persist(NewItem); // saved
        entityManager.flush();


        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(NewItem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List saveConfigItemSections(tbl_config_item_sections newconfigitemsections){
        //  entityManager.persist(module);

        mylog(" Savings : ??????????????????????????");
//        tbl_modules temp = entityManager.find(tbl_modules.class, 1);
//поиск по имени версии модуля
        String que = "select e from tbl_config_item_sections e where  lower(e.config_item_section_name) = '"
                + newconfigitemsections.getConfig_item_section_name().toLowerCase() +"' "
                ; // + "and " + " e.config_item_section_description = " + newconfigitemsections.getConfig_item_section_description();
        mylog(que);
        Query query = entityManager.createQuery(que);

        List Out = query.getResultList();

        if (Out.isEmpty()) {
            mylog("no such values");
            entityManager.persist(newconfigitemsections); // saved
            que = "select e from tbl_config_item_sections e where  lower(e.config_item_section_name) = '" + newconfigitemsections.getConfig_item_section_name().toLowerCase() +"' "
                    ; // + "  and " + " e.config_item_section_description = " + newconfigitemsections.getConfig_item_section_description();
            mylog(que);
            query = entityManager.createQuery(que);
            Out = query.getResultList();
        }
        return Out;

    }


    public String saveConfigItem(tbl_config_items NewConfigItem){
        entityManager.persist(NewConfigItem); // saved
        entityManager.flush();


        String result = null;
        try {
            result = new ObjectMapper().writeValueAsString(NewConfigItem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List saveModuleVersions(tbl_module_version newmoduleversions){
        //  entityManager.persist(module);

        mylog(" Savings : ??????????????????????????");
//        tbl_modules temp = entityManager.find(tbl_modules.class, 1);
//поиск по имени версии модуля
        String que = "select e from tbl_module_version e where  lower(e.version_number) = '"
                + newmoduleversions.getVersion_number().toLowerCase() +"' and " +
        " e.modules_id = " + newmoduleversions.getModules_id();
        mylog(que);
        Query query = entityManager.createQuery(que);

        List Out = query.getResultList();

        if (Out.isEmpty()) {
            mylog("no such values");
            entityManager.persist(newmoduleversions); // saved
            que = "select e from tbl_module_version e where  lower(e.version_number) = '" + newmoduleversions.getVersion_number().toLowerCase() +"' and " +
                    " e.modules_id = " + newmoduleversions.getModules_id();
            mylog(que);
            query = entityManager.createQuery(que);
            Out = query.getResultList();
        }
        return Out;

    }


    public List saveModule(tbl_modules module){
      //  entityManager.persist(module);

        mylog(" Savings : ??????????????????????????");
//        tbl_modules temp = entityManager.find(tbl_modules.class, 1);
//поиск по имени модуля
        String que = "select e from tbl_modules e where  lower(e.module_name) = '" + module.getModule_name().toLowerCase() +"'";
        mylog(que);
        Query query = entityManager.createQuery(que);

        List Out = query.getResultList();
        if (Out.isEmpty()) {
            mylog("no such values");
            entityManager.persist(module);
            que = "select e from tbl_modules e where  lower(e.module_name) = '" + module.getModule_name().toLowerCase() +"'";
            mylog(que);
            query = entityManager.createQuery(que);
            Out = query.getResultList();
        }
        return Out;

    }




    //*********************************************   Getting DAta  ************************************************
    //**********************************************               *************************************************
    //**************************************************************************************************************
    public List getModules(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
         Query query = entityManager.createQuery("select e from tbl_modules e ");
          return  query.getResultList();
    }
        else {
            String que = "select e from tbl_modules e where  lower(e." + paramName +  ") = '" + value.toLowerCase() +"'";
            mylog(que);
              Query query = entityManager.createQuery(que);
            return query.getResultList();
        }
    }


    public List getModulesVersions(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
            Query query = entityManager.createQuery("select e from tbl_module_version e ");
            return  query.getResultList();
        }
        else {
           String que = "select e from tbl_module_version e where  e." + paramName + " = '"+value+"'";
             Query query = entityManager.createQuery(que);
              return query.getResultList();
        }
    }

    public List getConfigItemTypes(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
            Query query = entityManager.createQuery("select e from tbl_config_item_types e ");
            return  query.getResultList();
        }
        else {
            String que = "select e from tbl_config_item_types e where  e." + paramName + " = '"+value+"'";
            Query query = entityManager.createQuery(que);
            return query.getResultList();
        }
    }

    public List getDataTypes(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
            Query query = entityManager.createQuery("select e from tbl_data_types e ");
            return  query.getResultList();
        }
        else {
            String que = "select e from tbl_data_types e where  e." + paramName + " = '"+value+"'";
            Query query = entityManager.createQuery(que);
            return query.getResultList();
        }
    }

    public List getConfigItems(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
            Query query = entityManager.createQuery("select e from tbl_config_items e ");
            return  query.getResultList();
        }

        else {
            String que = "select e from tbl_config_items e where  e." + paramName + " = '"+value+"'";
            Query query = entityManager.createQuery(que);
            return query.getResultList();
        }
    }
    public List getConfigItemSections(String paramName, String value){
        if(paramName.length()<1 || value.length()<1 ) {
            Query query = entityManager.createQuery("select e from tbl_config_item_sections e ");
            return  query.getResultList();
        }

        else {
            String que = "select e from tbl_config_item_sections e where  e." + paramName + " = '"+value+"'";
            Query query = entityManager.createQuery(que);
            return query.getResultList();
        }
    }


//********************************************************************************




    public  List  getItems (String TableName,String nameparam) {
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
            query = entityManager.createQuery("select entity from tbl_config_items entity");
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

    public  List<tbl_entities> othertest (String queryString) {

         Query query = entityManager.createQuery( queryString );

        return query.getResultList();
    }


   public  List<tbl_entities> getEntities (String nameparam) {


/*test*/  Query test_select_inside = entityManager.createQuery("select t1.config_items_id from tbl_config_items as t1 " +
                "where t1.config_items_id in (select e.config_items_id from tbl_config_items e) " );

        Query query = entityManager.createQuery("select e from tbl_config_item_types e");

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
                 "and ent.entity_types_id = 1" +
                " left join tbl_config_souces as c_sources on c_sources.config_sources_id = c_items.config_sources_id " +
                " left join tbl_config_source_types as cs_types on cs_types.config_source_types_id = c_sources.config_source_types_id" +
              //  " where ent.entity_types_id = 1" +
                " where (  lower(c_items.config_item_name) like '%'||:SearchSt||'%' or  lower(c_items.config_item_description) like '%'||:SearchSt||'%')" +
                 " order by c_items.config_item_name");  //where ent.entity_types_id = 1
       /* set parameter */   query2.setParameter("SearchSt", nameparam.toLowerCase());

        //*************** this is select with parents and childs *************************
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

                " left join tbl_config_source_types as stypes on s.config_source_types_id = stypes.config_source_types_id " + " "
        );

        long i = 2;
       tbl_entity_types  a = entityManager.find(tbl_entity_types.class,i);


       List <tbl_entity_types> ArrResult = new ArrayList<tbl_entity_types>();

        ArrResult.add(a);

        //return query2.getResultList();
       return query2.getResultList();
    }
// end




    private boolean sing_new = false;
    private void mylog(String my_message){
        String filename = "C:/java_projects/javalog.txt";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            if(!sing_new)
            {
                sing_new = true;
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename, false), "UTF-8"));
                pw.println( "1. " + cal.getTime() +" : "+ my_message);
                pw.close();
                return;
            }
            else {

                PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"));
                pw.println(" " + cal.getTime()+ " : " + my_message);
                pw.close();
            }
        }catch (Exception ex) {;}
    }

}
